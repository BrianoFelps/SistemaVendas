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
public class DaoCliente extends BancoDeDadosMySQL{
    private String sql;
    
    
public Boolean inserir (int id, int idpes){
        try{
            sql = "INSERT INTO CLIENTE (ID, ID_PESSOA) VALUES (?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idpes);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar (int id, int novoidpes){
        try{
            sql = "UPDATE CLIENTE SET ID_PESSOA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, novoidpes);
                getStatement().setInt(2, id);
                
                getStatement().executeUpdate();
                
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir (int id){
        try{
            sql = "DELETE FROM CLIENTE WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try{
            sql = "SELECT C.ID, P.NOME FROM CLIENTE C JOIN PESSOA P ON C.ID_PESSOA = P.ID ORDER BY C.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT C.ID, P.NOME FROM CLIENTE C JOIN PESSOA P ON C.ID_PESSOA = P.ID WHERE C.ID = ? ORDER BY C.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorIdPessoa(int idPessoa){
        try{
            sql = 
                " SELECT                            " +
                "   ID AS ID,                       " +
                "   ID_PESSOA AS CIDADE             " +
                " FROM                              " +
                "   CLIENTE                         " +
                " WHERE ID_PESSOA = ?               " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idPessoa);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
        sql = "SELECT C.ID, P.NOME FROM CLIENTE C JOIN PESSOA P ON C.ID_PESSOA = P.ID WHERE P.NOME LIKE ? ORDER BY C.ID";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM CLIENTE";
            
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