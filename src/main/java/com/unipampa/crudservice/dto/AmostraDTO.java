package com.unipampa.crudservice.dto;

import com.unipampa.crudservice.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmostraDTO {

    private Long numero;

    @NotBlank
    private Boolean lvc;

    @NotBlank
    private Boolean morreu;

    @NotBlank
    private List<Cao> caes;

    @NotBlank
    private Proprietario proprietario;

    @NotBlank
    private List<Sintoma> sintomas;

    @NotBlank
    private List<Exame> exames;

    @NotBlank
    private Acao acao;

    @NotBlank
    private Amostra amostra;
}
