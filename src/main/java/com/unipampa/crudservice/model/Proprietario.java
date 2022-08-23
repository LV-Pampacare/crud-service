package com.unipampa.crudservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Proprietario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, length = 50)
  private Long numCartaoSus;

  @Column(nullable = false, length = 50)
  private String nome;

  @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Cao> caes = new ArrayList<Cao>();

  @OneToOne(mappedBy = "proprietario", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Localizacao localizacao;

  @Override
  public String toString() {
    return "Proprietario [caes=" + caes + ", id=" + id + ", localizacao=" + localizacao + ", nome=" + nome
        + ", numCartaoSus=" + numCartaoSus + "]";
  }
}
