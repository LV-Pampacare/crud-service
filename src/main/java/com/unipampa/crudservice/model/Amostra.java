package com.unipampa.crudservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Amostra {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private Date data;

  @OneToOne
  private Acao acao;




}