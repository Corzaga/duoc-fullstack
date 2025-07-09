package cl.duoc.fullstack.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.fullstack.edutech.model.ForoCurso;



public interface ForoCursoRepository extends JpaRepository <ForoCurso,Integer>{
    boolean existsByPregunta(String pregunta);
}
