package com.unipampa.crudservice.implementacao;

import com.unipampa.crudservice.interfaces.ISintomaService;
import com.unipampa.crudservice.model.Sintoma;
import com.unipampa.crudservice.repository.SintomaRespository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomaServiceImp implements ISintomaService {

    @Autowired
    SintomaRespository repository;

    @Override
    public void salvarSintoma(Sintoma sintoma) {
        repository.save(sintoma);
    }

    public List<Sintoma> listarSintomas(){
        return repository.findAll();
    }
}
