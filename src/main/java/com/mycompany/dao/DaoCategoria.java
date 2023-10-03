/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;
import com.mycompany.ferramentas.BancoDeDadosMySQL;
import java.sql.ResultSet;
/**
 *
 * @author brian.7908
 */
public class DaoCategoria extends BancoDeDadosMySQL{
    private String sql;
    
    public Boolean inserir (int id, String nome, String descricao){
        try{
            sql = "INSERT INTO CATEGORIA (ID, NOME, DESCRICAO) VALUES (?, ?, ?)";
                    
                    setStatement(getConexao().prepareStatement(sql));
                    
                    getStatement().setInt(1, id);
                    getStatement().setString(2, nome);
                    getStatement().setString(3, descricao);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try {
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, ' ') FROM CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }   
        return getResultado();
     }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, ' ') FROM CATEGORIA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
        sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE NOME LIKE ?";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorDescricao(String descricao){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, ' ') FROM CATEGORIA WHERE DESCRICAO LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, descricao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT MAX (ID) + 1 FROM CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
           
            id = getResultado().getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return id;
    }
}
