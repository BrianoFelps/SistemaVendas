/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros;

import com.mycompany.ferramentas.BancoDeDadosMySQL;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.visao.Cliente.ListCliente;
import com.mycompany.visao.Pessoa.CadPessoa;
import com.mycompany.visao.Pessoa.ListPessoa;
import com.mycompany.visao.categoria.CadCategoria;
import com.mycompany.visao.categoria.ListCategoria;
import com.mycompany.visao.cidade.CadCidade;
import com.mycompany.visao.cidade.ListCidade;
import com.mycompany.visao.endereco.CadEndereco;
import com.mycompany.visao.endereco.ListEndereco;
import com.mycompany.visao.estado.CadEstado;
import com.mycompany.visao.estado.ListEstado;
import com.mycompany.visao.estciv.CadEstciv;
import com.mycompany.visao.estciv.ListEstciv;
import com.mycompany.visao.marca.CadMarca;
import com.mycompany.visao.marca.ListMarca;
import com.mycompany.visao.pais.CadPais;
import com.mycompany.visao.pais.ListPais;
import javax.swing.JOptionPane;

/**
 *
 * @author brian.7908
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        if (!BancoDeDadosMySQL.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuBar = new javax.swing.JMenuBar();
        mbtnCad = new javax.swing.JMenu();
        miCadCatg = new javax.swing.JMenuItem();
        CadPais = new javax.swing.JMenuItem();
        miMarca = new javax.swing.JMenuItem();
        CadEstciv = new javax.swing.JMenuItem();
        CadEstado = new javax.swing.JMenuItem();
        CadCidade = new javax.swing.JMenuItem();
        CadEndereco = new javax.swing.JMenuItem();
        CadPessoa = new javax.swing.JMenuItem();
        mbtncons = new javax.swing.JMenu();
        miConsCatg = new javax.swing.JMenuItem();
        ListPais = new javax.swing.JMenuItem();
        ConsMarca = new javax.swing.JMenuItem();
        listEstciv = new javax.swing.JMenuItem();
        ListEstado = new javax.swing.JMenuItem();
        ListCidade = new javax.swing.JMenuItem();
        ListEndereco = new javax.swing.JMenuItem();
        ListPessoa = new javax.swing.JMenuItem();
        ListagemClientes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        mbtnCad.setText("Cadastros");

        miCadCatg.setText("Categoria");
        miCadCatg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadCatgActionPerformed(evt);
            }
        });
        mbtnCad.add(miCadCatg);

        CadPais.setText("País");
        CadPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadPaisActionPerformed(evt);
            }
        });
        mbtnCad.add(CadPais);

        miMarca.setText("Marca");
        miMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMarcaActionPerformed(evt);
            }
        });
        mbtnCad.add(miMarca);

        CadEstciv.setText("Estado civil");
        CadEstciv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadEstcivActionPerformed(evt);
            }
        });
        mbtnCad.add(CadEstciv);

        CadEstado.setText("Estado");
        CadEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadEstadoActionPerformed(evt);
            }
        });
        mbtnCad.add(CadEstado);

        CadCidade.setText("Cidade");
        CadCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadCidadeActionPerformed(evt);
            }
        });
        mbtnCad.add(CadCidade);

        CadEndereco.setText("Endereço");
        CadEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadEnderecoActionPerformed(evt);
            }
        });
        mbtnCad.add(CadEndereco);

        CadPessoa.setText("Pessoa");
        CadPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadPessoaActionPerformed(evt);
            }
        });
        mbtnCad.add(CadPessoa);

        MenuBar.add(mbtnCad);

        mbtncons.setText("Consultas");

        miConsCatg.setText("Categorias");
        miConsCatg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsCatgActionPerformed(evt);
            }
        });
        mbtncons.add(miConsCatg);

        ListPais.setText("Países");
        ListPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListPaisActionPerformed(evt);
            }
        });
        mbtncons.add(ListPais);

        ConsMarca.setText("Marcas");
        ConsMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsMarcaActionPerformed(evt);
            }
        });
        mbtncons.add(ConsMarca);

        listEstciv.setText("Estados civis");
        listEstciv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEstcivActionPerformed(evt);
            }
        });
        mbtncons.add(listEstciv);

        ListEstado.setText("Estados");
        ListEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListEstadoActionPerformed(evt);
            }
        });
        mbtncons.add(ListEstado);

        ListCidade.setText("Cidades");
        ListCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListCidadeActionPerformed(evt);
            }
        });
        mbtncons.add(ListCidade);

        ListEndereco.setText("Endereços");
        ListEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListEnderecoActionPerformed(evt);
            }
        });
        mbtncons.add(ListEndereco);

        ListPessoa.setText("Pessoas");
        ListPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListPessoaActionPerformed(evt);
            }
        });
        mbtncons.add(ListPessoa);

        ListagemClientes.setText("Cliente");
        ListagemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemClientesActionPerformed(evt);
            }
        });
        mbtncons.add(ListagemClientes);

        MenuBar.add(mbtncons);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadCatgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadCatgActionPerformed
//        CadCategoria cadcategoria = new CadCategoria();
//        cadcategoria.setVisible(true);        // TODO add your handling code here:

        if (Formularios.CadCategoria == null)
            Formularios.CadCategoria = new CadCategoria();
        
        Formularios.CadCategoria.setVisible(true);
    }//GEN-LAST:event_miCadCatgActionPerformed

    private void miConsCatgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsCatgActionPerformed
       if (Formularios.ListCategoria == null)
            Formularios.ListCategoria = new ListCategoria();
        
        Formularios.ListCategoria.setVisible(true);
    }//GEN-LAST:event_miConsCatgActionPerformed

    private void CadPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadPaisActionPerformed
        // TODO add your handling code here:
            if (Formularios.CadPais == null)
                Formularios.CadPais = new CadPais();
            
            Formularios.CadPais.setVisible(true);
    }//GEN-LAST:event_CadPaisActionPerformed

    private void ListPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListPaisActionPerformed
        // TODO add your handling code here:
            if (Formularios.ListPais == null)
                Formularios.ListPais = new ListPais();
            
            Formularios.ListPais.setVisible(true);
    }//GEN-LAST:event_ListPaisActionPerformed

    private void miMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMarcaActionPerformed
        // TODO add your handling code here:
        if (Formularios.CadMarca == null)
            Formularios.CadMarca = new CadMarca();
        
        Formularios.CadMarca.setVisible(true);
        
    }//GEN-LAST:event_miMarcaActionPerformed

    private void ConsMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsMarcaActionPerformed
        // TODO add your handling code here:
        if (Formularios.ListMarca == null)
            Formularios.ListMarca = new ListMarca();
        
        Formularios.ListMarca.setVisible(true);
    }//GEN-LAST:event_ConsMarcaActionPerformed

    private void CadEstcivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadEstcivActionPerformed
        // TODO add your handling code here:
         if (Formularios.CadEstciv == null)
            Formularios.CadEstciv = new CadEstciv();
        
        Formularios.CadEstciv.setVisible(true);
    }//GEN-LAST:event_CadEstcivActionPerformed

    private void listEstcivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEstcivActionPerformed
        // TODO add your handling code here:
          if (Formularios.ListEstciv == null)
            Formularios.ListEstciv = new ListEstciv();
        
        Formularios.ListEstciv.setVisible(true);                                         
    }//GEN-LAST:event_listEstcivActionPerformed

    private void ListEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListEstadoActionPerformed
        // TODO add your handling code here:
        if (Formularios.ListEstado == null)
            Formularios.ListEstado = new ListEstado();
        
        Formularios.ListEstado.setVisible(true);          
    }//GEN-LAST:event_ListEstadoActionPerformed

    private void CadEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadEstadoActionPerformed
        // TODO add your handling code here:
         if (Formularios.CadEstado == null)
            Formularios.CadEstado = new CadEstado();
        
        Formularios.CadEstado.setVisible(true);    
    }//GEN-LAST:event_CadEstadoActionPerformed

    private void CadCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadCidadeActionPerformed
        // TODO add your handling code here:
        if (Formularios.CadCidade == null)
            Formularios.CadCidade = new CadCidade();
        
        Formularios.CadCidade.setVisible(true);  
    }//GEN-LAST:event_CadCidadeActionPerformed

    private void ListCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListCidadeActionPerformed
        // TODO add your handling code here:
         if (Formularios.ListCidade == null)
            Formularios.ListCidade = new ListCidade();
        
        Formularios.ListCidade.setVisible(true);    
    }//GEN-LAST:event_ListCidadeActionPerformed

    private void CadEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadEnderecoActionPerformed
        // TODO add your handling code here:
         if (Formularios.CadEndereco == null)
            Formularios.CadEndereco = new CadEndereco();
        
        Formularios.CadEndereco.setVisible(true); 
    }//GEN-LAST:event_CadEnderecoActionPerformed

    private void ListEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListEnderecoActionPerformed
        // TODO add your handling code here:
        if (Formularios.ListEndereco == null)
            Formularios.ListEndereco = new ListEndereco();
        
        Formularios.ListEndereco.setVisible(true);    
    }//GEN-LAST:event_ListEnderecoActionPerformed

    private void CadPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadPessoaActionPerformed
        // TODO add your handling code here:
        if (Formularios.CadPessoa == null)
            Formularios.CadPessoa = new CadPessoa();
        
        Formularios.CadPessoa.setVisible(true);
    }//GEN-LAST:event_CadPessoaActionPerformed

    private void ListPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListPessoaActionPerformed
        // TODO add your handling code here:
        if (Formularios.ListPessoa == null)
        Formularios.ListPessoa = new ListPessoa();

        Formularios.ListPessoa.setVisible(true);
    }//GEN-LAST:event_ListPessoaActionPerformed

    private void ListagemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemClientesActionPerformed
        // TODO add your handling code here:
         if (Formularios.ListCliente == null)
        Formularios.ListCliente = new ListCliente();

        Formularios.ListCliente.setVisible(true);
    }//GEN-LAST:event_ListagemClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadCidade;
    private javax.swing.JMenuItem CadEndereco;
    private javax.swing.JMenuItem CadEstado;
    private javax.swing.JMenuItem CadEstciv;
    private javax.swing.JMenuItem CadPais;
    private javax.swing.JMenuItem CadPessoa;
    private javax.swing.JMenuItem ConsMarca;
    private javax.swing.JMenuItem ListCidade;
    private javax.swing.JMenuItem ListEndereco;
    private javax.swing.JMenuItem ListEstado;
    private javax.swing.JMenuItem ListPais;
    private javax.swing.JMenuItem ListPessoa;
    private javax.swing.JMenuItem ListagemClientes;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem listEstciv;
    private javax.swing.JMenu mbtnCad;
    private javax.swing.JMenu mbtncons;
    private javax.swing.JMenuItem miCadCatg;
    private javax.swing.JMenuItem miConsCatg;
    private javax.swing.JMenuItem miMarca;
    // End of variables declaration//GEN-END:variables
}
