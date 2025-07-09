package cl.duoc.fullstack.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.fullstack.edutech.model.Alumno;
import cl.duoc.fullstack.edutech.repository.AlumnoRepository;
import cl.duoc.fullstack.edutech.service.AlumnoService;
//Mario Aguilera
@ExtendWith(MockitoExtension.class) //indica que usaremos Mockito para inyectar mocks
public class AlumnoServiceTest {

    @Mock //crea un mock (simulación) del repositorio de alumnos
    private AlumnoRepository alumnoRepository;

    @InjectMocks //inyecta el mock en la instancia real del servicio para pruebas
    private AlumnoService alumnoService;

    @Test
    void almacenarAlumnoExistente() {
        Alumno alumno = new Alumno();
        alumno.setRut("11.111.111"); //rut de ej
        //simulamos que el alumno ya existe en la base de datos
        when(alumnoRepository.findByRut("11.111.111")).thenReturn(Optional.of(alumno));

        String resultado = alumnoService.almacenar(alumno);

        //validamos que el resultado sea el mensaje esperado
        assertEquals("El alumno ya existe", resultado);
    }

    @Test
    void almacenarAlumnoNuevo() {
        Alumno alumno = new Alumno();
        alumno.setRut("11.111.111"); //rut de ej
        //simulamos que el alumno no existe
        when(alumnoRepository.findByRut("11.111.111")).thenReturn(Optional.empty());

        String resultado = alumnoService.almacenar(alumno);

        //verificamos que el método save haya sido llamado con el alumno
        verify(alumnoRepository).save(alumno);
        //validamos el mensaje esperado tras guardar el alumno
        assertEquals("Alumno guardado", resultado);
    }

    @Test
    void listarAlumnos() {
        //creamos una lista simulada con dos alumnos
        List<Alumno> lista = Arrays.asList(new Alumno(), new Alumno());
        //simulamos que findAll retorna esa lista
        when(alumnoRepository.findAll()).thenReturn(lista);

        List<Alumno> resultado = alumnoService.listar();

        //validamos que el tamaño de la lista retornada sea 2
        assertEquals(2, resultado.size());
    }

    @Test
    void loguearCorreoNoRegistrado() {
        //simulamos que no existe alumno con ese correo
        when(alumnoRepository.findByCorreo("nombre@correo.cl")).thenReturn(Optional.empty());

        String resultado = alumnoService.loguear("nombre@correo.cl", "1234");

        //validamos mensaje esperado cuando el correo no está en la base
        assertEquals("El correo no esta registrado", resultado);
    }

    @Test
    void loguearContrasenaIncorrecta() {
        Alumno alumno = new Alumno();
        alumno.setCorreo("nombre@correo.cl");
        alumno.setContrasena("1234");
        //simulamos que existe el alumno con ese correo
        when(alumnoRepository.findByCorreo("nombre@correo.cl")).thenReturn(Optional.of(alumno));

        String resultado = alumnoService.loguear("nombre@correo.cl", "9999");

        //validamos mensaje cuando la contrasena no coincide
        assertEquals("Contraseña no coincide con mail", resultado);
    }

    @Test
    void loguearCorrecto() {
        Alumno alumno = new Alumno();
        alumno.setCorreo("nombre@correo.cl");
        alumno.setContrasena("1234");
        //simulamos que existe el alumno con ese correo y contrasena
        when(alumnoRepository.findByCorreo("nombre@correo.cl")).thenReturn(Optional.of(alumno));

        String resultado = alumnoService.loguear("nombre@correo.cl", "1234");

        //validamos mensaje de éxito en login
        assertEquals("Alumno logueado corectamente", resultado);
    }

    @Test
    void eliminarAlumnoExistente() {
        Alumno alumno = new Alumno();
        alumno.setRut("11.111.111");
        //simulamos que existe el alumno con ese rut
        when(alumnoRepository.findByRut("11.111.111")).thenReturn(Optional.of(alumno));

        String resultado = alumnoService.eliminar("11.111.111");

        //verificamos que se haya llamado a delete con el alumno
        verify(alumnoRepository).delete(alumno);
        //validamos mensaje de éxito al eliminar
        assertEquals("Alumno borrado exitosamente", resultado);
    }

    @Test
    void eliminarAlumnoNoEncontrado() {
        //simulamos que no existe alumno con ese rut
        when(alumnoRepository.findByRut("11.111.111")).thenReturn(Optional.empty());

        String resultado = alumnoService.eliminar("11.111.111");

        //validamos mensaje cuando no se encuentra el alumno
        assertEquals("Alumno no encontrado", resultado);
    }
}
