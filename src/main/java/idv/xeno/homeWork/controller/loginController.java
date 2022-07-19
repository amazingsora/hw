package idv.xeno.homeWork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    @RequestMapping("/")
    public String home() {
    	System.out.println("main");
        return "jsp/main";
    }
    @RequestMapping(value="/login")  
    public  String login(){  
    	System.out.println("login!");

    	return "login";
    }
    @RequestMapping(value="/sucess")  
    public  String sucess(){  
    	System.out.println("sucess!");

    	return "jsp/main";
    }
    
    @RequestMapping(value="/fail")  
    public  String fail(){  
    	System.out.println("fail!");

    	return "default/fail";
    }
}
