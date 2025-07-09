package cl.duoc.fullstack.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.dto.EvaluacionCursoDTO;
import cl.duoc.fullstack.edutech.model.EvaluacionCurso;
import cl.duoc.fullstack.edutech.service.EvaluacionCursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionCursoController {
    
    @Autowired
    private EvaluacionCursoService evaluacionCursoService;

    //Metodo almacenar nombreEvaluacion, tipoEvaluacion, descripcion, instructor(rut), seccionCurso(nombreSeccion)
    @PostMapping
    public String almacenar (@RequestBody EvaluacionCursoDTO evaluacionCursoDTO){
        return evaluacionCursoService.almacenar(evaluacionCursoDTO);
    }

    //Metodo listar
    @GetMapping
    public List<EvaluacionCurso> listar() {
        return evaluacionCursoService.listar();
    }

    //Metodo para eliminar
    @DeleteMapping("/{seccionCurso}/{nombreEvaluacion}")
    public String eliminar(@PathVariable String seccionCurso,@PathVariable String nombreEvaluacion){
        return evaluacionCursoService.eliminar(seccionCurso, nombreEvaluacion);
    }
    

}
