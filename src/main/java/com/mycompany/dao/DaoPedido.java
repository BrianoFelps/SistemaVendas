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
public class DaoPedido extends BancoDeDadosMySQL{
    private String sql;
    
    public Boolean inserir (int id, int idCli, int idProd, String data, int Quant){
        try{
            sql = "INSERT INTO PEDIDO (ID, ID_CLIENTE, ID_PROD, DATA_PED, QUANT) VALUES (?, ?, ?, ?, ?)";
            
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
    public Boolean alterar (int id, int nidCli, int nIdProd, String nData, int nQuant){
        try{
            sql = "UPDATE PEDIDO SET ID_CLIENTE = ?, ID_PROD= ?, DATA_PED = ?, QUANT = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
                getStatement().setInt(1, nidCli);
                getStatement().setInt(2, nIdProd);
                getStatement().setString(3, nData);
                 getStatement().setInt(4, nQuant);
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
            sql = "DELETE FROM PEDIDO WHERE ID = ?";
            
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
            sql = "select "
                    + "p.id as ID, "
                    + "pe.nome as Cliente, "
                    + "pr.nome as Produto, "
                    + "p.Data_ped, "
                    + "p.Quant as Quantidade, "
                    + "pr.preco * p.Quant as Valor_Total "
                    + "from pedido p "
                    + "join pessoa pe "
                    + "on "
                    + "p.id_cliente = pe.id "
                    + "join produto pr "
                    + "on "
                    + "p.id_prod = pr.id "
                    + "order by p.id";
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "select "
                    + "p.id as ID, "
                    + "pe.nome as Cliente, "
                    + "pr.nome as Produto, "
                    + "p.Data_ped, "
                    + "p.Quant as Quantidade, "
                    + "pr.preco * p.Quant as Valor_Total "
                    + "from pedido p "
                    + "join pessoa pe "
                    + "on "
                    + "p.id_cliente = pe.id "
                    + "join produto pr "
                    + "on "
                    + "p.id_prod = pr.id "
                    + "where p.id = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCliente(String nmCli){
        try{
            sql = "select "
                    + "p.id as ID, "
                    + "pe.nome as Cliente, "
                    + "pr.nome as Produto, "
                    + "p.Data_ped, "
                    + "p.Quant as Quantidade, "
                    + "pr.preco * p.Quant as Valor_Total "
                    + "from pedido p "
                    + "join pessoa pe "
                    + "on "
                    + "p.id_cliente = pe.id "
                    + "join produto pr "
                    + "on "
                    + "p.id_prod = pr.id "
                    + "where pe.nome like ? "
                    + "order by p.id";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nmCli + "%");
            
            setResultado (getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorProduto(String Prod){
        try{
        sql =       "select "
                    + "p.id as ID, "
                    + "pe.nome as Cliente, "
                    + "pr.nome as Produto, "
                    + "p.Data_ped, "
                    + "p.Quant as Quantidade, "
                    + "pr.preco * p.Quant as Valor_Total "
                    + "from pedido p "
                    + "join pessoa pe "
                    + "on "
                    + "p.id_cliente = pe.id "
                    + "join produto pr "
                    + "on "
                    + "p.id_prod = pr.id "
                    + "where pr.nome like ?"
                    + "order by p.id";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, Prod + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorData(String Data){
        try{
        sql =       "select "
                    + "p.id as ID, "
                    + "pe.nome as Cliente, "
                    + "pr.nome as Produto, "
                    + "p.Data_ped, "
                    + "p.Quant as Quantidade, "
                    + "pr.preco * p.Quant as Valor_Total "
                    + "from pedido p "
                    + "join pessoa pe "
                    + "on "
                    + "p.id_cliente = pe.id "
                    + "join produto pr "
                    + "on "
                    + "p.id_prod = pr.id "
                    + "where p.Data_ped like ?"
                    + "order by p.id";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, Data + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorQuant (String Quant){
        try{
        sql =  "select "
                    + "p.id as ID, "
                    + "pe.nome as Cliente, "
                    + "pr.nome as Produto, "
                    + "p.Data_ped, "
                    + "p.Quant as Quantidade, "
                    + "pr.preco * p.Quant as Valor_Total "
                    + "from pedido p "
                    + "join pessoa pe "
                    + "on "
                    + "p.id_cliente = pe.id "
                    + "join produto pr "
                    + "on "
                    + "p.id_prod = pr.id "
                    + "where p.Quant = ? "
                    + "order by p.id";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, Quant + "%");
            
            setResultado(getStatement().executeQuery());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
         public int buscarProximoId (){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL (MAX(ID), 0) + 1 FROM PEDIDO";
            
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
