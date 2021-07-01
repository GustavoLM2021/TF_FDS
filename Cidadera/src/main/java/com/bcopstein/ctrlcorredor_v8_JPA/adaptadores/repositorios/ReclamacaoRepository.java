package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IReclamacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReclamacaoRepository implements IReclamacaoRepository {
    public static Object reclamacaoRep;
    private IReclamacaoCRUD reclamacaoCRUD;
    
    @Autowired
    public ReclamacaoRepository(IReclamacaoCRUD reclamacaoCRUD) {
     
        this.reclamacaoCRUD = reclamacaoCRUD;
  
    
       
    }
    
    public List<Reclamacao> todos() {
        List<Reclamacao> resp = reclamacaoCRUD.findAll();
        return resp;
    }

    public void removeTodos(){
        reclamacaoCRUD.deleteAll();
    }

    public boolean cadastra(Reclamacao reclamacao){
        reclamacaoCRUD.save(reclamacao);
        return true;
    }

    public List<Reclamacao> findByIdr(int idr){
        List<Reclamacao> resp=reclamacaoCRUD.findByIdr(idr);
        return resp;
        
    }
    

    public boolean exists(int idr) {
        boolean resp=reclamacaoCRUD.existsByidr(idr);
        return resp;
    }

    
    public void delete(Reclamacao reclamacao) {
       reclamacaoCRUD.delete(reclamacao);
        
    }
   
}
