/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.categoria;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModCategoria;
//import com.mysql.cj.protocol.Resultset; da errado
import java.sql.ResultSet;
import java.util.ServiceLoader;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian.7908
 */
public class ListCategoria extends javax.swing.JFrame {

    /**
     * Creates new form ListCategoria
     */
    public ListCategoria() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }

    public void listarTodos(){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableCategoria.getModel ();
            
            tableCategoria.setModel (dtm);
            //data access object
            DaoCategoria daocatg = new DaoCategoria();
            
            //é tipo um select do mysql, só que essa tabela fica na memoria do computador
            ResultSet resultSet = daocatg.listarTodos();
            
            dtm.setRowCount(0);
            //next + enquanto tiver proximos registros, o laço de repetição será rodado
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String descricao = resultSet.getString(3);
                
                dtm.addRow(new Object [] {id, nome, descricao});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
        public void listarPorId(int pId){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableCategoria.getModel ();
            
            tableCategoria.setModel (dtm);
            //data access object
            DaoCategoria daocatg = new DaoCategoria();
            
            //é tipo um select do mysql, só que essa tabela fica na memoria do computador
            ResultSet resultSet = daocatg.listarPorId(pId);
            
            dtm.setRowCount(0);
            //next + enquanto tiver proximos registros, o laço de repetição será rodado
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String descricao = resultSet.getString(3);
                
                dtm.addRow(new Object [] {id, nome, descricao});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
                public void listarPorNome(String pNome){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableCategoria.getModel ();
            
            tableCategoria.setModel (dtm);
            //data access object
            DaoCategoria daocatg = new DaoCategoria();
            
            //é tipo um select do mysql, só que essa tabela fica na memoria do computador
            ResultSet resultSet = daocatg.listarPorNome(pNome);
            
            dtm.setRowCount(0);
            //next + enquanto tiver proximos registros, o laço de repetição será rodado
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String descricao = resultSet.getString(3);
                
                dtm.addRow(new Object [] {id, nome, descricao});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
                
             public void listarPorDescricao(String pDesc){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableCategoria.getModel ();
            
            tableCategoria.setModel (dtm);
            //data access object
            DaoCategoria daocatg = new DaoCategoria();
            
            //é tipo um select do mysql, só que essa tabela fica na memoria do computador
            ResultSet resultSet = daocatg.listarPorDescricao(pDesc);
            
            dtm.setRowCount(0);
            //next + enquanto tiver proximos registros, o laço de repetição será rodado
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String descricao = resultSet.getString(3);
                
                dtm.addRow(new Object [] {id, nome, descricao});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategoria = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de categorias");

        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCategoria);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nome", "Descrição" }));
        jcbTipoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoFiltroActionPerformed(evt);
            }
        });

        tfFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFiltroActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoFiltroActionPerformed

    private void tableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoriaMouseClicked
        if (evt.getClickCount() == 2){
            ModCategoria modcatg = new ModCategoria ();

            modcatg.setId(Integer.parseInt(String.valueOf(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 0))));
            modcatg.setNome(String.valueOf(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 1)));
            modcatg.setDescricao(String.valueOf(tableCategoria.getValueAt(tableCategoria.getSelectedRow(), 2)));

            DadosTemporarios.tempObject = (ModCategoria) modcatg;

            CadCategoria cadcatg = new CadCategoria();
            cadcatg.setVisible(true);
        }
    }//GEN-LAST:event_tableCategoriaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            listarPorId(Integer.parseInt(tfFiltro.getText()));
            break;
            case 2:
            listarPorNome(tfFiltro.getText());
            break;
            case 3:
            listarPorDescricao(tfFiltro.getText());
            break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableCategoria;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
