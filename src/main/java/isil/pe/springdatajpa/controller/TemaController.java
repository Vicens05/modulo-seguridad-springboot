package isil.pe.springdatajpa.controller;

import isil.pe.springdatajpa.entity.Item;
import isil.pe.springdatajpa.entity.Tema;
import isil.pe.springdatajpa.service.ItemService;
import isil.pe.springdatajpa.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @PostMapping("/add")
    public void addTema(@RequestBody Tema tema){
        temaService.addTema(tema);
    }

    @GetMapping({"/","getall"})
    public List<Tema> getAllTemas(){
        return temaService.getAllTemas();
    }

    @GetMapping("/getbyid")
    public Tema getTemaById(@RequestParam Long id){
        return temaService.getTemaById(id);
    }
}
