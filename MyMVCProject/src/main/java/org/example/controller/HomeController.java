package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class HomeController {
        private final UserService userService;
    private final UserDao userDao;


    public HomeController(UserService userService, UserDao userDao) {
        this.userService = userService;
        this.userDao = userDao;
    }
    @GetMapping("login")
    public String home(){
        return "login";
    }

    @GetMapping("")
    public String register(){
        return "register";
    }

    @PostMapping("/auth/register")
    public String register(

          HttpServletRequest userRegisterRequest
    ) {
        boolean isSuccess = userService.addUser(new UserRegisterRequest(userRegisterRequest));
        return isSuccess ? "login" : "register";
    }

    @PostMapping("/auth/login")
    public String login(
            @ModelAttribute UserLoginRequest userLoginRequest
    ){
        User login = userService.login(userLoginRequest);
        if(login!=null){
            return "news/addNews";
        }
        else {
            return "register";
        }
    }
}
