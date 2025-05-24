package cl.duoc.fullstack.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.service.AlumnoService;

//Mario A
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    //se guarda el alumno
    @PostMapping
    public String almacenar(@RequestBody Alumno alumno){
        return alumnoService.almacenar(alumno);
    }

    //se retorna la lista de alumnos
    @GetMapping
    public List<Alumno> listar(){
        return alumnoService.listar();
    }

    //se loguea el alumno
    @GetMapping("/login/{correo}/{contrasena}")
    public String loguear(String correo, String contrasena){
        return alumnoService.loguear(correo, contrasena);
    }

    //alumno se borra por rut
    @DeleteMapping("/{rut}")
    public String eliminar(@PathVariable String rut){
        return alumnoService.eliminar(rut);
    }

}