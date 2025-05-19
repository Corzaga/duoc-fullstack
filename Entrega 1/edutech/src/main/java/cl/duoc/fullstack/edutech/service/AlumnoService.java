package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    //se guarda alumno como tal
    public String almacenar(Alumno alumno){
        alumnoRepository.save(alumno);
        //no hay validacion
        return "Alumno guardado correctamente";
    }
    
    //aca deberia ser con DTO??
    public List<Alumno> listar(){
        return alumnoRepository.findAll();
    }
}
