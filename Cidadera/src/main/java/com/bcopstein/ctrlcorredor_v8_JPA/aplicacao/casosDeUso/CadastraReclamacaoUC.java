package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoReclamacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraReclamacaoUC {
    private ServicoReclamacao servicoReclamacao;

    @Autowired
    public CadastraReclamacaoUC(ServicoReclamacao servicoReclamacao) {
        this.servicoReclamacao = servicoReclamacao;
    }
    
    public String run(Reclamacao reclamacao){
        String res=servicoReclamacao.cadastraReclamacao(reclamacao);
        return res;
    }
    public String statusFinder(int idr){
        return servicoReclamacao.readStatus(idr);
        
    }

    public String statusetSolved(int idr, int idusu) {
       String res= servicoReclamacao.stsSolved(idr,idusu);
        return res;
    }

    public String statusetClosed(int idr, int idusu) {
        String res=servicoReclamacao.stsClosed(idr,idusu);
        return res;
    }
    
}
