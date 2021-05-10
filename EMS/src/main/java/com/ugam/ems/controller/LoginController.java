package com.ugam.ems.controller;

import com.ugam.ems.entity.Users;
import com.ugam.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") Users loginForm, Model model) throws Exception {
        Users returnValue = userService.findUser(loginForm);
        if (returnValue != null && returnValue.getUsername().equals(loginForm.getUsername()) && returnValue.getPassword().equals(loginForm.getPassword())) {
            return "input";
        } else {
            model.addAttribute("InvalidCredential", true);
            return "index";
        }
    }
}
