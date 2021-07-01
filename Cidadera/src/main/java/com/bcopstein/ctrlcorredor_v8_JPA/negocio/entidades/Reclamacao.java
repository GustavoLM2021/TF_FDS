package com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reclamacao {
    @Id
    private int idr;
    private int ano;
    private int mes;
    private int dia;
    private int idautor;
    private int idbairro;
    private int idcategoria;
    private String rstatus;
    private String titulo;
    private String descricao;
    private String endereco;
  

    public Reclamacao(int idr, String titulo,  String descricao,String endereco,int dia,int mes,int ano,int idautor,int idbairro,int idcategoria) {
        this.idr = idr;
        this.titulo = titulo;
        this.descricao = descricao;
        this.endereco=endereco;
        this.idautor=idautor;
        this.idbairro=idbairro;
        this.idcategoria=idcategoria;
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
        this.rstatus="Aberto";
    }
    public Reclamacao(){

    }
    public String getrstatus(){
        return rstatus;
    }
    
    public int getidbairro() {
        return idbairro;
    }
    public int getidcategoria(){
        return idcategoria;
    }

    public int getidr() {
        return idr;
    }

    public String gettitulo() {
        return titulo;
    }

    public String getdescricao() {
        return descricao;
    }
    public String getendereco() {
        return endereco;
    }
    public int getidautor() {
        return idautor;
    }
     
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    public void setrstatus(String stt){
        this.rstatus=stt;
    }
}