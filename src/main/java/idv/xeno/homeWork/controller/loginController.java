package idv.xeno.homeWork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="/login")  
    public  String login(){  
    	System.out.println("index!");
//        ModelAndView  model = new ModelAndView("/index");   
//        return model;  
    	return "index";
    }
}
