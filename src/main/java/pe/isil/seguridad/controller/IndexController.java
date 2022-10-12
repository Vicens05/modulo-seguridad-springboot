package pe.isil.seguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.seguridad.model.User;
import pe.isil.seguridad.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Qualifier("userServiceLocal")
    @Autowired

    private UserService userService;

    //GetMapping asume que usas método Get (Get retorna data)
    @GetMapping({"/","/index","/home"}) //Cada vez que llame a la URL el "/" me retornará el index.html -> http://localhost:8080/
    public String index(Model model){


        model.addAttribute("lstusers", userService.getUsers());
        return "index";
    }


}
