package com.unipampa.crudservice.dto;

import com.unipampa.crudservice.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmostraDTO {

    @NotBlank
    private Proprietario proprietario;
    
    @NotBlank
    private Localizacao localizacoes;

    @NotBlank
    private List<Cao> caes;

}
