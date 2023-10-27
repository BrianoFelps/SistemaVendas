/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Produto;

import com.mycompany.dao.DaoCategoria;
import com.mycompany.dao.DaoMarca;
import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModProduto;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author brian.7908
 */
public class CadProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadProduto
     */
    public CadProduto() {
        initComponents();
        
        carregarMar();
        carregarCatg();
        
        if (!existeDadosTemporarios()) {
            DaoProduto daoProd = new DaoProduto();
            
              int id = daoProd.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
              btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
         recuperaIdMar();
         recuperaIdCatg();
         
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        tfIdCatg.setVisible(true);
        tfIdMar.setVisible(true);
    }
    
    private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModProduto){
            int id = ((ModProduto) DadosTemporarios.tempObject).getId();
            int idcatg = ((ModProduto) DadosTemporarios.tempObject).getIdcatg();
            int idmar = ((ModProduto) DadosTemporarios.tempObject).getIdmar();
            String nome = ((ModProduto) DadosTemporarios.tempObject).getNm();
            String preco = ((ModProduto) DadosTemporarios.tempObject).getPreco();
            String desc = ((ModProduto) DadosTemporarios.tempObject).getDesc();

            tfId.setText(String.valueOf(id));
            tfIdCatg.setText(String.valueOf(idcatg));
            tfIdMar.setText(String.valueOf(idmar));
            tfNm.setText(nome);
            tfPre.setText(String.valueOf(preco));
            taDesc.setText(desc);

            //
            try{
                DaoCategoria daocat = new DaoCategoria();
                ResultSet resultSet = daocat.listarPorId(idcatg);
                resultSet.next();
                String cat = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < JcbCatg.getItemCount(); i++){
                    if(JcbCatg.getItemAt(i).equals(cat)){
                        index = i;
                        break;
                    }
                }
                JcbCatg.setSelectedIndex(index);
            }catch(Exception e){
            System.out.println(e.getMessage());
            }
            
            try{
                DaoMarca daoMar = new DaoMarca();
                ResultSet resultSet = daoMar.listarPorId(idmar);
                resultSet.next();
                String marca = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < JcbMar.getItemCount(); i++){
                    if(JcbMar.getItemAt(i).equals(marca)){
                        index = i;
                        break;
                    }
                } 
                JcbMar.setSelectedIndex(index);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            DadosTemporarios.tempObject = null;
            
                return true;
            }else 
                return false;
}
    
        private void inserir(){
            DaoProduto daoProd = new DaoProduto();
            
            if (daoProd.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCatg.getText()), Integer.parseInt(tfIdMar.getText()), tfNm.getText(), taDesc.getText(),tfPre.getText())){
                JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
            
                tfId.setText("" + daoProd.buscarProximoId());
                tfNm.setText(" ");
                tfPre.setText(" ");
                taDesc.setText(" ");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o produto!");
            }
        }
        
        private void alterar(){
             DaoProduto daoProd = new DaoProduto();
            
             if (daoProd.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdCatg.getText()), Integer.parseInt(tfIdMar.getText()), tfNm.getText(), taDesc.getText(),tfPre.getText())){
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
                tfId.setText("" + daoProd.buscarProximoId());
                tfNm.setText(" ");
                tfPre.setText(" ");
                taDesc.setText(" ");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto!");
            }
            
            ((ListProduto) Formularios.ListProduto).listarTodos();
            
            dispose();
        }
        
        private void excluir(){
           DaoProduto daoProd = new DaoProduto();
            
            if (daoProd.excluir(Integer.parseInt(tfId.getText()))){
                JOptionPane.showMessageDialog(null, "Produto " + tfNm.getText() + " excluído com sucesso!");
            
                tfId.setText(" ");
                tfNm.setText(" ");
                tfPre.setText(" ");
                taDesc.setText(" ");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto!");
            }
            
            ((ListProduto) Formularios.ListProduto).listarTodos();
            
            dispose();
        }
        
         private void carregarCatg(){
        try{
            DaoCategoria daoCat = new DaoCategoria();

            ResultSet resultSet = daoCat.listarTodos();

            while(resultSet.next()){
                JcbCatg.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
        private void recuperaIdCatg(){
        try{
            DaoCategoria daoCat = new DaoCategoria();
            ResultSet resultSet = daoCat.listarPorNome(JcbCatg.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCatg.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
         private void carregarMar(){
        try{
            DaoMarca daoMar = new DaoMarca();

            ResultSet resultSet = daoMar.listarTodos();

            while(resultSet.next()){
                JcbMar.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
        }
    }
        
        private void recuperaIdMar(){
        try{
            DaoMarca daoMar = new DaoMarca();
            ResultSet resultSet = daoMar.listarPorNome(JcbMar.getSelectedItem().toString());
           
            resultSet.next();
            tfIdMar.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        tfNm = new javax.swing.JTextField();
        LId = new javax.swing.JLabel();
        LNome = new javax.swing.JLabel();
        LDesc = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfIdCatg = new javax.swing.JTextField();
        JcbCatg = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfPre = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        JcbMar = new javax.swing.JComboBox<>();
        tfIdMar = new javax.swing.JTextField();
        LNome1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        LDesc1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tfNm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNmActionPerformed(evt);
            }
        });

        LId.setText("ID");

        LNome.setText("Categoria");

        LDesc.setText("Nome");

        tfIdCatg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdCatgActionPerformed(evt);
            }
        });

        JcbCatg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcbCatgItemStateChanged(evt);
            }
        });
        JcbCatg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbCatgActionPerformed(evt);
            }
        });

        jLabel1.setText("Preço");

        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        JcbMar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcbMarItemStateChanged(evt);
            }
        });
        JcbMar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbMarActionPerformed(evt);
            }
        });

        tfIdMar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdMarActionPerformed(evt);
            }
        });

        LNome1.setText("Marca");

        taDesc.setColumns(20);
        taDesc.setRows(5);
        jScrollPane1.setViewportView(taDesc);

        LDesc1.setText("Descrição");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(LNome1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JcbMar, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIdMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNm, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LDesc)
                            .addComponent(LNome)
                            .addComponent(LId)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JcbCatg, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfIdCatg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LDesc1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(tfPre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LNome)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbCatg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCatg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LDesc)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LDesc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAcao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
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

    private void tfNmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNmActionPerformed

    private void tfIdCatgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdCatgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdCatgActionPerformed

    private void JcbCatgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcbCatgItemStateChanged
        // TODO add your handling code here:
        recuperaIdCatg();
    }//GEN-LAST:event_JcbCatgItemStateChanged

    private void JcbCatgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbCatgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbCatgActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        // TODO add your handling code here:
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
        inserir();
        
        if(Formularios.CadCategoria != null){
            ((CadProduto) Formularios.CadProduto).carregarCatg();
            dispose();
        }else if (Formularios.CadMarca != null){
        ((CadProduto) Formularios.CadProduto).carregarMar();
        dispose();
        }
        }else if (btnAcao.getText().equals(Constantes.BTN_ALTERAR_TEXT))
        alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int escolha =
        JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o produto " + tfNm.getText() + "?");

        if (escolha == JOptionPane.YES_OPTION)
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void JcbMarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcbMarItemStateChanged
        // TODO add your handling code here:
        recuperaIdMar();
    }//GEN-LAST:event_JcbMarItemStateChanged

    private void JcbMarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbMarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbMarActionPerformed

    private void tfIdMarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdMarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdMarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Formularios.CadProduto = null;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbCatg;
    private javax.swing.JComboBox<String> JcbMar;
    private javax.swing.JLabel LDesc;
    private javax.swing.JLabel LDesc1;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNome;
    private javax.swing.JLabel LNome1;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCatg;
    private javax.swing.JTextField tfIdMar;
    private javax.swing.JTextField tfNm;
    private javax.swing.JTextField tfPre;
    // End of variables declaration//GEN-END:variables
}
