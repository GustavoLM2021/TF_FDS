package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraUsuarioUC {
    private ServicoUsuario servicoUsuario;

    @Autowired
    public CadastraUsuarioUC(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }
    
    public void run(Usuario usuario){
        servicoUsuario.CadastraUsuario(usuario);
    }
    
}
