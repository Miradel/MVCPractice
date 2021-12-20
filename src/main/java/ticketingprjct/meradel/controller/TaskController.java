package ticketingprjct.meradel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ticketingprjct.meradel.dto.TaskDTO;
import ticketingprjct.meradel.enums.Status;
import ticketingprjct.meradel.service.ProjectService;
import ticketingprjct.meradel.service.TaskService;
import ticketingprjct.meradel.service.UserService;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployee());
        model.addAttribute("tasks",taskService.findAll());

        return "task/create";
    }


    @PostMapping("/create")
    public String insertTask(Model model, TaskDTO taskDTO){

        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        taskDTO.setId(UUID.randomUUID().getMostSignificantBits());
        taskService.save(taskDTO);
        return "redirect:/task/create";

    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";

    }


    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployee());
        model.addAttribute("tasks",taskService.findAll());
        return "/task/update";

    }

    @PostMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, TaskDTO taskDTO, Model model){
        taskService.update( taskDTO );
        return "redirect:/task/create";
    }


}
