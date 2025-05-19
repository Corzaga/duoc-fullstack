package cl.duoc.fullstack.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.model.Instructor;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @PostMapping
    public String registrarInstructor(@RequestBody Instructor instructor){
        instructorRepository.save(instructor);
        return "Instructor guardado";
    }
}
