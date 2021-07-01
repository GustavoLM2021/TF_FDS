package com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IComentarioRepository;

import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IReclamacaoRepository;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoComentario {
    public IComentarioRepository comentarioRep;
    public IReclamacaoRepository reclamacaoRep;
    public IUsuarioRepository usuarioRep;

    @Autowired
    public ServicoComentario(IComentarioRepository comentarioRep,IReclamacaoRepository reclamacaoRep,IUsuarioRepository usuarioRep ){
        this.comentarioRep = comentarioRep;
        this.reclamacaoRep=reclamacaoRep;
        this.usuarioRep=usuarioRep;
        
    }

    public List<Comentario> todos(){
        return comentarioRep.todos();
    }

    public void CadastraComentario(Comentario comentario){
        
        comentarioRep.cadastra(comentario);
    }

    public List<Comentario> byparent(int idr) {
       List<Comentario> res= comentarioRep.searchparent(idr);
        return res;
    }

    public String publish(Comentario comentario) {
       
        int idusu=comentario.getIdautorcoment();
        List<Usuario> usu=usuarioRep.findByIdusu(idusu);
        if (usu.isEmpty()){
            return "Erro usuario inexistente";
        }
       
        int idrparent=comentario.getIdrparent();
        List<Reclamacao> resp= reclamacaoRep.findByIdr(idrparent);
        if(resp.isEmpty()){
            return "Erro: Reclamacao inexistente";
        }
        Reclamacao reclamacao=resp.get(0);
        if(reclamacao.getrstatus()=="encerrado"){
            return "Erro: Reclamacao ja esta encerrada";
        }
        comentarioRep.cadastra(comentario);
        return "Comentario publicado com sucesso";
    }

    
}
