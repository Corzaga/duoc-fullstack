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

import cl.duoc.fullstack.edutech.dto.ForoCursoDTO;
import cl.duoc.fullstack.edutech.model.ForoCurso;

import cl.duoc.fullstack.edutech.service.ForoCursoService;

@RestController
@RequestMapping("/foros")
public class ForoCursoController {
    @Autowired
    private ForoCursoService foroService;
     
    //en lista todas las preguntas
    @GetMapping("/admin")
    public List<ForoCurso> listar(){
        return foroService.listar();
    }
    //listar dto
    @GetMapping
    public List<ForoCursoDTO> listardto() {
    return foroService.listardto();
}

    //sube una pregunta  con pregunta/rutAlumno/nombreseccion
    @PostMapping
    public String subirPregunta(@RequestBody ForoCursoDTO foroCursoDTO) {
        return foroService.guardarForo(foroCursoDTO);
    }

    //borra una pregunta y borra su respuesta por el metodo cascada
    @DeleteMapping("/borrar/{id}")
    public String eliminarPregunta(@PathVariable Integer id) {
        return foroService.eliminarPreguntaPorId(id);
    }


}
