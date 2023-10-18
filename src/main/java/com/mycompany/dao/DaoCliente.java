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
    
    
public Boolean inserir (int id, int idcli){
        try{
            sql = "INSERT INTO CLIENTE (ID, ID_PESSOA) VALUES (?, ?) ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idcli);

                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean alterar (int id, int novoidcli){
        try{
            sql = "UPDATE CLIENTE SET ID_PESSOA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, novoidcli);
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
            sql = "SELECT C.ID, P.NOME FROM CLIENTE C JOIN PESSOA P ON C.ID_PESSOA = P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT E.ID, C.NOME, E.NOME_RUA , E.CEP, E.NUM_RESID FROM ENDERECO E JOIN CIDADE C ON E.ID_CIDADE = C.ID WHERE E.ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorRua(String nome){
        try{
        sql = "SELECT E.ID, C.NOME, E.NOME_RUA, E.CEP , E.NUM_RESID FROM ENDERECO E JOIN CIDADE C ON E.ID_CIDADE = C.ID WHERE E.NOME_RUA LIKE ?";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCidade(String cidnome){
        try{
            sql = "SELECT E.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID FROM ENDERECO E JOIN CIDADE C ON E.ID_CIDADE = C.ID WHERE C.NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cidnome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCep(String cep){
        try{
            sql = "SELECT E.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID FROM ENDERECO E JOIN CIDADE C ON E.ID_CIDADE = C.ID WHERE E.CEP LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cep + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNum(String num){
        try{
            sql = "SELECT E.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID FROM ENDERECO E JOIN CIDADE C ON E.ID_CIDADE = C.ID WHERE E.NUM_RESID LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, num + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM ENDERECO";
            
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