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

import cl.duoc.fullstack.edutech.dto.ContenidoCursoDTO;
import cl.duoc.fullstack.edutech.model.ContenidoCurso;
import cl.duoc.fullstack.edutech.service.ContenidoCursoService;

@RestController
@RequestMapping("/contenidos")
public class ContenidoCursoController {

    @Autowired
    private ContenidoCursoService contenidoCursoService;

    //Metodo almacenar      descripcion:"", unidad:"",seccionCurso:"",instructor:""
       
        
      
    @PostMapping
    public String almacenar (@RequestBody ContenidoCursoDTO contenidoCursoDTO ){
        
        return contenidoCursoService.almacenar(contenidoCursoDTO);
    }

    //Metodo listar
    @GetMapping
    public List<ContenidoCurso> listar(){
        return contenidoCursoService.listar();
    }

    //Metodo Eliminar contenidoCurso
    @DeleteMapping("/{curso}/{unidad}")
    public String eliminar(@PathVariable String curso,@PathVariable String unidad){
        return contenidoCursoService.eliminar(curso, unidad);
    }

}
