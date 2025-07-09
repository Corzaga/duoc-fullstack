package cl.duoc.fullstack.edutech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.fullstack.edutech.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer>{

    //metodo custom, busca por rut
    Optional <Gerente> findByRut(String rut);

    //metodo custom, busca por correo
    Optional <Gerente> findByCorreo(String correo);
}