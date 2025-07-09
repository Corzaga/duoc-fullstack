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

import cl.duoc.fullstack.edutech.model.Gerente;
import cl.duoc.fullstack.edutech.service.GerenteService;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    //se guarda el gerente rut, nombre, apellido, correo, contrasena
    @PostMapping
    public String almacenar(@RequestBody Gerente gerente){
        return gerenteService.almacenar(gerente);
    }

    //se loguea con correo y contrasena
    @GetMapping("/login/{correo}/{contrasena}")
    public String loguear(@PathVariable String correo, @PathVariable String contrasena){
        return gerenteService.loguear(correo, contrasena);
    }

    //se pide la lista de gerentes
    @GetMapping
    public List<Gerente> listar(){
        return gerenteService.listar();
    }

    //se borra gerente por rut
    @DeleteMapping("/{rut}")
    public String eliminar(@PathVariable String rut){
        return gerenteService.eliminar(rut);
    }

}
