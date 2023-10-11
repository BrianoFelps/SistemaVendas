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
public class DaoEstado extends BancoDeDadosMySQL {
    private String sql;
    
    public Boolean inserir (int id, int paisid, String nome){
        try{
            sql = "INSERT INTO ESTADO (ID, ID_PAIS, NOME) VALUES (?, ?, ?) ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, paisid);
                    getStatement().setString(3, nome);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar (int id, int idpais, String novonome){
        try{
            sql = "UPDATE ESTADO SET NOME = ?, SET ID_PAIS = ? WHERE ID = ?";
            
                getStatement().setString(1, novonome);
                getStatement().setInt(2, idpais);
                getStatement().setInt(3, id);
                
                getStatement().executeUpdate();
                
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir (int id){
        try{
            sql = "DELETE FROM ESTADO WHERE ID = ?";
            
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
            sql = "SELECT E.ID, P.NOME, E.NOME FROM ESTADO E JOIN PAIS P ON E.ID_PAIS = P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT E.ID, P.NOME, E.NOME FROM ESTADO E JOIN PAIS P ON E.ID_PAIS = P.ID WHERE E.ID = ?";
            
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
        sql = "SELECT E.ID, P.NOME, E.NOME FROM ESTADO E JOIN PAIS P ON E.ID_PAIS = P.ID WHERE E.NOME LIKE ?";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorPais(String paisnome){
        try{
            sql = "SELECT E.ID, P.NOME, E.NOME FROM ESTADO E JOIN PAIS P ON E.ID_PAIS = P.ID WHERE P.NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, paisnome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM ESTADO";
            
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
