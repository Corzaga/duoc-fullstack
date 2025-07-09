package cl.duoc.fullstack.edutech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.fullstack.edutech.model.EvaluacionCurso;

public interface EvaluacionCursoRepository  extends JpaRepository<EvaluacionCurso,Integer>{
    Optional <EvaluacionCurso> findByNombreEvaluacion(String nombreEvaluacion);
}
