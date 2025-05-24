package cl.duoc.fullstack.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.fullstack.edutech.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer>{

}