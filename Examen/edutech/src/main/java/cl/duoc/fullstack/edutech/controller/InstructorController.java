package cl.duoc.fullstack.edutech.controller;
import cl.duoc.fullstack.edutech.service.InstructorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.model.Instructor;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    //se guarda el instructor  rut, nombre, apellido, correo, contrasena, clase
    @PostMapping
    public String almacenar(@RequestBody Instructor instructor){
        instructorService.almacenar(instructor);
        return "Instructor guardado";
    }

    //se pide la lista de instructores
    @GetMapping
    public List<Instructor> listar(){
        return instructorService.listar();
    }

    //logueo de instructor por correo y contrasena
    @GetMapping("/login/{correo}/{contrasena}")
    public String loguear(@PathVariable String correo, @PathVariable String contrasena){
        return instructorService.loguear(correo, contrasena);
    }

    //se borra instructor por rut
    @DeleteMapping("/{rut}")
    public String eliminar(@PathVariable String rut){
        return instructorService.eliminar(rut);
    }
}
