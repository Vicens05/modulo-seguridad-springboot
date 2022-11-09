package isil.pe.springdatajpa.controller;

import isil.pe.springdatajpa.entity.Curso;
import isil.pe.springdatajpa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping("/add")
    public void addCurso(@RequestBody Curso curso){
        cursoService.addCurso(curso);
    }

    @GetMapping({"/","getall"})
    public List<Curso> getAllCategories(){
        return cursoService.getAllCursos();
    }

    @GetMapping("/getbyid")
    public Curso getCursoById(@RequestParam Long id){
        return cursoService.getCursoById(id);
    }
}
