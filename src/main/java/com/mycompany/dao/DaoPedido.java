/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySQL;

/**
 *
 * @author brian.7908
 */
public class DaoPedido extends BancoDeDadosMySQL{
    private String sql;
    
    public Boolean inserir (int id, int idCli, int idProd, String data, int Quant){
        try{
            sql = "INSERT INTO PESSOA (ID, ID_CLIENTE, ID_PROD, DATA_PED, QUANT) VALUES (?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idCli);
                    getStatement().setInt(3, idProd);
                    getStatement().setString(4, data);
                    getStatement().setInt(5, Quant);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar (int id, int novoidend, int novoidestciv, String novonom, String novosob, String novogen, String novotel, String novoema){
        try{
            sql = "UPDATE PESSOA SET ID_ENDERECO = ?, ID_EST_CIV = ?, NOME = ?, SOBRENOME = ?, GENERO = ?, TELEFONE = ?, EMAIL = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, novoidend);
                getStatement().setInt(2, novoidestciv);
                getStatement().setString(3, novonom);
                getStatement().setString(4, novosob);
                getStatement().setString(5, novogen);
                getStatement().setString(6, novotel);
                getStatement().setString(7, novoema);
                getStatement().setInt(8, id);
                
                getStatement().executeUpdate();
                
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir (int id){
        try{
            sql = "DELETE FROM PESSOA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
