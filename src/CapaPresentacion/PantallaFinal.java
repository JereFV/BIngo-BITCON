/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion;

import CapaLógica.Bingo;
import javax.swing.JOptionPane;

/**
 *
 * @author jerem
 */
public class PantallaFinal extends javax.swing.JFrame {

    private Bingo datos;
    private PantallaJuego pantallaJuego;
    
    public PantallaFinal(String ganadores, Bingo data, PantallaJuego pantalla) {
        initComponents();
        jTxaGanadores.setText(ganadores);
        datos = data;
        //Se envía el form de la pantalla del juego para poder destruirlo desde acá.
        pantallaJuego = pantalla;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTxaGanadores = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jBtnReiniciarJuego = new javax.swing.JButton();
        jBtnMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTxaGanadores.setEditable(false);
        jTxaGanadores.setColumns(20);
        jTxaGanadores.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jTxaGanadores.setRows(5);
        jScrollPane1.setViewportView(jTxaGanadores);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("¿Que desea hacer a continuación?");

        jBtnReiniciarJuego.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jBtnReiniciarJuego.setText("Reiniciar juego");
        jBtnReiniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReiniciarJuegoActionPerformed(evt);
            }
        });

        jBtnMenuPrincipal.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jBtnMenuPrincipal.setText("Ir al Menú Principal");
        jBtnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jBtnReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnReiniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReiniciarJuegoActionPerformed
       int opcion = JOptionPane.showConfirmDialog(null, "¿Desea reiniciar la partida?", "Seleccione una opción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);        
        if (opcion == 0){
            datos.limpiarNumerosGanadores();
            datos.limpiarCartonesGanadores();
            datos.limpiarCantidadElementosPatron();
            
            pantallaJuego.dispose();
            dispose();            
            EleccionPatron eleccionPatron = new EleccionPatron(datos);
            eleccionPatron.setVisible(true);           
        }
    }//GEN-LAST:event_jBtnReiniciarJuegoActionPerformed

    private void jBtnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMenuPrincipalActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea volver al menú principal? Perderá toda la configuración del juego.", "Seleccione una opción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);        
        if (opcion == 0){
            pantallaJuego.dispose();
            dispose();           
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
        }  
    }//GEN-LAST:event_jBtnMenuPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new PantallaFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnMenuPrincipal;
    private javax.swing.JButton jBtnReiniciarJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxaGanadores;
    // End of variables declaration//GEN-END:variables
}