package main.oracle.academy.fp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler{

    @RequestMapping(value="/404")
    public String error404(){
        System.out.println("page not found handler");
        return "error/error-404";
    }

    @RequestMapping(value="/403")
    public String error403(){
        System.out.println("access denied handler");
        return "error/error-403";
    }

}
