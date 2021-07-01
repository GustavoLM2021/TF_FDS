package com.bcopstein.ctrlcorredor_v8_JPA.negocio.servicos;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.repositorios.ReclamacaoRepository;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IReclamacaoRepository;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.repositorios.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoReclamacao {
    public IReclamacaoRepository reclamacaoRep;
    public IUsuarioRepository usuarioRep;

    @Autowired
    public ServicoReclamacao(IReclamacaoRepository reclamacaoRep,IUsuarioRepository usuarioRep){
        this.reclamacaoRep = reclamacaoRep;
        this.usuarioRep=usuarioRep;
    }

    public List<Reclamacao> todos(){
        return reclamacaoRep.todos();
    }

    public void cadastraReclamacao(Reclamacao reclamacao){
        reclamacaoRep.cadastra(reclamacao);
    }
    public String readStatus(int idr){
        List<Reclamacao> resp=reclamacaoRep.findByIdr(idr);
        if(resp.isEmpty()){
            return "Reclamacao inexistente";
        }
        Reclamacao reclamacao = resp.get(0);
        return reclamacao.getrstatus() ;
        
    }
    public boolean existsByidr(int idr){
        
        return reclamacaoRep.exists(idr);
    }

    public String stsSolved(int idr, int idusu) {
        List<Usuario> usu=usuarioRep.findByIdusu(idusu);
        if (usu.isEmpty()){
            return "Erro usuario inexistente";
        }
        Usuario u=usu.get(0);
        if(u.getOficial()||u.getAdmin()){
            return "Erro: Comando restrito a usuario comum";
        }
        Reclamacao tmp= new Reclamacao();
        List<Reclamacao> resp= reclamacaoRep.findByIdr(idr);
        if(resp.isEmpty()){
            return "Erro: Reclamacao inexistente";
        }
        Reclamacao reclamacao=resp.get(0);
        if(reclamacao.getrstatus()=="encerrado"){
            return "Erro: Reclamacao ja esta encerrada";
        }
        tmp=reclamacao;
        tmp.setrstatus("resolvido");
        reclamacaoRep.delete(reclamacao);
        reclamacaoRep.cadastra(tmp);
        return "Operacao Realizada com Sucesso!";
    }

    public String stsClosed(int idr, int idusu) {
        List<Usuario> usu=usuarioRep.findByIdusu(idusu);
        if (usu.isEmpty()){
            return "Erro usuario inexistente";
        }
        Usuario u=usu.get(0);
        if(!u.getOficial()){
            return "Erro: Comando restrito a usuario oficial";
        }
        Reclamacao tmp= new Reclamacao();
        List<Reclamacao> resp= reclamacaoRep.findByIdr(idr);
        if(resp.isEmpty()){
            return "Erro: Reclamacao inexistente";
        }
        Reclamacao reclamacao=resp.get(0);
        if(reclamacao.getrstatus()=="encerrado"){
            return "Erro: Reclamacao ja esta encerrada";
        }
        tmp=reclamacao;
        tmp.setrstatus("resolvido");
        reclamacaoRep.delete(reclamacao);
        reclamacaoRep.cadastra(tmp);
        return "Operacao Realizada com Sucesso!";
    }
    
}
