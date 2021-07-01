package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoComentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraComentarioUC {
    private ServicoComentario servicoComentario;

    @Autowired
    public CadastraComentarioUC(ServicoComentario servicoComentario) {
        this.servicoComentario = servicoComentario;
    }
    
    public String publica(Comentario comentario){
        String res=servicoComentario.publish(comentario);
        return res;
    }
    
}
