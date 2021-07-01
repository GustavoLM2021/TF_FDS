package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.controllers;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraReclamacaoUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraUsuarioUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaComentarioUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraComentarioUC;

import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaReclamacaoUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaUsuarioUC;



import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cidadera")
public class AppController {
    private ConsultaReclamacaoUC consultaReclamacaoUC;
    private CadastraReclamacaoUC cadastraReclamacaoUC;

    

    private CadastraUsuarioUC cadastraUsuarioUC;
    private ConsultaUsuarioUC consultaUsuarioUC;
    private ConsultaComentarioUC consultaComentarioUC;
    private CadastraComentarioUC cadastraComentarioUC;

    @Autowired
    public AppController(ConsultaReclamacaoUC consultaReclamacaoUC, CadastraReclamacaoUC cadastraReclamacaoUC,
             CadastraUsuarioUC cadastraUsuarioUC,
            ConsultaUsuarioUC consultaUsuarioUC, ConsultaComentarioUC consultaComentarioUC,
            CadastraComentarioUC cadastraComentarioUC) {
        this.consultaReclamacaoUC = consultaReclamacaoUC;
        this.cadastraReclamacaoUC = cadastraReclamacaoUC;

        

        this.cadastraUsuarioUC = cadastraUsuarioUC;
        this.consultaUsuarioUC = consultaUsuarioUC;
        this.consultaComentarioUC = consultaComentarioUC;
        this.cadastraComentarioUC = cadastraComentarioUC;
    }

    @GetMapping("/usuario")
    @CrossOrigin(origins = "*")
    public List<Usuario> consultaUsuarios(Integer idusu) {
        return consultaUsuarioUC.run();
    }

    @PostMapping("/usuario")
    @CrossOrigin(origins = "*")
    public boolean cadastraUsuario(@RequestBody final Usuario usuario) {
        cadastraUsuarioUC.run(usuario);
        return true;
    }

    @GetMapping("/reclamacao")
    @CrossOrigin(origins = "*")
    public List<Reclamacao> consultaReclamacao() {
        return consultaReclamacaoUC.run();
    }

    @PostMapping("/reclamacao")
    @CrossOrigin(origins = "*")
    public String cadastraReclamacao(@RequestBody final Reclamacao reclamacao) {
        String resp = cadastraReclamacaoUC.run(reclamacao);
        return resp;
    }

    @GetMapping("/statusSolved")
    @CrossOrigin(origins = "*")
    public String statusRecSolved(@RequestParam final int idr, int idusu) {
        String res = cadastraReclamacaoUC.statusetSolved(idr, idusu);
        return res;
    }

    @GetMapping("/statusClosed")
    @CrossOrigin(origins = "*")
    public String statusRecClosed(@RequestParam final int idr, int idusu) {
        String res = cadastraReclamacaoUC.statusetClosed(idr, idusu);
        return res;
    }

    @GetMapping("/status")
    @CrossOrigin(origins = "*")
    public String buscaStatus(@RequestParam final int idr) {
        String res = cadastraReclamacaoUC.statusFinder(idr);
        return res;
    }

    @GetMapping("/comentario")
    @CrossOrigin(origins = "*")
    public List<Comentario> consulComentario(@RequestParam final int idrparent) {
        List<Comentario> res = consultaComentarioUC.consulta(idrparent);
        return res;
    }

    @PostMapping("/comentario")
    @CrossOrigin(origins = "*")
    public String publicaComentario(@RequestBody final Comentario comentario) {
        String res = cadastraComentarioUC.publica(comentario);
        return res;
    }


    
 

}
