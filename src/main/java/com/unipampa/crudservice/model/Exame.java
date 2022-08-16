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
public class Exame {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, length = 50)
  private String nome;

  @Column(nullable = false, length = 50)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
  private Date data;

  @Column(nullable = false, length = 50)
  private Boolean resultado;

  @Column(nullable = true, length = 50)
  private String descricao;

  @ManyToOne
  @JoinColumn(name="cao_id", nullable = false)
  private Cao cao;
}