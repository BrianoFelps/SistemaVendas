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
public class DaoPessoa extends BancoDeDadosMySQL {
    private String sql;
    
    public Boolean inserir (int id, int idend, int idestciv, String nom, String sob, String gen, String tel, String ema){
        try{
            sql = "INSERT INTO PESSOA (ID, ID_ENDERECO, ID_EST_CIV, NOME, SOBRENOME, GENERO, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idend);
                    getStatement().setInt(3, idestciv);
                    getStatement().setString(4, nom);
                    getStatement().setString(5, sob);
                    getStatement().setString(6, gen);
                    getStatement().setString(7, tel);
                    getStatement().setString(8, ema);
                    
                    
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
    
    public ResultSet listarTodos(){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO,"
            + " P.TELEFONE, P.EMAIL FROM PESSOA P JOIN ENDERECO E ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC ON P.ID_EST_CIV = EC.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE P.ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorRua(String nomerua){
        try{
        sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE E.NOME_RUA = ?";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nomerua + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorEstCiv(String cidnome){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE EC.NOME = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cidnome + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE P.NOME = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorSob(String sobn){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE P.SOBRENOME = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, sobn + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorGen(String gen){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE P.GENERO = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, gen + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorTel(String tel){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE P.TELEFONE = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, tel + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorEmail(String email){
        try{
            sql = "SELECT P.ID, E.NOME_RUA, EC.NOME, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL"
                    + " FROM PESSOA P "
                    + " JOIN ENDERECO E "
                    + " ON E.ID_CIDADE = C.ID JOIN ESTADO_CIVIL EC "
                    + " ON P.ID_EST_CIV = EC.ID"
                    + " WHERE P.EMAIL = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, email + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM PESSOA";
            
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
