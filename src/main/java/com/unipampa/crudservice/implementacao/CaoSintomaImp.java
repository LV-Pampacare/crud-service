package com.unipampa.crudservice.implementacao;

import com.unipampa.crudservice.interfaces.ICaoSintomaService;
import com.unipampa.crudservice.model.CaoSintoma;
import com.unipampa.crudservice.repository.CaoSintomaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaoSintomaImp implements ICaoSintomaService {

    @Autowired
    private CaoSintomaRepository repository;

    @Override
    public void salvarSintoma(CaoSintoma sintoma) {
        repository.save(sintoma);
    }
}