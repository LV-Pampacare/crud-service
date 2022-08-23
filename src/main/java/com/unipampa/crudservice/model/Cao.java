package com.unipampa.crudservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Cao {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, length = 50)
  private String nome;

  @Column(nullable = false, length = 50)
  private String raca;

  @Column(nullable = false)
  private String sexo;

  @Column
  private Long idade;

  @Column(nullable = false)
  private Boolean vacina;

  @Column(nullable = false)
  private Boolean usaColeira;

  @OneToMany(mappedBy = "sintoma", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CaoSintoma> sintomas = new ArrayList<CaoSintoma>();

  @ManyToOne
  @JoinColumn(name = "proprietario_id", nullable = false)
  private Proprietario proprietario;

  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Exame> exames = new ArrayList<Exame>();

  @OneToOne(mappedBy = "cao", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Acao acao;

  @Override
  public String toString() {
    return "Cao [acao=" + acao + ", exames=" + exames + ", id=" + id + ", idade=" + idade + ", nome=" + nome
        + ", proprietario=" + proprietario + ", raca=" + raca + ", sexo=" + sexo + ", sintomas=" + sintomas
        + ", usaColeira=" + usaColeira + ", vacina=" + vacina + "]";
  }


}
