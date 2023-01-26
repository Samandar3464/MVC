package org.example.controller;









import com.sun.net.httpserver.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.dao.UserDao;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "login";
    }

    @GetMapping("")
    public String register(){
        return "register";
    }

    @PostMapping("/auth/register")
    public String register(

            @ModelAttribute UserRegisterRequest userRegisterRequest
    ) {
        boolean isSuccess = userService.addUser(userRegisterRequest);
        return isSuccess ? "login" : "register";
    }

    @PostMapping("/auth/login")
    public ModelAndView login(
            @ModelAttribute UserLoginRequest userLoginRequest,
             HttpServletRequest httpServletRequest,
            ModelAndView modelAndView,
            Request request
    ){
        User login = userService.login(userLoginRequest);
//        List<Integer> users = List.of(1,2,3,4);
        if(login!=null){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userId",login.getId());
            modelAndView.setViewName("index");
            modelAndView.addObject("isSucces", "Log in");





//            HttpSession session1=httpServletRequest.getSession(false);
//            Object userId = session1.getAttribute("userId");

        }
        else {
            modelAndView.setViewName("register");
            modelAndView.addObject("isSucces", "Login falied password or username isnot correct");

        }
        return modelAndView;
    }
}
