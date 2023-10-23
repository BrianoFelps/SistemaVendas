/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.Pessoa;

import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.dao.DaoEstciv;
import com.mycompany.dao.DaoPessoa;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.modelo.ModPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author brian.7908
 */
public class CadPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadPessoa
     */
    public CadPessoa() {
        initComponents();
        
        carregarCidades();        
        carregarEC();
        
         if (!existeDadosTemporarios()) {
            DaoPessoa daopes = new DaoPessoa();
            DaoEndereco daoEnd = new DaoEndereco();
            DaoCliente daoCli = new DaoCliente();
            
            int id = daopes.buscarProximoId();
            int idEnd = daoEnd.buscarProximoId();
            int idCli = daoCli.buscarProximoId();
            
            if (id>0){
                tfId.setText(String.valueOf(id));
                tfIdEndereco.setText(String.valueOf(idEnd));
                tfIdCli.setText(String.valueOf(idCli));
            }
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
            }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
         recuperaIdEC();
         recuperaIdCid();
         
         setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
        tfIdEndereco.setVisible(true);
        tfidec.setVisible(true);
        
        setExtendedState(MAXIMIZED_BOTH);
        
       tfIdEndereco.setVisible(false);
        tfidcid.setVisible(false);
        tfIdCli.setVisible(true);
    }

     private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModPessoa){
            int id = ((ModPessoa) DadosTemporarios.tempObject).getId();
            int idend = ((ModPessoa) DadosTemporarios.tempObject).getIdend();
            int idec = ((ModPessoa) DadosTemporarios.tempObject).getIdestciv();
            String nome = ((ModPessoa) DadosTemporarios.tempObject).getNom();
            String sob = ((ModPessoa) DadosTemporarios.tempObject).getSob();
            String gen = ((ModPessoa) DadosTemporarios.tempObject).getGen();
            String tel = ((ModPessoa) DadosTemporarios.tempObject).getTel();
            String email = ((ModPessoa) DadosTemporarios.tempObject).getEma();

            tfId.setText(String.valueOf(id));
            tfIdEndereco.setText(String.valueOf(idend));
            tfidec.setText(String.valueOf(idec));
            tfNome.setText(nome);
            tfSob.setText(sob);
            tfTel.setText(tel);
            tfEmail.setText(email);
           

            //
            
            try{
                DaoEndereco daoEndereco = new DaoEndereco();
                ResultSet resultSet = daoEndereco.listarPorId(idend);
                resultSet.next();
                String cidade = resultSet.getString("C.NOME");
                int index = 0;
                for(int i = 0; i < JcbCid.getItemCount(); i++){
                    if(JcbCid.getItemAt(i).equals(cidade)){
                        index = i;
                        break;
                    }
                } 
                JcbCid.setSelectedIndex(index);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            try{
             DaoEstciv daoec = new DaoEstciv();
                ResultSet resultSet = daoec.listarPorId(idec);
                resultSet.next();
                String cid = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbec.getItemCount(); i++){
                    if(jcbec.getItemAt(i).equals(cid)){
                        index = i;
                        break;
                    }
            }jcbec.setSelectedIndex(index);
            }catch(Exception e){}
            //
            int index = 0;
            for(int i = 0; i < jcbGenero.getItemCount(); i++){
                if(jcbGenero.getItemAt(i).equals(gen)){
                    index = i;
                    break;
                }
            }
            jcbGenero.setSelectedIndex(index);
            //
            
            String rua = ((ModEndereco) DadosTemporarios.tempObject2).getRua();
            int cep = ((ModEndereco) DadosTemporarios.tempObject2).getCep();
            int numRes = ((ModEndereco) DadosTemporarios.tempObject2).getNum();
            
            tfRua.setText(rua);
            tfCEP.setText(String.valueOf(cep));
            tfNum.setText(String.valueOf(numRes));
            
            int idCliente = ((ModCliente) DadosTemporarios.tempObject3).getId();
            tfIdCli.setText(String.valueOf(idCliente));
            
            DadosTemporarios.tempObject = null;
            DadosTemporarios.tempObject2 = null;
            DadosTemporarios.tempObject3 = null;
            
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
        tfNome = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        LId = new javax.swing.JLabel();
        LDesc = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfSob = new javax.swing.JTextField();
        tfTel = new javax.swing.JTextField();
        jcbec = new javax.swing.JComboBox<>();
        tfidec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        tfIdCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        tfRua = new javax.swing.JTextField();
        LNome1 = new javax.swing.JLabel();
        LDesc2 = new javax.swing.JLabel();
        tfIdEndereco = new javax.swing.JTextField();
        tfidcid = new javax.swing.JTextField();
        JcbCid = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JTextField();
        tfNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de pessoa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        LId.setText("ID");

        LDesc.setText("Nome");

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Sobrenome");

        jLabel2.setText("Telefone");

        tfTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelActionPerformed(evt);
            }
        });

        jcbec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbecActionPerformed(evt);
            }
        });

        tfidec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidecActionPerformed(evt);
            }
        });

        jLabel3.setText("Estado Civil");

        jLabel4.setText("Gênero");

        jLabel5.setText("E-mail");

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masc", "Fem" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(LId)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(tfIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbec, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfidec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(tfSob, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir))
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LDesc)
                            .addComponent(jLabel5))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfidec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LDesc)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Pessoa");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Endereço");

        tfRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRuaActionPerformed(evt);
            }
        });

        LNome1.setText("Cidade");

        LDesc2.setText("Rua");

        tfidcid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidcidActionPerformed(evt);
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

        jLabel10.setText("CEP");

        jLabel11.setText("Núm");

        tfNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(LDesc2)
                    .addComponent(LNome1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel11))
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JcbCid, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfidcid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfidcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LDesc2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int escolha =
        JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a pessoa de nome " + tfNome.getText() + "?");

        if (escolha == JOptionPane.YES_OPTION)
            excluirCliente();
            excluir();
            excluirEndereco();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        // TODO add your handling code here:
        if(camposObrigatoriosPreenchidos(new JTextField[]{tfRua, tfCEP, tfNome, tfSob, tfTel, tfEmail})){
        if (btnAcao.getText().equals(Constantes.BTN_SALVAR_TEXT)){
        inserirEndereco();
        inserir();
        inserirCliente();
        
        }else if (btnAcao.getText().equals(Constantes.BTN_ALTERAR_TEXT)){
        alterarEndereco();
        alterar();
            
    }//GEN-LAST:event_btnAcaoActionPerformed
        }
    }
    
    private void tfTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelActionPerformed

    private void tfidecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidecActionPerformed

    private void jcbecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbecActionPerformed
        // TODO add your handling code here:
        recuperaIdEC();
    }//GEN-LAST:event_jcbecActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRuaActionPerformed

    private void tfidcidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidcidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidcidActionPerformed

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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Formularios.CadPessoa = null;
    }//GEN-LAST:event_formWindowClosed

     private void inserir(){
            DaoPessoa daopes = new DaoPessoa();
            DaoEndereco daoEnd = new DaoEndereco();
            
            if (daopes.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfidec.getText()), tfNome.getText(), tfSob.getText(), (String) jcbGenero.getSelectedItem(), tfTel.getText(), tfEmail.getText())){
                JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
            
                tfId.setText("" + daopes.buscarProximoId());
                tfIdEndereco.setText("" + daoEnd.buscarProximoId());
                tfNome.setText("");
                tfSob.setText("");
                tfTel.setText("");
                tfEmail.setText("");
                        
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a pessoa!");
            }
        }
     
     private void inserirEndereco(){
         DaoEndereco daoEnd = new DaoEndereco();
         
         if (daoEnd.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidcid.getText()), tfRua.getText(),  Integer.parseInt(tfCEP.getText()),  Integer.parseInt(tfNum.getText()))){{}
                JOptionPane.showMessageDialog(null, "Endereço salvo com sucesso!");
                tfRua.setText(" ");
                tfCEP.setText(" ");
                tfNum.setText(" ");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço!");
            }
            }
     
     private void inserirCliente(){
         DaoCliente daoCli = new DaoCliente();
         
         if (daoCli.inserir(Integer.parseInt(tfIdCli.getText()), Integer.parseInt(tfId.getText()))){
              JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
         }else{
         JOptionPane.showMessageDialog(null, "Não foi possível salvar o cliente!");
         }
     }
        
        private void alterar(){
            DaoPessoa daopes = new DaoPessoa();
            
            if (daopes.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdEndereco.getText()), Integer.parseInt(tfidec.getText()), tfNome.getText(), tfSob.getText(), (String) jcbGenero.getSelectedItem(), tfTel.getText(), tfEmail.getText())){
                JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
            
                tfId.setText ("" + daopes.buscarProximoId());
                tfNome.setText("");
                tfSob.setText("");
                tfTel.setText("");
                tfEmail.setText("");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
            }
            
            ((ListPessoa) Formularios.ListPessoa).listarTodos();
            
            dispose();
        }
        
        private void alterarEndereco(){
             DaoEndereco daoend = new DaoEndereco();
            
            if (daoend.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfidcid.getText()), tfRua.getText(),  Integer.parseInt(tfCEP.getText()),  Integer.parseInt(tfNum.getText()))){
//                JOptionPane.showMessageDialog(null, "Endereço alterado com sucesso!");
            
                tfRua.setText(" ");
                tfCEP.setText(" ");
                tfNum.setText(" ");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar a pessoa!");
            }
        }
        
        private void excluir(){
            DaoPessoa daopes = new DaoPessoa();
            
            if (daopes.excluir(Integer.parseInt(tfId.getText()))){
                
                JOptionPane.showMessageDialog(null, "Pessoa de nome " + tfNome.getText() + " excluída com sucesso!");
                
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a pessoa!");
            }
            
            ((ListPessoa) Formularios.ListPessoa).listarTodos();
            
            dispose();
        }
        
        private void excluirEndereco(){
         
            DaoEndereco daoEnd = new DaoEndereco();
            
            if (daoEnd.excluir(Integer.parseInt(tfIdEndereco.getText()))){
            
            }else {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o endereço!");
            }
        }
        
        private void excluirCliente(){
            
            DaoCliente daoCli = new DaoCliente();
            
            if(daoCli.excluir(Integer.parseInt(tfIdCli.getText()))){
            
            }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente!");
            }
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
        
        private void carregarEC(){
        try{
            DaoEstciv daoec = new DaoEstciv();

            ResultSet resultSet = daoec.listarTodos();

            while(resultSet.next()){
                jcbec.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
            
        }
    }
        
        private void recuperaIdEC(){
        try{
            DaoEstciv daoEC = new DaoEstciv();
            ResultSet resultSet = daoEC.listarPorNome(jcbec.getSelectedItem().toString());
            resultSet.next();
            tfidec.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
        private boolean camposObrigatoriosPreenchidos(JTextField campos[]){
            boolean b = true;
            
            for (int i = 0; i < campos.length; i++) {
                if(campos[i].getText().equals("")){
                JOptionPane.showMessageDialog(null, "O campo " + campos[i].getToolTipText() + " é obrigatório!");
                campos[i].requestFocus();
                b = false;
                break;
                }
            }
            return b;
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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbCid;
    private javax.swing.JLabel LDesc;
    private javax.swing.JLabel LDesc2;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNome1;
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<String> jcbec;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCli;
    private javax.swing.JTextField tfIdEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSob;
    private javax.swing.JTextField tfTel;
    private javax.swing.JTextField tfidcid;
    private javax.swing.JTextField tfidec;
    // End of variables declaration//GEN-END:variables
}
