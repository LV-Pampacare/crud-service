package com.unipampa.crudservice.controller;

import com.unipampa.crudservice.dto.AmostraDTO;
import com.unipampa.crudservice.interfaces.*;
import com.unipampa.crudservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/amostra")
public class AmostraController {

    @Autowired
    private ICaoService caoService;

    @Autowired
    private IProprietarioService proprietarioService;

    @Autowired
    private ILocalizacaoService localizacaoService;

    @Autowired
    private IExameService exameService;

    @Autowired
    private ISintomaService sintomaService;

    @Autowired
    private IAcaoService acaoService;

    @PostMapping("/inserir")
    public void salvarGeral(@RequestBody AmostraDTO dto) {

        Proprietario proprietario = caputurarProprietario(dto);

        Amostra amostra = caputurarAmostra(dto);

        Acao acao = caputurarAcao(dto);

        List<Cao> caes = dto.getProprietario().getCaes().stream().collect(Collectors.toList());

        proprietario.setCaes(caes);
        amostra.setAcao(acao);

        salvarCaes(caes);
        acaoService.salvarAcao(acao);

        proprietarioService.salvarProprietario(proprietario);
    }

    public void salvarCaes(List<Cao> caes) {
        caes.stream().forEach(e -> caoService.salvarCao(e));
    }

    public void salvarLocalizacoes(List<Localizacao> localizacoes) {
        localizacoes.stream().forEach(e -> localizacaoService.salvarLocalizacao(e));
    }

    public void salvarSintomas(List<Sintoma> sintomas) {
        sintomas.stream().forEach(e -> sintomaService.salvarSintoma(e));
    }

    public void salvarExames(List<Exame> exames) {
        exames.stream().forEach(e -> exameService.salvarExame(e));
    }

    public Amostra caputurarAmostra(AmostraDTO dto) {
        Amostra amostra = new Amostra();
        return amostra;
    }

    public Proprietario caputurarProprietario(AmostraDTO dto) {
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(dto.getProprietario().getNome());
        proprietario.setNumCartaoSus(dto.getProprietario().getNumCartaoSus());
        return proprietario;
    }

    public Acao caputurarAcao(AmostraDTO dto) {
        Acao acao = new Acao();
        acao.setNome(dto.getAcao().getNome());
        return acao;
    }
}
