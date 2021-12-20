package ticketingprjct.meradel.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ticketingprjct.meradel.dto.RoleDTO;
import ticketingprjct.meradel.dto.UserDTO;
import ticketingprjct.meradel.service.RoleService;
import ticketingprjct.meradel.service.UserService;

import javax.jws.WebParam;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @GetMapping( {"/create","/add" } )
    public String createUser(Model model){
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll() );
        model.addAttribute( "users", userService.findAll() );

        return "/user/create";
    }


//    @PostMapping("/create")
//    public String insertUser(Model model, UserDTO user){
//        userService.save(user);
//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());
//        model.addAttribute("users", userService.findAll());
//        return "/user/create";
//    }


    //Same with above method,we used redirect with repeated steps
    @PostMapping("/create")
    public String insertUser(Model model, UserDTO user){
        userService.save(user);
        return "redirect:/user/create";
    }

    /*
    For update the user, we need to make specific user to update, for that we can put that into our endpoint
    By this {}.

    For the user update , there are two method needed :
    1. Get  => binding to click the specific user, return user update page
    2. Post => Binding with the form , return to user create page
     */
    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model, UserDTO userDTO){

        model.addAttribute("user", userService.findById(username) );
        model.addAttribute("users", userService.findAll() );
        model.addAttribute("roles", roleService.findAll());

        return "/user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, Model model, UserDTO userDTO){

        userService.update(userDTO);

        //After click save, it need to bring new user, that is why we use new UserDto
//        model.addAttribute("user",   new UserDTO() );
//        model.addAttribute("roles", roleService.findAll() );
//        model.addAttribute( "users", userService.findAll() );

        return "redirect:/user/create";
    }


    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){

        userService.deleteById(username);
        return "redirect:/user/create";
    }


}
