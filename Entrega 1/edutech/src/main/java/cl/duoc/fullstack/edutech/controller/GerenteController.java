package cl.duoc.fullstack.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping
    public String almacenar(@RequestBody Gerente gerente){
        return gerenteService.almacenar(gerente);
    }

    @GetMapping
    public List<Gerente> listar(){
        return gerenteService.listar();
    }

}
