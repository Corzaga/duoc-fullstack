package cl.duoc.fullstack.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.fullstack.edutech.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
