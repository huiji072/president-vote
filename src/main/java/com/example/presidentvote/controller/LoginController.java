package com.example.presidentvote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login/memberLogin")
    public String createForm() {
        return "/login/memberLogin";
    }

    @PostMapping("/login/memberLogin")
    public String login(){
        //내용작성
        return "redirect:/";
    }

}
