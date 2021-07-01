package com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comentario {
    @Id
    private String coment;
    private int idcoment;
    private int idrparent;
    private int idautorcoment;
   
    
    public Comentario(String coment,int idcoment,int idrparent,int idautorcoment) {
        this.coment =coment;
        this.idcoment=idcoment;
        this.idrparent=idrparent;
        this.idautorcoment=idautorcoment;
     

    }
    public Comentario(){

    }
    public String getComent() {
        return coment;
    }
    public int getIdcoment() {
        return idcoment;
    }
    public int getIdrparent() {
        return idrparent;
    }
    public int getIdautorcoment() {
        return idautorcoment;
    }
}