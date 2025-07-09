package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.dto.ContenidoCursoDTO;
import cl.duoc.fullstack.edutech.model.ContenidoCurso;
import cl.duoc.fullstack.edutech.model.Curso;
import cl.duoc.fullstack.edutech.repository.ContenidoCursoRepository;
import cl.duoc.fullstack.edutech.repository.CursoRepository;
import cl.duoc.fullstack.edutech.repository.InstructorRepository;

@Service
public class ContenidoCursoService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ContenidoCursoRepository contenidoCursoRepository;
    
    @Autowired
    private CursoRepository cursoRepository;



    // Brandon Sepúlveda
    // Guardar contenido curso
    public String almacenar(ContenidoCursoDTO contenidoCursoDTO){
        // Ver si existe el curso a traves de la seccion
        if (!cursoRepository.findByNombreSeccion(contenidoCursoDTO.getSeccionCurso()).isPresent()){
            return "El curso no existe";
        // ver si existe el el instructor
        } else if (!instructorRepository.findByRut(contenidoCursoDTO.getInstructor()).isPresent()){
            return "El curso existe pero el instructor no";
        } else if(contenidoCursoRepository.findByUnidad(contenidoCursoDTO.getUnidad()).isPresent()){
            return "La unidad ya existe";
        } else{
            //Se instancia el curso para guardarlo        
            Curso curso = cursoRepository.findByNombreSeccion(contenidoCursoDTO.getSeccionCurso()).get();
            //Se instancia el contenido para encapsularlo y guardarlo
            ContenidoCurso contenidoCurso = new ContenidoCurso();
            contenidoCurso.setCurso(curso);
            contenidoCurso.setDescripcion(contenidoCursoDTO.getDescripcion());
            contenidoCurso.setUnidad(contenidoCursoDTO.getUnidad());
            contenidoCursoRepository.save(contenidoCurso);
            return "Contenido de curso agregado correctamente";
    }
    }

    // Brandon Sepúlveda
    // Listar contenido curso
    public List<ContenidoCurso> listar(){
        return contenidoCursoRepository.findAll();
    }

    // Brandon Sepúlveda
    // Eliminar contenido curso
    public String eliminar(String seccion, String unidad){
        if(contenidoCursoRepository.findByUnidad(unidad).isPresent() && cursoRepository.findByNombreSeccion(seccion).isPresent()){
            //Encapsula el contenido
            ContenidoCurso contenidoCurso = contenidoCursoRepository.findByUnidad(unidad).get();
            //Lo elimina
            contenidoCursoRepository.delete(contenidoCurso);
            return"Contenido eliminado correctamente";
        } else if (!cursoRepository.findByNombreSeccion(seccion).isPresent()){
            return"Curso no encontrado";
        }else{
            return "Unidad no encontrada";
        }
    }

    /* 
    // Brandon Sepúlveda
    // Modificar contenido curso
    public String modificarContenido(String seccion, String unidad){

     if(contenidoCursoRepository.findByUnidad(unidad).isPresent() && cursoRepository.findByNombreSeccion(seccion).isPresent()){
            
        //Encapsula el contenido
        ContenidoCurso contenidoCurso = contenidoCursoRepository.findByUnidad(unidad).get();
        //Lo elimina
        contenidoCursoRepository.delete(contenidoCurso);
        return"Contenido eliminado";
        
    } else if (!cursoRepository.findByNombreSeccion(seccion).isPresent()){
            return"Curso no encontrado";
        }else{
            return "Unidad no encontrada";
        }
*/
}
