/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Pedido;

import com.mycompany.dao.DaoPedido;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian.7908
 */
public class ListPedido extends javax.swing.JFrame {

    /**
     * Creates new form ListPedido
     */
    public ListPedido() {
        initComponents();
        
        listarTodos();
        
        setLocationRelativeTo(null);
    }
    
      public void listarTodos(){
         try{
             DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
             tableProduto.setModel(dtm);
            
             DaoPedido daoped = new DaoPedido();
            
             ResultSet resultset = daoped.listarTodos();
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String cliente = resultset.getString(2);
                String prod = resultset.getString(3);
                String data = resultset.getString(4);
                String quant = resultset.getString(5);
                String total = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, cliente, prod, data, quant, total});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public void listarPorId(){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
             tableProduto.setModel(dtm);
            
             DaoPedido daoped = new DaoPedido();
            
            ResultSet resultset = daoped.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
               String id = resultset.getString(1);
                String cliente = resultset.getString(2);
                String prod = resultset.getString(3);
                String data = resultset.getString(4);
                String quant = resultset.getString(5);
                String total = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, cliente, prod, data, quant, total});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
     
     public void listarPorCliente(){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
                        tableProduto.setModel(dtm);
            
                        DaoPedido daoped = new DaoPedido();
                        
                        ResultSet resultset = daoped.listarPorCliente(tfFiltro.getText());
                        
                        dtm.setRowCount(0);
                    
                        while(resultset.next()){
                String id = resultset.getString(1);
                String cliente = resultset.getString(2);
                String prod = resultset.getString(3);
                String data = resultset.getString(4);
                String quant = resultset.getString(5);
                String total = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, cliente, prod, data, quant, total});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
     
     public void listarPorProduto(){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
                        tableProduto.setModel(dtm);
            
                        DaoPedido daoped = new DaoPedido();
                        
                        ResultSet resultset = daoped.listarPorProduto(tfFiltro.getText());
                        
                        dtm.setRowCount(0);
                    
                        while(resultset.next()){
                String id = resultset.getString(1);
                String cliente = resultset.getString(2);
                String prod = resultset.getString(3);
                String data = resultset.getString(4);
                String quant = resultset.getString(5);
                String total = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, cliente, prod, data, quant, total});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
    
     public void listarPorData(){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
                        tableProduto.setModel(dtm);
            
                        DaoPedido daoped = new DaoPedido();
                        
                        ResultSet resultset = daoped.listarPorData(tfFiltro.getText());
                        
                        dtm.setRowCount(0);
                    
                        while(resultset.next()){
                String id = resultset.getString(1);
                String cliente = resultset.getString(2);
                String prod = resultset.getString(3);
                String data = resultset.getString(4);
                String quant = resultset.getString(5);
                String total = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, cliente, prod, data, quant, total});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
     
     public void listarPorQuant(){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
                        tableProduto.setModel(dtm);
            
                        DaoPedido daoped = new DaoPedido();
                        
                        ResultSet resultset = daoped.listarPorQuant(tfFiltro.getText());
                        
                        dtm.setRowCount(0);
                    
                        while(resultset.next()){
                String id = resultset.getString(1);
                String cliente = resultset.getString(2);
                String prod = resultset.getString(3);
                String data = resultset.getString(4);
                String quant = resultset.getString(5);
                String total = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, cliente, prod, data, quant, total});
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
        tableProduto = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de pedidos");

        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do cliente", "Produto", "Data", "Quantidade", "Valor total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProduto);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Cliente", "Produto", "Data", "Quantidade" }));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
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
                .addContainerGap(7, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoFiltroActionPerformed

    private void tfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            listarPorId();
            break;
            case 2:
            listarPorCliente();
            break;
            case 3:
            listarPorProduto();
            break;
            case 4:
            listarPorData();
            break;
            case 5:
            listarPorQuant();
            break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableProduto;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
