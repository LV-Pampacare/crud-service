package com.unipampa.crudservice.interfaces;

import java.util.List;

import com.unipampa.crudservice.model.Sintoma;


public interface ISintomaService {

    public void salvarSintoma(Sintoma sintoma);

    public List<Sintoma> listarSintomas();
}
