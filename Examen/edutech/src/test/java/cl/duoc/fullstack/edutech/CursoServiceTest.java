package cl.duoc.fullstack.edutech;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.service.CursoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

//Pablo Morales
@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    void testAlmacenarCurso() {
        Curso curso = new Curso();
        curso.setNombreSeccion("005v");

        when(cursoRepository.findByNombreSeccion("005v")).thenReturn(Optional.empty());

        String resultado = cursoService.almacenar(curso);

        assertEquals("Curso guardado", resultado);
        verify(cursoRepository).findByNombreSeccion("005v");
        verify(cursoRepository).save(curso);
      
    }

    
    @Test
    void testAlmacenarCursoExistente() {
        Curso curso = new Curso();
        curso.setNombreSeccion("005v");

        when(cursoRepository.findByNombreSeccion("005v")).thenReturn(Optional.of(curso));

        String resultado = cursoService.almacenar(curso);

        assertEquals("Ya existe un curso con la sección: 005v", resultado);
        verify(cursoRepository).findByNombreSeccion("005v");
        verify(cursoRepository, never()).save(any(Curso.class));

    }

    @Test
    void testBuscarCursoSeccion() {
    Curso curso = new Curso();
    curso.setNombreCurso("full");
    curso.setNombreSeccion("005v");

    when(cursoRepository.findByNombreSeccion("005v")).thenReturn(Optional.of(curso));

    String resultado = cursoService.buscarPorNombreSeccion("005v");

    assertEquals("Curso encontrado: full", resultado);
    verify(cursoRepository).findByNombreSeccion("005v");
}
    @Test
    void testEliminarCursoInexistente() {
    when(cursoRepository.findByNombreSeccion("006v")).thenReturn(Optional.empty());

    String resultado = cursoService.eliminar("006v");

    assertEquals("El curso no existe", resultado);
    verify(cursoRepository).findByNombreSeccion("006v");
    verify(cursoRepository, never()).delete(any(Curso.class));
}

}