package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.model.Gerente;
import cl.duoc.fullstack.edutech.repository.GerenteRepository;

//Mario A
@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    //guarda gerente
    public String almacenar(Gerente gerente){
        gerenteRepository.save(gerente);
        //no hay validacion aun
        return "Gerente guardado correctamente";
    }

    //retorna lista de gerentes
    public List<Gerente> listar(){
        return gerenteRepository.findAll();
    }

    //loguear gerente por corre y contrasena
    public String loguear(String correo, String contrasena){
        //si el correo del usuario existe
        if(gerenteRepository.findByCorreo(correo).isPresent()){
            Gerente gerente = gerenteRepository.findByCorreo(correo).get();

            //si la contrasena coincide
            if(gerente.getContrasena() == contrasena){
                return "Gerente logueado corectamente";
            }
            else{
                return "Contraseña no coincide con mail";
            }
        }
        else{
            return "El correo no esta registrado";
        }
    }

    //borrar gerente por rut
    public String eliminar(String rut){

        //valida si existe el usuario con ese rut
        if(gerenteRepository.findByRut(rut).isPresent()){
            //lo trae
            Gerente gerente = gerenteRepository.findByRut(rut).get();
            //lo borra
            gerenteRepository.delete(gerente);

            return "gerente borrado exitosamente";
        }
        else{
            return "gerente no encontrado";
        }
    }

}
