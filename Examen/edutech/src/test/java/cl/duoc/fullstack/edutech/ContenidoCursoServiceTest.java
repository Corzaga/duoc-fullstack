package cl.duoc.fullstack.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import cl.duoc.fullstack.edutech.dto.ContenidoCursoDTO;
import cl.duoc.fullstack.edutech.model.ContenidoCurso;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.model.Instructor;
import cl.duoc.fullstack.edutech.repository.ContenidoCursoRepository;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;
import cl.duoc.fullstack.edutech.service.ContenidoCursoService;
//Brandon Sepulveda
// 6 TEST UNITARIOS

@ExtendWith(MockitoExtension.class)
public class ContenidoCursoServiceTest {

    // Creacion de repositorios locales
    @Mock
    private InstructorRepository instructorRepository;

    @Mock
    private ContenidoCursoRepository contenidoCursoRepository;

    @Mock
    private CursoRepository cursoRepository;

    // Inyeccion de servicios 
    @InjectMocks
    private ContenidoCursoService contenidoCursoService;

    @Test
    void almacenarCorrectamente() {
        ContenidoCursoDTO dto = new ContenidoCursoDTO();
        dto.setSeccionCurso("A1");
        dto.setInstructor("12345678-9");
        dto.setUnidad("Unidad 1");
        dto.setDescripcion("Contenido de prueba");

        Curso curso = new Curso(); 
        Instructor instructor = new Instructor(); 

        when(cursoRepository.findByNombreSeccion("A1")).thenReturn(Optional.of(curso));
        when(instructorRepository.findByRut("12345678-9")).thenReturn(Optional.of(instructor));
        when(contenidoCursoRepository.findByUnidad("Unidad 1")).thenReturn(Optional.empty());

        String resultado = contenidoCursoService.almacenar(dto);

        assertEquals("Contenido de curso agregado correctamente", resultado);
    }

    @Test
    void almacenarCursoNoExiste() {
        ContenidoCursoDTO dto = new ContenidoCursoDTO();
        dto.setSeccionCurso("B1");
        dto.setInstructor("98765432-1");
        dto.setUnidad("Unidad 2");
        dto.setDescripcion("Contenido alternativo");

        when(cursoRepository.findByNombreSeccion("B1")).thenReturn(Optional.empty());

        String resultado = contenidoCursoService.almacenar(dto);

        assertEquals("El curso no existe", resultado);}

    @Test
    void almacenarInstructorNoExiste() {
        ContenidoCursoDTO dto = new ContenidoCursoDTO();
        dto.setSeccionCurso("C1");
        dto.setInstructor("11111111-1");
        dto.setUnidad("Unidad 3");
        dto.setDescripcion("Otro contenido");

        when(cursoRepository.findByNombreSeccion("C1")).thenReturn(Optional.of(new Curso()));
        when(instructorRepository.findByRut("11111111-1")).thenReturn(Optional.empty());

        String resultado = contenidoCursoService.almacenar(dto);

        assertEquals("El curso existe pero el instructor no", resultado);
    }

    @Test
    void eliminarCursoCorrectamente() {
        Curso curso = new Curso();
        ContenidoCurso contenido = new ContenidoCurso();
        contenido.setUnidad("Unidad X");

        when(cursoRepository.findByNombreSeccion("Z1")).thenReturn(Optional.of(curso));
        when(contenidoCursoRepository.findByUnidad("Unidad X")).thenReturn(Optional.of(contenido));

        String resultado = contenidoCursoService.eliminar("Z1", "Unidad X");

        assertEquals("Contenido eliminado correctamente", resultado);
    }

    @Test
    void eliminarCursoNoEncontrado() {
        when(cursoRepository.findByNombreSeccion("Z2")).thenReturn(Optional.empty());

        String resultado = contenidoCursoService.eliminar("Z2", "Unidad Y");

        assertEquals("Curso no encontrado", resultado);
    }

    @Test
    void eliminarContenidoNoEncontrado() {
        when(cursoRepository.findByNombreSeccion("Z3")).thenReturn(Optional.of(new Curso()));
        when(contenidoCursoRepository.findByUnidad("Unidad Z")).thenReturn(Optional.empty());

        String resultado = contenidoCursoService.eliminar("Z3", "Unidad Z");

        assertEquals("Unidad no encontrada", resultado);
    }


}
