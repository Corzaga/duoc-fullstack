package cl.duoc.fullstack.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.model.Profesor;
import cl.duoc.fullstack.edutech.repository.ProfesorRepository;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository; 

    @PostMapping
    public String registrarProfesor(@RequestBody Profesor profesor){
        profesorRepository.save(profesor);
        return "Profesor guardado";
    }
}
