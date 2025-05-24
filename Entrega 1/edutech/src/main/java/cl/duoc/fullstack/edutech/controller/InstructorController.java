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

    @PostMapping
    public String almacenar(@RequestBody Instructor instructor){
        instructorService.almacenar(instructor);
        return "Instructor guardado";
    }

    @GetMapping
    public List<Instructor> listar(){
        return instructorService.listar();
    }

    @GetMapping("/{correo}/{contrasena}")
    public String loguear(String correo, String contrasena){
        return instructorService.loguear(correo, contrasena);
    }

    @DeleteMapping("/{rut}")
    public String eliminar(@PathVariable String rut){
        return instructorService.eliminar(rut);
    }
}
