package com.example.controller;

import com.example.model.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ConfigController {

    @GetMapping("create")
    public ModelAndView showCreateConfig(){
        ModelAndView modelAndView = new ModelAndView("/create");
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("VietNamese");
        languageList.add("Japan");
        languageList.add("Chinese");
        modelAndView.addObject("config",new Config());
        modelAndView.addObject("languageList",languageList);
        return modelAndView;
    }
    @PostMapping("save")
    public ModelAndView saveConfig(Config config){
        ModelAndView modelAndView = new ModelAndView("/display");
        modelAndView.addObject("config",config);
        return modelAndView;
    }
}
