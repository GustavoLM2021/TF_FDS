package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IUsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRepository implements IUsuarioRepository {
    private IUsuarioCRUD usuarioCRUD;
    
    @Autowired
    public UsuarioRepository(IUsuarioCRUD usuarioCRUD) {
     
        this.usuarioCRUD = usuarioCRUD;
  
       // cadastra(new Corredor("10001287","Luiz",22,5,1987,"masculino"));    
       
    }
    
    public List<Usuario> todos() {
        List<Usuario> resp = usuarioCRUD.findAll();
        return resp;
    }

    public void removeTodos(){
        usuarioCRUD.deleteAll();
    }

    public boolean cadastra(Usuario usuario){
        usuarioCRUD.save(usuario);
        return true;
    }

    public List<Usuario> findByIdusu(int idusu){
        List<Usuario> resp=usuarioCRUD.findByIdusu(idusu);
        return resp;
        
    }
}
