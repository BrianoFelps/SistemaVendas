/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModEndereco {
    private int id, idcid, cep, num;
    private String rua;
    
    public ModEndereco() {
    }

    public ModEndereco(int id, int idcid, int cep, int num, String rua) {
        this.id = id;
        this.idcid = idcid;
        this.cep = cep;
        this.num = num;
        this.rua = rua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcid() {
        return idcid;
    }

    public void setIdcid(int idcid) {
        this.idcid = idcid;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    @Override
        public String toString(){
            return "Endereço{" + "id=" + id + ", id cidade=" + idcid + ", rua =" + rua + ", CEP = " + cep + ", número residêncial= " + num + "}";
        }
        
}
