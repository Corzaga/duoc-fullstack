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

import cl.duoc.fullstack.edutech.dto.RespuestaForoDTO;
import cl.duoc.fullstack.edutech.model.RespuestaForo;
import cl.duoc.fullstack.edutech.service.RespuestaForoService;

@RestController
@RequestMapping("/respuestas")
public class RespuestaForoController {

    @Autowired
    private RespuestaForoService respuestaService;

    //lsita las respuestas
    @GetMapping("/admin")
    public List<RespuestaForo> listar(){
        return respuestaService.obtenerTodas();
    }

    @GetMapping
    public List<RespuestaForoDTO> listarRespuestas() {
    return respuestaService.listarRespuestas();
}
    //sube una respuesta  "respuesta":"", "idForoCurso": int, "rutAlumno":""
    @PostMapping
    public String guardarRespuesta(@RequestBody RespuestaForoDTO dto) {
        return respuestaService.guardarRespuesta(dto);
    }
    //borra respuesta por id
    @DeleteMapping("/borrar/{id}")
    public String eliminar(@PathVariable Integer id ){
        return respuestaService.eliminarRespuesta(id);
    }


}
