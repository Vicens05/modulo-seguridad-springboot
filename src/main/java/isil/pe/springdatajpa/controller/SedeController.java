package isil.pe.springdatajpa.controller;

import isil.pe.springdatajpa.entity.Sede;
import isil.pe.springdatajpa.entity.Tema;
import isil.pe.springdatajpa.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sede")
public class SedeController {
    @Autowired
    private SedeService sedeService;

    @PostMapping("/add")
    public void addSede(@RequestBody Sede sede){
        sedeService.addSede(sede);
    }

    @GetMapping({"/","getall"})
    public List<Sede> getAllSedes(){
        return sedeService.getAllSedes();
    }

    @GetMapping("/getbyid")
    public Sede getSedeById(@RequestParam Long id){
        return sedeService.getSedeById(id);
    }
}
