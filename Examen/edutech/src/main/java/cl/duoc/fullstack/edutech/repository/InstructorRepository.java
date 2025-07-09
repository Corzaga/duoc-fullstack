package cl.duoc.fullstack.edutech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.fullstack.edutech.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

    //metodo custom
    Optional<Instructor> findByRut(String rut);

    //metodo custom
    Optional<Instructor> findByCorreo(String correo);
}
