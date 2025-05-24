package cl.duoc.fullstack.edutech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.fullstack.edutech.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    //metodo custom, busca por rut
    Optional <Alumno> findByRut(String rut);

    //metodo custom, busca por correo
    Optional <Alumno> findByCorreo(String correo);

}
