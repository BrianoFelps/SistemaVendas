/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Produto;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoMarca;
import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModProduto;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian.7908
 */
public class ListProduto extends javax.swing.JFrame {

    /**
     * Creates new form ListProduto
     */
    public ListProduto() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
public void listarTodos(){
         try{
             DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel();
            
             tableProduto.setModel(dtm);
            
             DaoProduto daoPro = new DaoProduto();
            
             ResultSet resultset = daoPro.listarTodos();
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public void listarPorId(int pId){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel ();

            tableProduto.setModel(dtm);
            
            DaoProduto daoPro = new DaoProduto();
            
            ResultSet resultset = daoPro.listarPorId(pId);
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
     
     public void listarPorCategoria(String pCat){
     try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel ();

            tableProduto.setModel(dtm);
            
            DaoProduto daoPro = new DaoProduto();
            
            ResultSet resultset = daoPro.listarPorCatg(pCat);
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
     }
     
     public void listarPorMarca(String pMar){
     try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel ();

            tableProduto.setModel(dtm);
            
            DaoProduto daoPro = new DaoProduto();
            
            ResultSet resultset = daoPro.listarPorMarca(pMar);
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
     }
     public void listarPorNome(String pNm){
     try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel ();

            tableProduto.setModel(dtm);
            
            DaoProduto daoPro = new DaoProduto();
            
            ResultSet resultset = daoPro.listarPorNome(pNm);
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
     }
     
     public void listarPorDesc(String pDesc){
     try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel ();

            tableProduto.setModel(dtm);
            
            DaoProduto daoPro = new DaoProduto();
            
            ResultSet resultset = daoPro.listarPorDesc(pDesc);
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
     }
     
     public void listarPorPreço(String pPreco){
     try{
            DefaultTableModel dtm = (DefaultTableModel) tableProduto.getModel ();

            tableProduto.setModel(dtm);
            
            DaoProduto daoPro = new DaoProduto();
            
            ResultSet resultset = daoPro.listarPorPre(pPreco);
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String catg = resultset.getString(2);
                String mar = resultset.getString(3);
                String nm = resultset.getString(4);
                String desc = resultset.getString(5);
                String prec = resultset.getString(6);
                
                dtm.addRow(new Object[] {id, catg, mar, nm, desc, prec});
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
        setTitle("Listagem de produtos");

        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Marca", "Produto", "Descrição", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduto);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Categoria", "Marca", "Produto", "Descrição", "Preço" }));
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

    private void tableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModProduto modPro = new ModProduto();

                modPro.setId(Integer.parseInt(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0))));
                modPro.setNm(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 3)));
                modPro.setDesc(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 4)));
                modPro.setPreco(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 5)));

                //
                DaoCategoria daoCatg = new DaoCategoria();
                ResultSet resultset = daoCatg.listarPorNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 1)));

                int idCatg = -1;
                resultset.next();
                idCatg = resultset.getInt("ID");

                modPro.setIdcatg(idCatg);
                //
                
                //
                DaoMarca daoMar = new DaoMarca();
                resultset = daoMar.listarPorNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 2)));
                
                int idMar = -1;
                resultset.next();
                idMar = resultset.getInt("ID");

                modPro.setIdmar(idMar);
                //
                
                DadosTemporarios.tempObject = (ModProduto) modPro;

                CadProduto cadPro = new CadProduto();
                cadPro.setVisible(true);
            }
        }   catch (Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tableProdutoMouseClicked

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
            listarPorCategoria(tfFiltro.getText());
            break;
            case 3:
            listarPorMarca(tfFiltro.getText());
            break;
            case 4:
            listarPorNome(tfFiltro.getText());
            break;
            case 5:
            listarPorDesc(tfFiltro.getText());
            break;
            case 6:
            listarPorPreço(tfFiltro.getText());
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
            java.util.logging.Logger.getLogger(ListProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProduto().setVisible(true);
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
