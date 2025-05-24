package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.model.Instructor;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;

//Mario A
@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    //guarda el instructor
    public String almacenar(Instructor instructor){
        instructorRepository.save(instructor);
        return "Instructor guardado";
    }

    //muestra lista de instructores
    public List<Instructor> listar(){
        return instructorRepository.findAll();
    }

    //loguea si correo y contrasena coinciden
    public String loguear(String correo, String contrasena){

        //si el correo del usuario existe
        if(instructorRepository.findByCorreo(correo).isPresent()){
            Instructor instructor = instructorRepository.findByCorreo(correo).get();
            //si el correo coincide
            if(instructor.getContrasena().equals(contrasena)){      //DEBE SER EQUALS
                return "Instructor logueado correctamente";
            }
            else{
                return "Contraseña no coincide";
            }
        }
        else{
            return "Correo no está registrado";
        }
    }

    //elimina instructor por rut
    public String eliminar(String rut){
        //validacion
        if(instructorRepository.findByRut(rut).isPresent()){
            //lo trae
            Instructor instructor = instructorRepository.findByRut(rut).get();
            //lo borra
            instructorRepository.delete(instructor);

            return "Instructor borrado exitosamente";
        }
        else{
            return "Instructor no encontrado";
        }
    }
}
