package org.example.controller;









import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.dao.UserDao;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        return "login.html";
    }

    @GetMapping("")
    public String register(){
        return "register.html";
    }

    @PostMapping("/auth/register")
    public String register(
HttpServletRequest userRegisterRequest
//             UserRegisterRequest userRegisterRequest
    ) {
        boolean isSuccess = userService.addUser(new UserRegisterRequest(userRegisterRequest));
        return isSuccess ? "login.html" : "register.html";
    }

    @PostMapping("/auth/login")
    public ModelAndView login(
            @ModelAttribute UserLoginRequest userLoginRequest,
             HttpServletRequest httpServletRequest,
            ModelAndView modelAndView,
           ModelMap model
    ){
        User login = userService.login(userLoginRequest);
        List<Integer> users = List.of(1,2,3,4);
        model.put("inf",users);

        if(login!=null){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userId",login.getId());
            modelAndView.setViewName("index.html");
            modelAndView.addObject("isSucces", "Log in");





//            HttpSession session1=httpServletRequest.getSession(false);
//            Object userId = session1.getAttribute("userId");

        }
        else {
            modelAndView.setViewName("register.html");
            modelAndView.addObject("isSucces", "Login falied password or username isnot correct");

        }
        return modelAndView;
    }
}
