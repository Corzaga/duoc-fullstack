package cl.duoc.fullstack.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.fullstack.edutech.model.Gerente;
import cl.duoc.fullstack.edutech.repository.GerenteRepository;

//Mario A
@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    public String almacenar(Gerente gerente){
        gerenteRepository.save(gerente);
        //no hay validacion aun
        return "Gerente guardado correctamente";
    }

    public List<Gerente> listar(){
        return gerenteRepository.findAll();
    }
}
