/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModEstado {
        private int id, idpais;
        private String nome;

    public ModEstado() {
    }
    public ModEstado(int id, int idpais, String nome) {
        this.id = id;
        this.idpais = idpais;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
        @Override
        public String toString(){
            return "Estado{" + "id=" + id + ", id país=" + idpais+ ", nome =" + nome + "}";
        }
        
}
