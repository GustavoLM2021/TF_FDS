package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComentarioRepository implements IComentarioRepository {
    private IComentarioCRUD comentarioCRUD;
    
    @Autowired
    public ComentarioRepository(IComentarioCRUD comentarioCRUD) {
     
        this.comentarioCRUD = comentarioCRUD;
  
       // cadastra(new Corredor("10001287","Luiz",22,5,1987,"masculino"));    
       
    }
    
    public List<Comentario> todos() {
        List<Comentario> resp = comentarioCRUD.findAll();
        return resp;
    }

    public void removeTodos(){
        comentarioCRUD.deleteAll();
    }

    public boolean cadastra(Comentario comentario){
        
        comentarioCRUD.save(comentario);
        return true;
    }


    public List<Comentario> searchparent(int idr) {
        List<Comentario> resp=comentarioCRUD.findByidrparent(idr);
        return resp;
    }

   
}
