/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros;

import com.mycompany.ferramentas.BancoDeDadosMySQL;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.visao.categoria.CadCategoria;
import com.mycompany.visao.categoria.ListCategoria;
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
        mbtncons = new javax.swing.JMenu();
        miConsCatg = new javax.swing.JMenuItem();

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

        MenuBar.add(mbtnCad);

        mbtncons.setText("Consultas");

        miConsCatg.setText("Categoria");
        miConsCatg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsCatgActionPerformed(evt);
            }
        });
        mbtncons.add(miConsCatg);

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
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu mbtnCad;
    private javax.swing.JMenu mbtncons;
    private javax.swing.JMenuItem miCadCatg;
    private javax.swing.JMenuItem miConsCatg;
    // End of variables declaration//GEN-END:variables
}
