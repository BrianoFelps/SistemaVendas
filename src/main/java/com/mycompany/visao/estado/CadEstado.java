/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.estado;

import com.mycompany.dao.DaoEstado;
import com.mycompany.dao.DaoPais;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModEstado;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author brian.7908
 */
public class CadEstado extends javax.swing.JFrame {

    /**
     * Creates new form CadEstado
     */
    public CadEstado() {
        initComponents();
        
        carregarPaises();
        
         if (!existeDadosTemporarios()) {
            DaoEstado daoest = new DaoEstado();
            
            int id = daoest.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
         recuperaIdPais();
         
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfidpais.setVisible(true);
        
    }
    
      private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModEstado){
            int id = ((ModEstado) DadosTemporarios.tempObject).getId();
            int idpais = ((ModEstado) DadosTemporarios.tempObject).getIdpais();
            String nmest = ((ModEstado) DadosTemporarios.tempObject).getNome();

            tfId.setText(String.valueOf(id));
            tfidpais.setText(String.valueOf(idpais));
            tfEstado.setText(nmest);

            //
            try{
                DaoPais daoPais = new DaoPais();
                ResultSet resultSet = daoPais.listarPorId(idpais);
                resultSet.next();
                String pais = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < JcbPais.getItemCount(); i++){
                    if(JcbPais.getItemAt(i).equals(pais)){
                        index = i;
                        break;
                    }
                }
                JcbPais.setSelectedIndex(index);
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
        tfEstado = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        LId = new javax.swing.JLabel();
        LNome = new javax.swing.JLabel();
        LDesc = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfidpais = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        JcbPais = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tfEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEstadoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        LId.setText("ID");

        LNome.setText("País");

        LDesc.setText("Estado (UF)");

        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        JcbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcbPaisItemStateChanged(evt);
            }
        });
        JcbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbPaisActionPerformed(evt);
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
                            .addComponent(LDesc)
                            .addComponent(LNome)
                            .addComponent(LId)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir))
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JcbPais, 0, 275, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfidpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(JcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfidpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
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
                JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o estado " + tfEstado.getText() + "?");
        
        if (escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        // TODO add your handling code here:
         if (btnAcao.getText().equals(Constantes.BTN_SALVAR_TEXT))
            inserir();
        else if (btnAcao.getText().equals(Constantes.BTN_ALTERAR_TEXT))
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void JcbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcbPaisActionPerformed

    private void tfEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEstadoActionPerformed

    private void JcbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcbPaisItemStateChanged
        // TODO add your handling code here:
        recuperaIdPais();
    }//GEN-LAST:event_JcbPaisItemStateChanged

       private void inserir(){
            DaoEstado daoest = new DaoEstado();
            
            if (daoest.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidpais.getText()), tfEstado.getText())){
                JOptionPane.showMessageDialog(null, "Estado salvo com sucesso!");
            
                tfId.setText("" + daoest.buscarProximoId());
                tfEstado.setText(" ");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o estado!");
            }
        }
        
        private void alterar(){
            DaoEstado daoest = new DaoEstado();
            
            if (daoest.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidpais.getText()), tfEstado.getText())){
                JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!");
            
                tfId.setText (" ");
                tfidpais.setText(" ");
                tfEstado.setText(" ");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o estado!");
            }
            
            ((ListEstado) Formularios.ListEstado).listarTodos();
            
            dispose();
        }
        
        private void excluir(){
            DaoEstado daoest = new DaoEstado();
            
            if (daoest.excluir(Integer.parseInt(tfId.getText()))){
                JOptionPane.showMessageDialog(null, "Estado " + tfEstado.getText() + " excluído com sucesso!");
            
                tfId.setText ("");
                tfidpais.setText("");
                tfEstado.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o estado!");
            }
            
            ((ListEstado) Formularios.ListEstado).listarTodos();
            
            dispose();
        }
        
        private void carregarPaises(){
        try{
            DaoPais daopais = new DaoPais();

            ResultSet resultSet = daopais.listarTodos();

            while(resultSet.next()){
                JcbPais.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
            
        }
    }
        
        private void recuperaIdPais(){
        try{
            DaoPais daopais = new DaoPais();
            ResultSet resultSet = daopais.listarPorNome(JcbPais.getSelectedItem().toString());
            resultSet.next();
            tfidpais.setText(resultSet.getString("ID"));
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
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbPais;
    private javax.swing.JLabel LDesc;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNome;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfidpais;
    // End of variables declaration//GEN-END:variables
}
