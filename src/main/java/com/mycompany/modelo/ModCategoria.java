/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModCategoria {
    private int id;
    private String nome;
    private String descricao;
    
    public ModCategoria(){
    }
    
    public ModCategoria(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(String nome){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return "Categoria{" + "id=" + id + ", nome =" + nome + ", descricao=" + descricao + '}';
    }
}