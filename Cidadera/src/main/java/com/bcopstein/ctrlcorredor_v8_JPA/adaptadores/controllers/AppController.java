package com.bcopstein.ctrlcorredor_v8_JPA.adaptadores.controllers;

import java.util.List;

import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraReclamacaoUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraUsuarioUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaComentarioUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraComentarioUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.CadastraEventoUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaReclamacaoUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaUsuarioUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.casosDeUso.ConsultaEventosUC;
import com.bcopstein.ctrlcorredor_v8_JPA.aplicacao.dtos.EstatisticasDTO;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Reclamacao;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Usuario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Comentario;
import com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades.Evento;

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
    private ConsultaEventosUC consultaEventosUC;
    private CadastraEventoUC cadastraEventoUC;
    private ConsultaEstatisticasUC consultaEstatisticasUC;

    private CadastraUsuarioUC cadastraUsuarioUC;
    private ConsultaUsuarioUC consultaUsuarioUC;
    private ConsultaComentarioUC consultaComentarioUC;
    private CadastraComentarioUC cadastraComentarioUC;

    @Autowired
    public AppController(ConsultaReclamacaoUC consultaReclamacaoUC, CadastraReclamacaoUC cadastraReclamacaoUC,
            ConsultaEventosUC consultaEventosUC, CadastraEventoUC cadastraEventoUC,
            ConsultaEstatisticasUC consultaEstatisticasUC,
             CadastraUsuarioUC cadastraUsuarioUC,
             ConsultaUsuarioUC consultaUsuarioUC,ConsultaComentarioUC consultaComentarioUC,CadastraComentarioUC cadastraComentarioUC) {
        this.consultaReclamacaoUC = consultaReclamacaoUC;
        this.cadastraReclamacaoUC = cadastraReclamacaoUC;
        this.consultaEventosUC = consultaEventosUC;
        this.cadastraEventoUC = cadastraEventoUC;
        this.consultaEstatisticasUC = consultaEstatisticasUC;
     
        this.cadastraUsuarioUC=cadastraUsuarioUC;
        this.consultaUsuarioUC=consultaUsuarioUC;
        this.consultaComentarioUC=consultaComentarioUC;
        this.cadastraComentarioUC=cadastraComentarioUC;
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
    public boolean cadastraReclamacao(@RequestBody final Reclamacao reclamacao) {
        cadastraReclamacaoUC.run(reclamacao);
        return true;
    }

    @GetMapping("/statusSolved")
    @CrossOrigin(origins = "*")
    public String statusRecSolved(@RequestParam final int idr,int idusu) {
        String res= cadastraReclamacaoUC.statusetSolved(idr,idusu);
        return res;
    }
    @GetMapping("/statusClosed")
    @CrossOrigin(origins = "*")
    public String statusRecClosed(@RequestParam final int idr,int idusu) {
        String res= cadastraReclamacaoUC.statusetClosed(idr,idusu);
        return res;
    }

    @GetMapping("/status")
    @CrossOrigin(origins = "*")
    public String buscaStatus(@RequestParam final int idr) {
        String res= cadastraReclamacaoUC.statusFinder(idr);
        return res;
    }

    @GetMapping("/comentario")
    @CrossOrigin(origins = "*")
    public List<Comentario> consulComentario(@RequestParam final int idrparent) {
        List<Comentario> res= consultaComentarioUC.consulta(idrparent);
        return res;
    }


    @PostMapping("/comentario")
    @CrossOrigin(origins = "*")
    public String publicaComentario(@RequestBody final Comentario comentario) {
        String res= cadastraComentarioUC.publica(comentario);
        return res;
    }


    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return consultaEventosUC.run();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        cadastraEventoUC.run(evento);
        return true;
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final Integer distancia) {
        return consultaEstatisticasUC.run(distancia);
    }

   
}
