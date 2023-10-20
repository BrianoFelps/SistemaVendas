/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Cliente;

import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCliente;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author brian.7908
 */
public class CadCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadCliente
     */
    public CadCliente() {
        initComponents();
        
        carregarPessoas();
        
         if (!existeDadosTemporarios()) {
             DaoCliente daocli = new DaoCliente();
            
            int id = daocli.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
         recuperaIdPessoa();
         
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfidnome.setVisible(false);
    }
    
    private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModCliente){
            int id = ((ModCliente) DadosTemporarios.tempObject).getId();
            int idpessoa = ((ModCliente) DadosTemporarios.tempObject).getIdpes();

            tfId.setText(String.valueOf(id));
            tfidnome.setText(String.valueOf(idpessoa));
            //
            try{
                DaoPessoa daoPes = new DaoPessoa();
                ResultSet resultSet = daoPes.listarPorId(idpessoa);
                resultSet.next();
                String pess = resultSet.getString("P.NOME");
                int index = 0;
                for(int i = 0; i < JcbNome.getItemCount(); i++){
                    if(JcbNome.getItemAt(i).equals(pess)){
                        index = i;
                        break;
                    }
                }
                JcbNome.setSelectedIndex(index);
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
        btnExcluir = new javax.swing.JButton();
        LId = new javax.swing.JLabel();
        LNome = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfidnome = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        JcbNome = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        LId.setText("ID");

        LNome.setText("Nome da pessoa");

        tfidnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidnomeActionPerformed(evt);
            }
        });

        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        JcbNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcbNomeJcbEstItemStateChanged(evt);
            }
        });
        JcbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LNome)
                            .addComponent(LId)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir))
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JcbNome, 0, 284, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfidnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
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
                    .addComponent(JcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfidnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int escolha =
        JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cliente " + JcbNome.getSelectedItem()+ "?");

        if (escolha == JOptionPane.YES_OPTION)
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfidnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidnomeActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        // TODO add your handling code here:
        if (btnAcao.getText().equals(Constantes.BTN_SALVAR_TEXT))
        inserir();
        else if (btnAcao.getText().equals(Constantes.BTN_ALTERAR_TEXT))
        alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void JcbNomeJcbEstItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcbNomeJcbEstItemStateChanged
        // TODO add your handling code here:
        recuperaIdPessoa();
    }//GEN-LAST:event_JcbNomeJcbEstItemStateChanged

    private void JcbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbNomeActionPerformed

    private void inserir(){
            DaoCliente daoCli = new DaoCliente();
            
            if (daoCli.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidnome.getText()))){
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
            
                tfId.setText("" + daoCli.buscarProximoId());
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o cliente!");
            }
        }
        
        private void alterar(){
            DaoCliente daoCli = new DaoCliente();
            
            if (daoCli.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidnome.getText()))){
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
            
                tfId.setText (" ");
                tfidnome.setText(" ");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o cliente!");
            }
            
            ((ListCliente) Formularios.ListCliente).listarTodos();
            
            dispose();
        }
        
        private void excluir(){
            DaoCliente daoCli = new DaoCliente();
            
            if (daoCli.excluir(Integer.parseInt(tfId.getText()))){
                JOptionPane.showMessageDialog(null, "Cliente " + JcbNome.getSelectedItem() + " excluído com sucesso!");
            
                tfId.setText ("");
                tfidnome.setText("");

            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente!");
            }
            
            ((ListCliente) Formularios.ListCliente).listarTodos();
            
            dispose();
        }
        
        private void carregarPessoas(){
        try{
            DaoPessoa daoPes = new DaoPessoa();

            ResultSet resultSet = daoPes.listarTodos();

            while(resultSet.next()){
                JcbNome.addItem(resultSet.getString("P.NOME"));
            }
        }catch(Exception e){
            
        }
    }
        
        private void recuperaIdPessoa(){
        try{
            DaoPessoa daoPes = new DaoPessoa();
            ResultSet resultSet = daoPes.listarPorNome(JcbNome.getSelectedItem().toString());
            resultSet.next();
            tfidnome.setText(resultSet.getString("P.ID"));
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
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbNome;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNome;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfidnome;
    // End of variables declaration//GEN-END:variables
}