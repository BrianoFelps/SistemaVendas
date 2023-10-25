/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySQL;
import static com.mycompany.ferramentas.BancoDeDadosMySQL.getConexao;
import static com.mycompany.ferramentas.BancoDeDadosMySQL.getResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySQL.getStatement;
import static com.mycompany.ferramentas.BancoDeDadosMySQL.setResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySQL.setStatement;
import java.sql.ResultSet;

/**
 *
 * @author brian.7908
 */
public class DaoEndereco extends BancoDeDadosMySQL{
    private String sql;
    
    public Boolean inserir (int id, int idcid, String rua, int cep, int num){
        try{
            sql = "INSERT INTO ENDERECO (ID, ID_CIDADE, NOME_RUA, CEP, NUM_RESID) VALUES (?, ?, ?, ?, ?) ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idcid);
                    getStatement().setString(3, rua);
                    getStatement().setInt(4, cep);
                    getStatement().setInt(5, num);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar (int id, int novoidcid, String novarua, int novocep, int novonum){
        try{
            sql = "UPDATE ENDERECO SET ID_CIDADE = ?, NOME_RUA = ?, CEP = ?, NUM_RESID = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, novoidcid);
                getStatement().setString(2, novarua);
                getStatement().setInt(3, novocep);
                getStatement().setInt(4, novonum);
                getStatement().setInt(5, id);
                
                getStatement().executeUpdate();
                
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir (int id){
        try{
            sql = "DELETE FROM ENDERECO WHERE ID = ?";
            
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
            sql = "SELECT E.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID FROM ENDERECO E JOIN CIDADE C ON E.ID_CIDADE = C.ID";
            
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
            sql = "SELECT IFNULL (MAX(ID), 0) + 1 FROM ENDERECO";
            
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
