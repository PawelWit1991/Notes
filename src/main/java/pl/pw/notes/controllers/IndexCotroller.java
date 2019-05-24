package pl.pw.notes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCotroller {

@RequestMapping("/")
    String index(){
    return "index";
    }
}
