/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModPedido {
    private int id, idcliente, idprod, quant;
    private String data;

    public ModPedido() {
    }

    public ModPedido(int id, int idcliente, int idprod, int quant, String data) {
        this.id = id;
        this.idcliente = idcliente;
        this.idprod = idprod;
        this.quant = quant;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "ModPedido{" + "id=" + id + ", idCliente=" + idcliente + ", idProduto=" + idprod + ", DataPed=" + data + ", Quantidade=" + quant + '}';
    }
}
