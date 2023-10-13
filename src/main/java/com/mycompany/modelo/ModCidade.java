/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModCidade {
    private int id, idest;
    private String nome;

    public ModCidade() {
    }

    public ModCidade(int id, int idest, String nome) {
        this.id = id;
        this.idest = idest;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdest() {
        return idest;
    }

    public void setIdest(int idest) {
        this.idest = idest;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     @Override
        public String toString(){
            return "Cidade{" + "id=" + id + ", id estado=" + idest + ", nome =" + nome + "}";
        }
}
