/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModProduto {
private int id, idcatg, idmar;
private String preco;
private String nm, desc;
    
    public ModProduto() {
    }

    public ModProduto(int id, int idcatg, int idmar, String preco, String nm, String desc) {
        this.id = id;
        this.idcatg = idcatg;
        this.idmar = idmar;
        this.preco = preco;
        this.nm = nm;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcatg() {
        return idcatg;
    }

    public void setIdcatg(int idcatg) {
        this.idcatg = idcatg;
    }

    public int getIdmar() {
        return idmar;
    }

    public void setIdmar(int idmar) {
        this.idmar = idmar;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Override
        public String toString(){
            return "Produto{" + "id=" + id + ", id categoria=" + idcatg + ", id marca =" + idmar + ", Nome= " + nm + ", Descrição = " + desc + ", Preço=" + preco + "}";
        }
}
