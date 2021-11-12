package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String pageMain() {
        return "user/mainPage";
    }

@GetMapping("/user")
    public String getUserPage(ModelMap model, Principal principal){
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "user/userProfile";
    }




}