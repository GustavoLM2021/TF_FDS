package com.bcopstein.ctrlcorredor_v8_JPA.negocio.entidades;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    private int idusu;
    private String name;
    private boolean admin;
    private boolean oficial;
  

    public Usuario(int idusu,String name,Boolean admin,Boolean oficial) {
        this.idusu = idusu;
        this.name=name;
        this.admin=admin;
        this.oficial=oficial;
    }
    public Usuario(){

    }
 
    public boolean getOficial(){
        return oficial;
    }
    public int getIdusu() {
        return idusu;
    }

    public String getName() {
        return name;
    }

    public boolean getAdmin() {
        return admin;
    }

 

}