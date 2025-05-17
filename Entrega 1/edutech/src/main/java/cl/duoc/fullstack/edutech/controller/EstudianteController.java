package cl.duoc.fullstack.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.model.Estudiante;
import cl.duoc.fullstack.edutech.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @PostMapping
    public String registrarEstudinate(@RequestBody Estudiante estudiante){
        estudianteRepository.save(estudiante);
        return "Estudiante guardado";
    }

}
