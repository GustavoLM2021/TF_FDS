package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCRUD extends CrudRepository<Usuario,Integer> {
    List<Usuario> findAll();
    List<Usuario> findByIdusu(Integer idusu);
}
