package cl.duoc.fullstack.edutech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.fullstack.edutech.model.Curso;





public interface CursoRepository extends JpaRepository<Curso,Integer>{
   Optional <Curso>  findByNombreSeccion(String nombreSeccion);

}
