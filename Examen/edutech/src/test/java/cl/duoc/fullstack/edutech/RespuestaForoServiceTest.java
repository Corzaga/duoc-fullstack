package cl.duoc.fullstack.edutech;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.fullstack.edutech.dto.RespuestaForoDTO;
import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.model.ForoCurso;
import cl.duoc.fullstack.edutech.model.RespuestaForo;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.repository.ForoCursoRepository;
import cl.duoc.fullstack.edutech.repository.RespuestaForoRepository;
import cl.duoc.fullstack.edutech.service.RespuestaForoService;
//Pablo Morales
@ExtendWith(MockitoExtension.class)
public class RespuestaForoServiceTest {

    @Mock
    private RespuestaForoRepository respuestaRepository;

    @Mock
    private AlumnoRepository alumnoRepository;

    @Mock
    private ForoCursoRepository foroCursoRepository;

    @InjectMocks
    private RespuestaForoService respuestaForoService;

    @Test
    void testGuardarRespuestaConExito() {
        RespuestaForoDTO dto = new RespuestaForoDTO("Esta es la respuesta", 1, "12345678-9");

        Alumno alumno = new Alumno();
        alumno.setRut("12345678-9");
        alumno.setNombre("Brandon");

        ForoCurso foro = new ForoCurso();
        foro.setIdForoCurso(1);
        foro.setPregunta("¿Cuál es la materia?");

        when(alumnoRepository.findByRut("12345678-9")).thenReturn(Optional.of(alumno));
        when(foroCursoRepository.findById(1)).thenReturn(Optional.of(foro));

        String resultado = respuestaForoService.guardarRespuesta(dto);

        assertTrue(resultado.contains("Respuesta guardada"));
        assertTrue(resultado.contains("Alumno: Brandon"));
        assertTrue(resultado.contains("Pregunta: ¿Cuál es la materia?"));
        assertTrue(resultado.contains("Respuesta: Esta es la respuesta"));
        verify(respuestaRepository).save(any(RespuestaForo.class));
    }

    @Test
    void testGuardarRespuestaAlumnoNoEncontrado() {
        RespuestaForoDTO dto = new RespuestaForoDTO("Respuesta", 1, "12345678-9");

        when(alumnoRepository.findByRut("12345678-9")).thenReturn(Optional.empty());

        String resultado = respuestaForoService.guardarRespuesta(dto);

        assertTrue(resultado.equals("Alumno no encontrado"));
        verify(respuestaRepository, never()).save(any());
    }

    @Test
    void testEliminarRespuestaNoExistente() {
        int idRespuesta = 99;

        when(respuestaRepository.findById(idRespuesta)).thenReturn(Optional.empty());

        String resultado = respuestaForoService.eliminarRespuesta(idRespuesta);

        assertTrue(resultado.equals("Respuesta no encontrada"));
        verify(respuestaRepository, never()).delete(any());
    }
}
