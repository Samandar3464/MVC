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
        return "login";
    }

    @GetMapping("")
    public String register(){
        return "register";
    }

    @PostMapping("/auth/register")
    public ModelAndView register(
//HttpServletRequest userRegisterRequest
             UserRegisterRequest userRegisterRequest,
             ModelAndView modelAndView
    ) {
        boolean isSuccess = userService.addUser(userRegisterRequest);
        if(isSuccess){
            modelAndView.setViewName("login");
        }
        else {
            modelAndView.setViewName("register");
            modelAndView.addObject("isSucces","This user alredy registreted!!");
        }
        return modelAndView;
    }

    @PostMapping("/auth/login")
    public ModelAndView login(
            @ModelAttribute UserLoginRequest userLoginRequest,
             HttpServletRequest httpServletRequest,
            ModelAndView modelAndView

    ){
        User login = userService.login(userLoginRequest);

        if(login!=null){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userId",login.getId());
            modelAndView.setViewName("index");
            modelAndView.addObject("isSucces", login);





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
