package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@RequestMapping("/")
@Controller
public class HomeController {

    @RequestMapping("")
    public String home(Model model) {
        model.addAttribute("time", LocalDateTime.now());
        return "index";
    }

    @RequestMapping("/time")
    public ModelAndView home2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("time", LocalDateTime.now());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
