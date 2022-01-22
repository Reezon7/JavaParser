package com.simbirsoftapp.javaparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class ControllerApp {

    @Autowired
    public ServiceApp serviceApp;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @PostMapping("/home")
    public String getResult(Model model, @RequestParam("url") String url) throws IOException {
        List<Statistic> resultListOfWords = serviceApp.analyzeUrl(url);
        model.addAttribute("statistic",resultListOfWords);
        return "home";
    }

}
