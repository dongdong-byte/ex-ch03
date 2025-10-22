package kim.day10_17_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyThtleaf {

@GetMapping("/hello")
    public String hello(){
    return "hello";
}
    @GetMapping("/thyleaf")
    public String thyleaf(Model model){
    model.addAttribute("message","스프링부트 타임리프 화면");
        return "hello_thyleaf";
    }
    @GetMapping("/mustache")
    public String mustache(Model model){
    model.addAttribute("message","머스태치화면");
    return "hello_mus";


    }
}
