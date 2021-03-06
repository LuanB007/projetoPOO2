/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.view;

import br.edu.ifpb.control.ComandaDao;
import br.edu.ifpb.control.ComandaDaoImpl;
import br.edu.ifpb.control.PedidoDao;
import br.edu.ifpb.control.PedidoDaoImpl;
import br.edu.ifpb.model.Comanda;
import br.edu.ifpb.model.Pedido;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class GerenciarMesa extends javax.swing.JFrame {

    /**
     * Creates new form GerenciarMesa
     */
    ComandaDao daoComanda;
    PedidoDao daoPedido;
    
    public GerenciarMesa() {
        daoComanda = new ComandaDaoImpl();
        daoPedido = new PedidoDaoImpl();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rotMesas = new javax.swing.JSpinner();
        botaoNovaComanda = new javax.swing.JButton();
        botaoVerPedidos = new javax.swing.JButton();
        botaoFazerPedido = new javax.swing.JButton();
        botaoEncerrarComanda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Gerenciar Mesa");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Mesa:");

        rotMesas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rotMesas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        botaoNovaComanda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoNovaComanda.setText("Nova Comanda");
        botaoNovaComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaComandaActionPerformed(evt);
            }
        });

        botaoVerPedidos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoVerPedidos.setText("Ver Pedidos");
        botaoVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerPedidosActionPerformed(evt);
            }
        });

        botaoFazerPedido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoFazerPedido.setText("Fazer Pedido");
        botaoFazerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFazerPedidoActionPerformed(evt);
            }
        });

        botaoEncerrarComanda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoEncerrarComanda.setText("Encerrar Comanda");
        botaoEncerrarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEncerrarComandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoEncerrarComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoNovaComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoVerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoFazerPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rotMesas)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovaComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVerPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFazerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botaoEncerrarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovaComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaComandaActionPerformed
        // TODO add your handling code here:
        int mesa = (int) rotMesas.getValue(); //Pega o valor do root e atribui
        Comanda comanda = new Comanda();
        comanda.setNumMesa(mesa); //Definindo a mesa que abriu a comanda
        try {
            if(daoComanda.salvarComanda(comanda)){ // Salvando
                System.out.println(daoComanda.getComandas());
                JOptionPane.showMessageDialog(rootPane, "Nova comanda para a mesa " + mesa);
                this.dispose();
                new TelaPrincipal().setVisible(true);
            } else JOptionPane.showMessageDialog(rootPane, "Já existe uma comanda aberta para essa mesa!", null, JOptionPane.WARNING_MESSAGE, null);
        } catch (IOException ex) {
            Logger.getLogger(GerenciarMesa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerenciarMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoNovaComandaActionPerformed

    private void botaoVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerPedidosActionPerformed
        // TODO add your handling code here:
        int mesa = (int) rotMesas.getValue();
        try {
            if(daoComanda.existeComanda(mesa)){
                this.dispose();
                new VerPedidos(mesa).setVisible(true);
            } else JOptionPane.showMessageDialog(rootPane, "Não existe uma comanda aberta para essa mesa!", null, JOptionPane.WARNING_MESSAGE, null);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciarMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoVerPedidosActionPerformed

    private void botaoFazerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFazerPedidoActionPerformed
        // TODO add your handling code here:
        int mesa = (int) rotMesas.getValue(); //Pega o valor do root e atribui
        try {
            if(daoComanda.existeComanda(mesa)){
                this.dispose();
                new FazerPedido(mesa).setVisible(true); 
            } else JOptionPane.showMessageDialog(rootPane, "Não existe uma comanda aberta para essa mesa!", null, JOptionPane.WARNING_MESSAGE, null);
                } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciarMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoFazerPedidoActionPerformed

    private void botaoEncerrarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEncerrarComandaActionPerformed
        // TODO add your handling code here:
        int mesa = (int) rotMesas.getValue();
        double total = 0;
        try {
            Set<Pedido> pedidos = daoPedido.getPedidoMesa(mesa);
            
            if(daoComanda.removerComanda(mesa)){
                total = daoPedido.valorTotal(mesa);
                JOptionPane.showMessageDialog(rootPane, "Comanda encerrada. Total R$"+total, null, JOptionPane.PLAIN_MESSAGE, null);
            }else JOptionPane.showMessageDialog(rootPane, "Nenhuma comanda aberta para essa mesa", null, JOptionPane.WARNING_MESSAGE, null);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciarMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoEncerrarComandaActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarMesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEncerrarComanda;
    private javax.swing.JButton botaoFazerPedido;
    private javax.swing.JButton botaoNovaComanda;
    private javax.swing.JButton botaoVerPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner rotMesas;
    // End of variables declaration//GEN-END:variables
}
