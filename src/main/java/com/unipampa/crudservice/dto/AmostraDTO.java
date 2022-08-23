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

    @NotBlank
    private Proprietario proprietario;

    @NotBlank
    private Acao acao;

    @NotBlank
    private Amostra amostra;

    @NotBlank
    private List<Cao> caes;
}
