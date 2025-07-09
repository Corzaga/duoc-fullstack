package cl.duoc.fullstack.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.fullstack.edutech.model.ContenidoCurso;

import java.util.Optional;


public interface ContenidoCursoRepository extends JpaRepository<ContenidoCurso,Integer>{

    Optional <ContenidoCurso> findByUnidad(String unidad);

}
