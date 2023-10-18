/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.endereco;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModEndereco;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian.7908
 */
public class ListEndereco extends javax.swing.JFrame {

    /**
     * Creates new form ListEndereco
     */
    public ListEndereco() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
     public void listarTodos(){
         try{
             DefaultTableModel dtm = (DefaultTableModel) tableEndereco.getModel();
            
             tableEndereco.setModel(dtm);
            
             DaoEndereco daoend = new DaoEndereco();
            
             ResultSet resultset = daoend.listarTodos();
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String cid = resultset.getString(2);
                String rua = resultset.getString(3);
                String cep = resultset.getString(4);
                String num = resultset.getString(5);
                
                dtm.addRow(new Object[] {id, cid, rua, cep, num});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public void listarPorId(int pId){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableEndereco.getModel ();

            tableEndereco.setModel(dtm);
            
            DaoEndereco daoend = new DaoEndereco();
            
            ResultSet resultset = daoend.listarPorId(pId);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String cid = resultset.getString(2);
                String rua = resultset.getString(3);
                String cep = resultset.getString(4);
                String num = resultset.getString(5);
                
                dtm.addRow(new Object [] {id, cid, rua, cep, num});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
     
     public void listarPorRua(String pRua){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tableEndereco.getModel ();

                        tableEndereco.setModel(dtm);
                        
                        DaoEndereco daoend = new DaoEndereco();
                        
                        ResultSet resultset = daoend.listarPorRua(pRua);
                        
                        dtm.setRowCount(0);
                    
                        while (resultset.next()){
                            String id = resultset.getString(1);
                            String cid = resultset.getString(2);
                            String rua = resultset.getString(3);
                            String cep = resultset.getString(4);
                            String num = resultset.getString(5);
                            
                            dtm.addRow(new Object [] {id, cid, rua, cep, num});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
     
      public void ListarPorCidade(String nmCid){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tableEndereco.getModel ();

                        tableEndereco.setModel(dtm);
                        
                        DaoEndereco daoend = new DaoEndereco();
                        
                        ResultSet resultset = daoend.listarPorCidade(nmCid);
                        
                        dtm.setRowCount(0);
                    
                        while (resultset.next()){
                            String id = resultset.getString(1);
                            String cid = resultset.getString(2);
                            String rua = resultset.getString(3);
                            String cep = resultset.getString(4);
                            String num = resultset.getString(5);
                            
                            dtm.addRow(new Object [] {id, cid, rua, cep, num});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
      
        public void listarPorCEP(int pCep){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableEndereco.getModel ();

            tableEndereco.setModel(dtm);
            
            DaoEndereco daoend = new DaoEndereco();
            
            ResultSet resultset = daoend.listarPorCep(pCep);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String cid = resultset.getString(2);
                String rua = resultset.getString(3);
                String cep = resultset.getString(4);
                String num = resultset.getString(5);
                
                dtm.addRow(new Object [] {id, cid, rua, cep, num});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
        
          public void listarPorNum(int pNum){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableEndereco.getModel ();

            tableEndereco.setModel(dtm);
            
            DaoEndereco daoend = new DaoEndereco();
            
            ResultSet resultset = daoend.listarPorNum(pNum);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String cid = resultset.getString(2);
                String rua = resultset.getString(3);
                String cep = resultset.getString(4);
                String num = resultset.getString(5);
                
                dtm.addRow(new Object [] {id, cid, rua, cep, num});
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
        tableEndereco = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de endereços");

        tableEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cidade", "Rua", "CEP", "Núm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEndereco);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Cidade", "Rua", "CEP", "Núm." }));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tableEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEnderecoMouseClicked
        try{
        if (evt.getClickCount() == 2){
            ModEndereco modend = new ModEndereco ();

            modend.setId(Integer.parseInt(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 0))));
            modend.setRua(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 2)));
            modend.setCep(Integer.parseInt(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 3))));
            modend.setNum(Integer.parseInt(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 4))));
            
            DaoCidade daocid = new DaoCidade();
            ResultSet resultset = daocid.listarPorNome(String.valueOf(tableEndereco.getValueAt(tableEndereco.getSelectedRow(), 1)));
            
            int idCid = -1;
            
            while(resultset.next())
                idCid = resultset.getInt("ID");
            
            modend.setIdcid(idCid);

            DadosTemporarios.tempObject = (ModEndereco) modend;

            CadEndereco cadend = new CadEndereco();
            cadend.setVisible(true);
                   }
                }   catch (Exception e){ 
                    System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tableEnderecoMouseClicked

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
            listarPorId(Integer.parseInt(tfFiltro.getText()));
            break;
            case 2:
            ListarPorCidade(tfFiltro.getText());
            break;
            case 3:
            listarPorRua(tfFiltro.getText());
            break;
            case 4:
            listarPorCEP(Integer.parseInt(tfFiltro.getText()));
            break;
            case 5:
            listarPorNum(Integer.parseInt(tfFiltro.getText()));
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
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableEndereco;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
