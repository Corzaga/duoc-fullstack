package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.model.Instructor;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public String almacenar(Instructor instructor){
        instructorRepository.save(instructor);
        return "Instructor guardado";
    }

    public List<Instructor> listar(){
        return instructorRepository.findAll();
    }
}
