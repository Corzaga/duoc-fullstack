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


import cl.duoc.fullstack.edutech.dto.ResenaCursoDTO;
import cl.duoc.fullstack.edutech.model.ResenaCurso;
import cl.duoc.fullstack.edutech.service.ResenaCursoService;

@RestController
@RequestMapping("/Resenas")
public class ResenaCursoController {


    @Autowired
    ResenaCursoService resenaCursoService;


    //Metodo almacenar        "nombreAlumno"="",  "descripcio":"", "seccionCurso":"", "calificacion":int;
    


    @PostMapping
    public String almacenar (@RequestBody ResenaCursoDTO resenaCursoDTO){
        return resenaCursoService.almacenar(resenaCursoDTO);
    }

    //Metodo listar
    @GetMapping
    public List <ResenaCurso> listar(){
        return resenaCursoService.listar();
    }

    //Metodo eliminar
    @DeleteMapping("/{seccionCurso}/{nombreAlumno}")
    public String eliminar(@PathVariable String seccionCurso,@PathVariable String nombreAlumno){
        return resenaCursoService.eliminar(seccionCurso, nombreAlumno);
    }
}
