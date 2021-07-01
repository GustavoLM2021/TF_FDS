package com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos.ServicoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaUsuarioUC {
    private ServicoUsuario servicoUsuario;

    @Autowired
    public ConsultaUsuarioUC(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }
    
    public List<Usuario> run(){
        return servicoUsuario.todos();
    }    
}
