package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;

import org.springframework.data.repository.CrudRepository;

public interface IComentarioCRUD extends CrudRepository<Comentario,Integer> {
    List<Comentario> findAll();
    List<Comentario> findByidrparent(Integer idrparent);
}
