/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.endereco;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEndereco;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author brian.7908
 */
public class CadEndereco extends javax.swing.JFrame {

    /**
     * Creates new form CadEndereco
     */
    public CadEndereco() {
        initComponents();
        
        carregarCidades();
        
         if (!existeDadosTemporarios()) {
            DaoEndereco daoend = new DaoEndereco();
            
            int id = daoend.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
         recuperaIdCid();
         
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfidcid.setVisible(true);
    }
    
    private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModEndereco){
            int id = ((ModEndereco) DadosTemporarios.tempObject).getId();
            int idcid = ((ModEndereco) DadosTemporarios.tempObject).getIdcid();
            String nmrua = ((ModEndereco) DadosTemporarios.tempObject).getRua();
            int cep = ((ModEndereco) DadosTemporarios.tempObject).getCep();
            int num = ((ModEndereco) DadosTemporarios.tempObject).getNum();

            tfId.setText(String.valueOf(id));
            tfidcid.setText(String.valueOf(idcid));
            tfRua.setText(nmrua);
            tfCEP.setText(String.valueOf(cep));
            tfNum.setText(String.valueOf(num));

            //
            try{
                DaoCidade daocid = new DaoCidade();
                ResultSet resultSet = daocid.listarPorId(idcid);
                resultSet.next();
                String cid = resultSet.getString("C.NOME");
                int index = 0;
                for(int i = 0; i < JcbCid.getItemCount(); i++){
                    if(JcbCid.getItemAt(i).equals(cid)){
                        index = i;
                        break;
                    }
                }
                JcbCid.setSelectedIndex(index);
            }catch(Exception e){}
            //
            
            DadosTemporarios.tempObject = null;
            
                return true;
            }else 
                return false;
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
        tfRua = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        LId = new javax.swing.JLabel();
        LNome = new javax.swing.JLabel();
        LDesc = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfidcid = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        JcbCid = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JTextField();
        tfNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de endereço");

        tfRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRuaActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        LId.setText("ID");

        LNome.setText("Cidade");

        LDesc.setText("Rua");

        tfidcid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidcidActionPerformed(evt);
            }
        });

        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        JcbCid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcbCidItemStateChanged(evt);
            }
        });
        JcbCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbCidActionPerformed(evt);
            }
        });

        jLabel1.setText("CEP");

        jLabel2.setText("Núm");

        tfNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfRua)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JcbCid, 0, 405, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LDesc)
                                            .addComponent(LNome)
                                            .addComponent(LId)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnAcao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnExcluir))
                                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfidcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfidcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addComponent(btnAcao))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

    private void tfRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRuaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int escolha =
        JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a cidade " + tfRua.getText() + "?");

        if (escolha == JOptionPane.YES_OPTION)
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfidcidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidcidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidcidActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        // TODO add your handling code here:
        if (btnAcao.getText().equals(Constantes.BTN_SALVAR_TEXT))
        inserir();
        else if (btnAcao.getText().equals(Constantes.BTN_ALTERAR_TEXT))
        alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void JcbCidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcbCidItemStateChanged
        // TODO add your handling code here:
        recuperaIdCid();
    }//GEN-LAST:event_JcbCidItemStateChanged

    private void JcbCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbCidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbCidActionPerformed

    private void tfNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumActionPerformed

    private void inserir(){
            DaoEndereco daoend = new DaoEndereco();
            
            if (daoend.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidcid.getText()), tfRua.getText(),  Integer.parseInt(tfCEP.getText()),  Integer.parseInt(tfNum.getText()))){
                JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
            
                tfId.setText("" + daoend.buscarProximoId());
                tfRua.setText(" ");
                tfCEP.setText(" ");
                tfNum.setText(" ");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
            }
        }
        
        private void alterar(){
            DaoEndereco daoend = new DaoEndereco();
            
            if (daoend.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidcid.getText()), tfRua.getText(),  Integer.parseInt(tfCEP.getText()),  Integer.parseInt(tfNum.getText()))){
                JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!");
            
                tfId.setText (" ");
                tfidcid.setText(" ");
                tfRua.setText(" ");
                tfCEP.setText(" ");
                tfNum.setText(" ");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o estado!");
            }
            
            ((ListEndereco) Formularios.ListEndereco).listarTodos();
            
            dispose();
        }
        
        private void excluir(){
            DaoEndereco daoend = new DaoEndereco();
            
            if (daoend.excluir(Integer.parseInt(tfId.getText()))){
                JOptionPane.showMessageDialog(null, "Endereço " + tfRua.getText() + " excluído com sucesso!");
            
                tfId.setText ("");
                tfidcid.setText("");
                tfRua.setText("");
                tfCEP.setText("");
                tfNum.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereço!");
            }
            
            ((ListEndereco) Formularios.ListEndereco).listarTodos();
            
            dispose();
        }
        
        private void carregarCidades(){
        try{
            DaoCidade daocid = new DaoCidade();

            ResultSet resultSet = daocid.listarTodos();

            while(resultSet.next()){
                JcbCid.addItem(resultSet.getString("C.NOME"));
            }
        }catch(Exception e){
            
        }
    }
        
        private void recuperaIdCid(){
        try{
            DaoCidade daocid = new DaoCidade();
            ResultSet resultSet = daocid.listarPorNome(JcbCid.getSelectedItem().toString());
            resultSet.next();
            tfidcid.setText(resultSet.getString("C.ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
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
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbCid;
    private javax.swing.JLabel LDesc;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNome;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfidcid;
    // End of variables declaration//GEN-END:variables
}