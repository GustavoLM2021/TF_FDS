package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoComentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaComentarioUC {
    private ServicoComentario servicoComentario;

    @Autowired
    public ConsultaComentarioUC(ServicoComentario servicoComentario) {
        this.servicoComentario = servicoComentario;
    }
    
    public List<Comentario> consulta(int idr){
        return servicoComentario.byparent(idr);
    }    
}
