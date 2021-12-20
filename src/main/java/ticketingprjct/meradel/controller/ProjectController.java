package ticketingprjct.meradel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ticketingprjct.meradel.dto.ProjectDTO;
import ticketingprjct.meradel.enums.Status;
import ticketingprjct.meradel.service.ProjectService;
import ticketingprjct.meradel.service.UserService;

import javax.jws.WebParam;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String projectCreat(Model model){
        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/create";
    }


    @PostMapping("/create")
    public String insertProject(ProjectDTO projectDTO){

        projectService.save(projectDTO);
        projectDTO.setProjectStatus(Status.OPEN);
        return "redirect:/project/create";
    }


    @GetMapping("delete/{id}")
    public String deleteProject(@PathVariable("id") String id ){
        projectService.deleteById(id);
        return "redirect:/project/create";
    }


    @GetMapping("complete/{id}")
    public String completeProject(@PathVariable("id") String id ){
       projectService.complete(projectService.findById(id));
       return "redirect:/project/create";
    }

    @GetMapping("update/{id}")
    public String updateProject(@PathVariable("id") String id , ProjectDTO projectDTO, Model model){

        model.addAttribute("project", projectService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "project/create";
    }

    @PostMapping("update/{id}")
    public String editProject(@PathVariable("id") String id, ProjectDTO projectDTO ){
        projectService.update(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/manager/complete")
    public String getProjectByManager(){

        return "/manager/project-status";
    }



}
