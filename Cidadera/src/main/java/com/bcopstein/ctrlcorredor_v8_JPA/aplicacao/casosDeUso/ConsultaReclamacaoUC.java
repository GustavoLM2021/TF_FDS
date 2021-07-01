package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaReclamacaoUC {
    private ServicoReclamacao servicoReclamacao;

    @Autowired
    public ConsultaReclamacaoUC(ServicoReclamacao servicoReclamacao) {
        this.servicoReclamacao = servicoReclamacao;
    }
    
    public List<Reclamacao> run(){
        return servicoReclamacao.todos();
    }    
}
