/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Pessoa;

import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoEstciv;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brian.7908
 */
public class ListPessoa extends javax.swing.JFrame {

    /**
     * Creates new form ListPessoa
     */
    public ListPessoa() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
    public void listarTodos(){
         try{
             DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
             tablePessoa.setModel(dtm);
            
             DaoPessoa daopes = new DaoPessoa();
            
             ResultSet resultset = daopes.listarTodos();
            
            dtm.setRowCount(0);
            
            while (resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                String ec = resultset.getString(3);
                String nome = resultset.getString(4);
                String sob = resultset.getString(5);
                String gen = resultset.getString(6);
                String tel = resultset.getString(7);
                String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public void listarPorId(int pId){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
             tablePessoa.setModel(dtm);
            
             DaoPessoa daopes = new DaoPessoa();
            
            ResultSet resultset = daopes.listarPorId(pId);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                String ec = resultset.getString(3);
                String nome = resultset.getString(4);
                String sob = resultset.getString(5);
                String gen = resultset.getString(6);
                String tel = resultset.getString(7);
                String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
     
     public void listarPorRua(String pRua){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
                        
                        ResultSet resultset = daopes.listarPorRua(pRua);
                        
                        dtm.setRowCount(0);
                    
                        while (resultset.next()){
                            String id = resultset.getString(1);
                            String rua = resultset.getString(2);
                            String ec = resultset.getString(3);
                            String nome = resultset.getString(4);
                            String sob = resultset.getString(5);
                            String gen = resultset.getString(6);
                            String tel = resultset.getString(7);
                            String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
     
      public void ListarPorEC(String pEC){
                    try{
                        DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
                        
                        ResultSet resultset = daopes.listarPorEstCiv(pEC);
                        
                        dtm.setRowCount(0);
                    
                        while (resultset.next()){
                            String id = resultset.getString(1);
                            String rua = resultset.getString(2);
                            String ec = resultset.getString(3);
                            String nome = resultset.getString(4);
                            String sob = resultset.getString(5);
                            String gen = resultset.getString(6);
                            String tel = resultset.getString(7);
                            String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
      
        public void listarPorNome(String pNom){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
            
            ResultSet resultset = daopes.listarPorNome(pNom);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                String ec = resultset.getString(3);
                String nome = resultset.getString(4);
                String sob = resultset.getString(5);
                String gen = resultset.getString(6);
                String tel = resultset.getString(7);
                String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
        
          public void listarPorSob(String pSob){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
            
            ResultSet resultset = daopes.listarPorSob(pSob);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                            String ec = resultset.getString(3);
                            String nome = resultset.getString(4);
                            String sob = resultset.getString(5);
                            String gen = resultset.getString(6);
                            String tel = resultset.getString(7);
                            String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        }
          
          public void listarPorGen(String pGen){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
            
            ResultSet resultset = daopes.listarPorGen(pGen);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                            String ec = resultset.getString(3);
                            String nome = resultset.getString(4);
                            String sob = resultset.getString(5);
                            String gen = resultset.getString(6);
                            String tel = resultset.getString(7);
                            String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        }
          public void listarPorTel(String pTel){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
            
            ResultSet resultset = daopes.listarPorTel(pTel);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                            String ec = resultset.getString(3);
                            String nome = resultset.getString(4);
                            String sob = resultset.getString(5);
                            String gen = resultset.getString(6);
                            String tel = resultset.getString(7);
                            String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        }
          public void listarPorEma(String pEma){
        try{
            DefaultTableModel dtm = (DefaultTableModel) tablePessoa.getModel();
            
                        tablePessoa.setModel(dtm);
            
                        DaoPessoa daopes = new DaoPessoa();
            
            ResultSet resultset = daopes.listarPorEmail(pEma);
            
            dtm.setRowCount(0);
            
            while(resultset.next()){
                String id = resultset.getString(1);
                String rua = resultset.getString(2);
                            String ec = resultset.getString(3);
                            String nome = resultset.getString(4);
                            String sob = resultset.getString(5);
                            String gen = resultset.getString(6);
                            String tel = resultset.getString(7);
                            String ema = resultset.getString(8);
                
                dtm.addRow(new Object[] {id, rua, ec, nome, sob, gen, tel, ema});
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
        tablePessoa = new javax.swing.JTable();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de pessoas");

        tablePessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cidade", "Rua", "CEP", "Núm. Res.", "Estado Civil", "Nome", "Sobrenome", "Gênero", "Telefone", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePessoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePessoa);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Rua", "Estado Civil", "Nome", "Sobrenome", "Gênero", "Telefone", "E-mail" }));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
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
                .addContainerGap(18, Short.MAX_VALUE)
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

    private void tablePessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePessoaMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModPessoa modpes = new ModPessoa ();

                modpes.setId(Integer.parseInt(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 0))));
                modpes.setNom(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 3)));
                modpes.setSob(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 4)));
                modpes.setGen(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 5)));
                modpes.setTel(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 6)));
                modpes.setEma(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 7)));
               

                DaoEndereco daoend = new DaoEndereco();
                ResultSet resultset = daoend.listarPorRua(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 1)));
                
                int idEnd = -1;

                while(resultset.next())
                idEnd = resultset.getInt("ID");
                
                 DaoEstciv daoec = new DaoEstciv();
                resultset = daoec.listarPorNome(String.valueOf(tablePessoa.getValueAt(tablePessoa.getSelectedRow(), 2)));
                
                int idEC = -1;
                
                while(resultset.next())
                    idEC = resultset.getInt("ID");
                
                modpes.setIdend(idEnd);
                modpes.setIdestciv(idEC);
                
                DadosTemporarios.tempObject = (ModPessoa) modpes;

                CadPessoa cadpes = new CadPessoa();
                cadpes.setVisible(true);
            }
        }   catch (Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tablePessoaMouseClicked

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
            listarPorRua(tfFiltro.getText());
            break;
            case 3:
            ListarPorEC(tfFiltro.getText());
            break;
            case 4:
            listarPorNome(tfFiltro.getText());
            break;
            case 5:
            listarPorSob(tfFiltro.getText());
            break;
            case 6:
            listarPorGen(tfFiltro.getText());
            break;
            case 7:
            listarPorTel(tfFiltro.getText());
            break;
            case 8:
            listarPorEma(tfFiltro.getText());
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
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tablePessoa;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
