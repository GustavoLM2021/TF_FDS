package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;

import org.springframework.data.repository.CrudRepository;

public interface IReclamacaoCRUD extends CrudRepository<Reclamacao,Integer> {
    List<Reclamacao> findAll();
    List<Reclamacao> findByIdr(Integer idr);
    boolean existsByidr(int idr);

}
