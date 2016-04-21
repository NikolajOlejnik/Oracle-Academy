package main.oracle.academy.fp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorController {

    @RequestMapping(value="/400")
    public String error400(){
        System.err.println("error 400");
        return "errors/400";
    }

    @RequestMapping(value="/403")
    public String error403(){
        System.err.println("error 403");
        return "errors/403";
    }

    @RequestMapping(value="/404")
    public String error404(){
        System.err.println("error 404");
        return "errors/404";
    }

    @RequestMapping(value="/405")
    public String error405(){
        System.err.println("error 405");
        return "errors/405";
    }


}
