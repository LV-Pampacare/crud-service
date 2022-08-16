package com.unipampa.crudservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

  @Column(nullable = false)
  private Boolean lvc;

  @Column(nullable = false)
  private Boolean morreu;

  @OneToOne
  private Acao acao;

  @OneToMany(mappedBy = "sintoma", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AmostraSintoma> sintomas = new ArrayList<AmostraSintoma>();

  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Exame> exames = new ArrayList<Exame>();


}