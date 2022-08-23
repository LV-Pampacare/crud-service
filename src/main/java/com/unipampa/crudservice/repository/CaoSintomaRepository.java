package com.unipampa.crudservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unipampa.crudservice.model.CaoSintoma;
import com.unipampa.crudservice.model.CaoSintomaId;

@Repository
public interface CaoSintomaRepository extends JpaRepository<CaoSintoma, CaoSintomaId> {


}