package com.unipampa.crudservice.controller;

import com.unipampa.crudservice.dto.AmostraDTO;
import com.unipampa.crudservice.interfaces.*;
import com.unipampa.crudservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/amostra")
public class AmostraController {


    @Autowired
    private IProprietarioService proprietarioService;

    @Autowired
    private ILocalizacaoService localizacaoService;

    @Autowired
    private ICaoSintomaService caoSintomaService;

    @PostMapping("/inserir")
    public ResponseEntity<String> salvarGeral(@RequestBody AmostraDTO dto) {
        Proprietario proprietario = capturarProprietario(dto);

        // capturarAmostra(dto);
        // List<Cao> caes = dto.getProprietario().getCaes().stream().collect(Collectors.toList());
        // proprietario.setCaes(caes);
        proprietarioService.salvarProprietario(proprietario);
        // salvarLocalizacao(dto.getProprietario().getLocalizacao(), proprietario);
        // salvarCaes(caes, proprietario);
        return new ResponseEntity<String>("Amostra Registrada", HttpStatus.OK);
    }

    public void salvarCaes(List<Cao> caes, Proprietario proprietario) {
        for (Cao cao : caes) {
            cao.setProprietario(proprietario);
            // Cao caoInserido = caoService.salvarCao(cao);
            // System.out.println(caoInserido.toString());
            // salvarSintomas(caoInserido);
        }
    }

    public void salvarLocalizacao(Localizacao localizacao, Proprietario proprietario) {
        localizacao.setProprietario(proprietario);
        localizacaoService.salvarLocalizacao(localizacao);
    }

    public void salvarSintomas(Cao cao) {
        List<CaoSintoma> sintomas = cao.getSintomas();
        for (CaoSintoma sintoma : sintomas) {
            sintoma.setCao(cao);
            caoSintomaService.salvarSintoma(sintoma);
        }
    }

    public void salvarExames(Cao cao) {
    }

    public Amostra capturarAmostra(AmostraDTO dto) {
        Amostra amostra = new Amostra();
        return amostra;
    }

    public Proprietario capturarProprietario(AmostraDTO dto) {
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(dto.getProprietario().getNome());
        proprietario.setNumCartaoSus(dto.getProprietario().getNumCartaoSus());
        return proprietario;
    }

    public Acao capturarAcao(AmostraDTO dto) {
        Acao acao = new Acao();
        acao.setNome(dto.getAcao().getNome());
        return acao;
    }
}
