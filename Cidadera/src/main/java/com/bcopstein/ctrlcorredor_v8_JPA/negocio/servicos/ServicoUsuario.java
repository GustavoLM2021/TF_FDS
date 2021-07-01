package com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoUsuario {
    public IUsuarioRepository usuarioRep;
    

    @Autowired
    public ServicoUsuario(IUsuarioRepository usuarioRep){
        this.usuarioRep = usuarioRep;
    }

    public List<Usuario> todos(){
        return usuarioRep.todos();
    }

    public void CadastraUsuario(Usuario usuario){
        usuarioRep.cadastra(usuario);
    }
    
}
