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
import cl.duoc.fullstack.edutech.dto.IncidenciaCursoDTO;
import cl.duoc.fullstack.edutech.model.IncidenciaCurso;
import cl.duoc.fullstack.edutech.service.IncidenciaCursoService;


@RestController
@RequestMapping("/incidencias")
public class IncidenciaCursoController {

    @Autowired
    private IncidenciaCursoService incidenciaCursoService;
    
    //sube una incidencia descripcion/estadoIncidencia bool/nombreSeccion
    @PostMapping
    public String subirIncidencia(@RequestBody IncidenciaCursoDTO dto) {
        return incidenciaCursoService.guardar(dto);
    }

    //listar todas las incidencias
    @GetMapping("/admin")    
    public List<IncidenciaCurso> listar() {
        return incidenciaCursoService.listarIncidencias();
    }

    // @PutMapping
    // public ResponseEntity<String> actualizarIncidencia(@RequestBody IncidenciaCursoDTO dto) {
    //     String respuesta = incidenciaCursoService.actualizarIncidencia(dto);
    //     if (respuesta.contains("correctamente")) {
    //         return ResponseEntity.ok(respuesta);
    //     }
    //     return ResponseEntity.badRequest().body(respuesta);
    // }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        return incidenciaCursoService.eliminarIncidencia(id);
    }
    
}


