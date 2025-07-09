package cl.duoc.fullstack.edutech.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.fullstack.edutech.dto.AgregarUsuarioCursoDTO;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.service.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;
     // guarda un curso /nombreCurso/ nombreSeccion/fechaInicio/fechaTermino
    @PostMapping
    public String almacenar(@RequestBody Curso curso){
        return cursoService.almacenar(curso);
    }
    //lista todo lo que se a guardado y llegue a curso
    @GetMapping("/admin")
    public List<Curso> listar() {
        return cursoService.listar();
    }
    //busca por nomnre seccion
    @GetMapping("/buscar/{nombreSeccion}")
    public String buscar(@PathVariable String nombreSeccion){
        return cursoService.buscarPorNombreSeccion(nombreSeccion);
    }

    //elimina un curso por seccion
    @DeleteMapping("/eliminar/{nombreSeccion}")
    public String eliminar(@PathVariable String nombreSeccion){
        return cursoService.eliminar(nombreSeccion);
    }

    //metodo para asignar alumno a curso  /rut/nombreSeccion
    @PostMapping("/asignaralumno")
    public String asignarAlumnoCurso(@RequestBody AgregarUsuarioCursoDTO agregarUsuarioCursoDTO){
        return cursoService.asignarCursoAlumno(agregarUsuarioCursoDTO);
    }

    //metodo para asignar alumno a curso /rut/nombreSeccion
    @PostMapping("/asignarInstructor")
    public String asignarInstructorCurso(@RequestBody AgregarUsuarioCursoDTO agregarUsuarioCursoDTO){
        return cursoService.asignarCursoInstructor(agregarUsuarioCursoDTO);
    }

}

  




    

    
    


