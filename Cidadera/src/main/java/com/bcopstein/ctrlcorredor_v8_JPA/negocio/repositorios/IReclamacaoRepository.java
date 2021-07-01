package com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;

public interface IReclamacaoRepository {
    List<Reclamacao> todos();
    void removeTodos();
    boolean cadastra(Reclamacao reclamacao);
    List<Reclamacao> findByIdr(int idr);
    boolean exists(int idr);
    void delete(Reclamacao reclamacao);
    
}
