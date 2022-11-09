package isil.pe.springdatajpa.service;

import isil.pe.springdatajpa.entity.Curso;
import isil.pe.springdatajpa.entity.Sede;
import isil.pe.springdatajpa.repository.CursoRepository;
import isil.pe.springdatajpa.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public void addCurso(Curso curso){
        cursoRepository.save(curso);
    }

    public List<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id){

        Optional<Curso> curso = cursoRepository.findById(id);

        if(curso.isPresent())
        {
            return curso.get();
        } else
        {
            return null;
        }
    }
}
