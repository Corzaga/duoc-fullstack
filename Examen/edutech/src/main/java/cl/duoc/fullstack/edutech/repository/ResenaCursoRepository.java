package cl.duoc.fullstack.edutech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.fullstack.edutech.model.ResenaCurso;

@Repository
public interface ResenaCursoRepository extends JpaRepository<ResenaCurso,Integer> {

    Optional <ResenaCurso> findByNombreAlumno(String nombreAlumno);

}
