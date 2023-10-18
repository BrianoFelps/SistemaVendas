/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModCliente {
    private int id, idpes;

    public ModCliente() {
    }

    public ModCliente(int id, int idpes) {
        this.id = id;
        this.idpes = idpes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpes() {
        return idpes;
    }

    public void setIdpes(int idpes) {
        this.idpes = idpes;
    }
    
     @Override
        public String toString(){
            return "Cliente{" + "id=" + id + ", id pessoa=" + idpes + "}";
        }
}
