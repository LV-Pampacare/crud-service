package com.unipampa.crudservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unipampa.crudservice.model.AmostraAcao;
import com.unipampa.crudservice.model.AmostraAcaoId;


@Repository
public interface AmostraAcaoRepository extends JpaRepository<AmostraAcao, AmostraAcaoId> {




}