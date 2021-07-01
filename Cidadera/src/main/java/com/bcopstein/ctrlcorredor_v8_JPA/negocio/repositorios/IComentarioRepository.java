package com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;

public interface IComentarioRepository {
    List<Comentario> todos();
    void removeTodos();
    boolean cadastra(Comentario comentario);
    List<Comentario> searchparent(int idr);
}
