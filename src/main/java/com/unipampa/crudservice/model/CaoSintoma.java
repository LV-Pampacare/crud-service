package com.unipampa.crudservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CaoSintoma {

  @EmbeddedId
  private CaoSintomaId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("caoId")
  private Cao cao;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("sintomaId")
  private Sintoma sintoma;

  private String outro;

  private int intensidade;

  public CaoSintoma(Cao cao, Sintoma sintoma) {
    this.cao = cao;
    this.sintoma = sintoma;
    this.id = new CaoSintomaId(cao.getId(), sintoma.getId());
  }

}
