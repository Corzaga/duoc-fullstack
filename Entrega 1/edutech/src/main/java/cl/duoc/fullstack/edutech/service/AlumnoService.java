package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;

//Mario A
@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    //se guarda alumno
    public String almacenar(Alumno alumno){
        alumnoRepository.save(alumno);
        //no hay validacion
        return "Alumno guardado correctamente";
    }
    
    //aca deberia ser con DTO??
    public List<Alumno> listar(){
        return alumnoRepository.findAll();
    }

    //"loguea" si correo y contrasena coinciden
    public String loguear(String correo, String contrasena){

        //si el correo del usuario existe
        if(alumnoRepository.findByCorreo(correo).isPresent()){
            Alumno alumno = alumnoRepository.findByCorreo(correo).get();

            //si la contrasena coincide
            if(alumno.getContrasena() == contrasena){
                return "Alumno logueado corectamente";
            }
            else{
                return "Contraseña no coincide con mail";
            }
        }
        else{
            return "El correo no esta registrado";
        }
    }
    //borrar alumno por rut
    public String eliminar(String rut){

        //valida si existe el usuario con ese rut
        if(alumnoRepository.findByRut(rut).isPresent()){
            //lo trae
            Alumno alumno = alumnoRepository.findByRut(rut).get();
            //lo borra
            alumnoRepository.delete(alumno);

            return "Alumno borrado exitosamente";
        }
        else{
            return "Alumno no encontrado";
        }
    }


}
