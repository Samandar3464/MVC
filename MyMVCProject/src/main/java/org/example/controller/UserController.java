//package org.example.controller;
//
//import org.example.dao.UserDao;
//import org.example.dto.UserRegisterRequest;
//import org.example.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/auth")
//public class UserController {
//    private final UserService userService;
//    private final UserDao userDao;
//
//    @Autowired
//    public UserController(UserService userService, UserDao userDao) {
//        this.userService = userService;
//        this.userDao = userDao;
//    }
//
//
//    @PostMapping("/register")
//    public String register(
//            Model model,
//            @ModelAttribute UserRegisterRequest userRegisterRequest
//    ) {
//        boolean isSuccess = userService.addUser(userRegisterRequest);
//        return isSuccess ? "login" : "register";
//    }
//}
