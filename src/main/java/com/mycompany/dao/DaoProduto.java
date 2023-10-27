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
public class DaoProduto extends BancoDeDadosMySQL {
    private String sql;
    
    public  Boolean inserir (int id, int idcat, int idmar, String nom, String desc, String preco){
        try{
            sql = "INSERT INTO PRODUTO (ID, ID_CATG, ID_MARCA, NOME, DESCRICAO, PRECO) VALUES (?, ?, ?, ?, ?, ?) ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idcat);
                    getStatement().setInt(3, idmar);
                    getStatement().setString(4, nom);
                    getStatement().setString(5, desc);
                    getStatement().setString(6, preco);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar (int id, int novoidcat, int novoidmar, String novonom, String novadesc, String novopreco){
        try{
            sql = "UPDATE PRODUTO SET ID_CATG = ?, ID_MARCA = ?, NOME = ?, DESCRICAO = ?, PRECO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, novoidcat);
                getStatement().setInt(2, novoidmar);
                getStatement().setString(3, novonom);
                getStatement().setString(4, novadesc);
                getStatement().setString(5, novopreco);
                getStatement().setInt(6, id);
                
                getStatement().executeUpdate();
                
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir (int id){
        try{
            sql = "DELETE FROM PRODUTO WHERE ID = ?";
            
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
            sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID WHERE P.ID LIKE ? ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCatg(String nmcatg){
        try{
        sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID WHERE C.NOME LIKE ? ORDER BY P.ID";

        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nmcatg + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorMarca(String mar){
        try{
            sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID WHERE M.NOME LIKE ? ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, mar + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID WHERE P.NOME LIKE ? ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorDesc(String desc){
        try{
            sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID WHERE P.DESCRICAO LIKE ? ORDER BY P.ID";

            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, desc + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorPre(String prc){
        try{
            sql = "SELECT P.ID, C.NOME, M.NOME, P.NOME, P.DESCRICAO, P.PRECO FROM PRODUTO P JOIN CATEGORIA C ON P.ID_CATG = C.ID JOIN MARCA M ON P.ID_MARCA = M.ID WHERE P.PRECO LIKE ? ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, prc + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL (MAX(ID), 0) + 1 FROM PRODUTO";
            
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
