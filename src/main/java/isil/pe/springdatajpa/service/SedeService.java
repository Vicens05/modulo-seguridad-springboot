package isil.pe.springdatajpa.service;

import isil.pe.springdatajpa.entity.Sede;
import isil.pe.springdatajpa.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public void addSede(Sede sede){
        sedeRepository.save(sede);
    }

    public List<Sede> getAllSedes(){
        return sedeRepository.findAll();
    }

    public Sede getSedeById(Long id){

        Optional<Sede> sede = sedeRepository.findById(id);

        if(sede.isPresent())
        {
            return sede.get();
        } else
        {
            return null;
        }
    }
}
