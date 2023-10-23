/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author brian.7908
 */
public class ModPessoa {
    private int id, idend, idestciv;
    private String nom, sob, gen, tel, ema;

    public ModPessoa() {
    }

    public ModPessoa(int id, int idend, int idestciv, String nom, String sob, String gen, String tel, String ema) {
        this.id = id;
        this.idend = idend;
        this.idestciv = idestciv;
        this.nom = nom;
        this.sob = sob;
        this.gen = gen;
        this.tel = tel;
        this.ema = ema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdend() {
        return idend;
    }

    public void setIdend(int idend) {
        this.idend = idend;
    }

    public int getIdestciv() {
        return idestciv;
    }

    public void setIdestciv(int idestciv) {
        this.idestciv = idestciv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSob() {
        return sob;
    }

    public void setSob(String sob) {
        this.sob = sob;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEma() {
        return ema;
    }

    public void setEma(String ema) {
        this.ema = ema;
    }
    @Override
    public String toString() {
        return "ModPessoa{" + "id=" + id + ", idEndereco=" + idend + ", idEstadoCivil=" + idestciv + ", nome=" + nom + ", sobrenome=" + sob + ", genero=" + gen + ", telefone=" + tel + ", email=" + ema + '}';
    }
}
