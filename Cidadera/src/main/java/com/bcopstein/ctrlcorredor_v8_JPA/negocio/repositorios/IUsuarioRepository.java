package com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;

public interface IUsuarioRepository {
    List<Usuario> todos();
    void removeTodos();
    boolean cadastra(Usuario usuario);
    List<Usuario> findByIdusu(int idusu);
    
}
