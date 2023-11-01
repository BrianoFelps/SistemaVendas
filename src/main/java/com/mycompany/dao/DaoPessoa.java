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
    
    public Boolean inserir (int id, int idend, int idestciv, String nom, String sob, String gen, String tel, String ema, String usua, String sen){
        try{
            sql = "INSERT INTO PESSOA (ID, ID_ENDERECO, ID_EST_CIV, NOME, SOBRENOME, GENERO, TELEFONE, EMAIL, USUARIO, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
                    getStatement().setInt(2, idend);
                    getStatement().setInt(3, idestciv);
                    getStatement().setString(4, nom);
                    getStatement().setString(5, sob);
                    getStatement().setString(6, gen);
                    getStatement().setString(7, tel);
                    getStatement().setString(8, ema);
                    getStatement().setString(9, usua);
                    getStatement().setString(10, sen);
                    
                    getStatement().executeUpdate();
                    
                    return true;
        }catch (Exception e){
        
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar (int id, int novoidend, int novoidestciv, String novonom, String novosob, String novogen, String novotel, String novoema, String novousu, String novasen){
        try{
            sql = "UPDATE PESSOA SET ID_ENDERECO = ?, ID_EST_CIV = ?, NOME = ?, SOBRENOME = ?, GENERO = ?, TELEFONE = ?, EMAIL = ?, USUARIO = ?, SENHA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, novoidend);
                getStatement().setInt(2, novoidestciv);
                getStatement().setString(3, novonom);
                getStatement().setString(4, novosob);
                getStatement().setString(5, novogen);
                getStatement().setString(6, novotel);
                getStatement().setString(7, novoema);
                getStatement().setString(8, novousu);
                getStatement().setString(9, novasen);
                 getStatement().setInt(10, id);
                 
                getStatement().executeUpdate();
                
                return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
     public Boolean alterarSenha(int id, String novaSenha){
        try{
            sql = "UPDATE PESSOA SET SENHA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(2, id);
            getStatement().setString(1, novaSenha);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
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
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                     + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE P.ID = ? "
                    + "ORDER BY P.ID";
            
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
        sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                     + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE E.NOME_RUA LIKE ? "
                    + "ORDER BY P.ID";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nomerua + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCEP(String cep){
        try{
        sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                     + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE E.CEP LIKE ? "
                    + "ORDER BY P.ID";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cep + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNumResid(String numR){
        try{
        sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                     + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE E.NUM_RESID LIKE ? "
                    + "ORDER BY P.ID";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, numR + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorEstCiv(String ec){
        try{
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE EC.NOME LIKE ? "
                    + "ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, ec + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE P.NOME LIKE ? "
                    + "ORDER BY P.ID";
            
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
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE P.SOBRENOME LIKE ? "
                    + "ORDER BY P.ID";
            
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
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID WHERE P.GENERO LIKE ? "
                    + "ORDER BY P.ID";
            
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
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE P.TELEFONE LIKE ? "
                    + "ORDER BY P.ID";
            
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
            sql = "SELECT P.ID, C.NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON P.ID_ENDERECO = E.ID "
                    + "JOIN CIDADE C "
                    + "ON E.ID_CIDADE = C.ID "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON P.ID_EST_CIV = EC.ID "
                    + "WHERE P.EMAIL LIKE ?"
                    + "ORDER BY P.ID";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, email + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet recuperaSenha(String usuario){
        try{
            sql = 
                " SELECT                            " +
                "   ID,                             " +
                "   SENHA                           " +
                " FROM                              " +
                "   PESSOA                          " +
                " WHERE USUARIO LIKE ?                 " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, usuario);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorUsuario(String usuario, boolean buscaParcial){
        try{
            sql = 
                    "SELECT P.ID, C. NOME, E.NOME_RUA, E.CEP, E.NUM_RESID, P.NOME, "
                    + "P.SOBRENOME, P.GENERO, P.TELEFONE, P.EMAIL, EC.NOME, P.USUARIO "
                    + "FROM PESSOA P "
                    + "JOIN ENDERECO E "
                    + "ON E.ID = P.ID_ENDERECO "
                    + "JOIN CIDADE C "
                    + "ON C.ID = E.ID_CIDADE "
                    + "JOIN ESTADO_CIVIL EC "
                    + "ON EC.ID = P.ID_EST_CIV "
                    + "WHERE P.USUARIO LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            if(buscaParcial)
                getStatement().setString(1, usuario + "%");
            else
                getStatement().setString(1, usuario);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
     public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL (MAX(ID), 0) + 1 FROM PESSOA";
            
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
