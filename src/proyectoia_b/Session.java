/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Session extends javax.swing.JFrame {

    /**
     * Creates new form Session
     */
    
    boolean ingresando;
    cUsuario uActual;
    
    public Session(cUsuario user) {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        ingresando = true;
        uActual = user;
        lUser.setText(user.id_usuario);
    }
    
    public Session() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGrupoCalificacion = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbView = new javax.swing.JComboBox<>();
        cbSimilares = new javax.swing.JComboBox<>();
        cbInteres = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResumen = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();
        cb1 = new javax.swing.JRadioButton();
        cb2 = new javax.swing.JRadioButton();
        cb3 = new javax.swing.JRadioButton();
        cb4 = new javax.swing.JRadioButton();
        cb5 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbRating = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbDescubre = new javax.swing.JComboBox<>();
        bRecomendar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lTitulo = new javax.swing.JLabel();
        lAutor = new javax.swing.JLabel();
        lEdicion = new javax.swing.JLabel();
        lYear = new javax.swing.JLabel();
        lId = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Basadas en tu interés:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 444, -1, -1));
        getContentPane().add(tBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 64, 411, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Buscar libro:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 68, -1, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel3.setText("Basadas en artículos similares:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 510, -1, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Más vistos:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 444, -1, -1));

        cbView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbViewActionPerformed(evt);
            }
        });
        getContentPane().add(cbView, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 469, 204, -1));

        cbSimilares.setBorder(null);
        cbSimilares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSimilaresActionPerformed(evt);
            }
        });
        getContentPane().add(cbSimilares, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 535, 235, -1));

        cbInteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInteresActionPerformed(evt);
            }
        });
        getContentPane().add(cbInteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 469, 235, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel5.setText("Usuario actual");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("Estás viendo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, -1, -1));
        jLabel6.getAccessibleContext().setAccessibleName("Estás viendo");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel7.setText("Libro:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 173, -1, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel8.setText("Autor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 199, -1, -1));

        taResumen.setColumns(20);
        taResumen.setRows(5);
        jScrollPane1.setViewportView(taResumen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 295, 506, 131));

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel9.setText("Año de publicación:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 243, -1, -1));

        jLabel10.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel10.setText("Resumen:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 263, -1, -1));

        bBuscar.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.setName("bBuscar"); // NOI18N
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(bBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 62, 169, 27));

        bgGrupoCalificacion.add(cb1);
        cb1.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        cb1.setText("1");
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 327, -1, -1));

        bgGrupoCalificacion.add(cb2);
        cb2.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        cb2.setText("2");
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 327, -1, -1));

        bgGrupoCalificacion.add(cb3);
        cb3.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        cb3.setText("3");
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });
        getContentPane().add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 327, -1, -1));

        bgGrupoCalificacion.add(cb4);
        cb4.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        cb4.setText("4");
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb4ActionPerformed(evt);
            }
        });
        getContentPane().add(cb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 327, -1, -1));

        bgGrupoCalificacion.add(cb5);
        cb5.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        cb5.setText("5");
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ActionPerformed(evt);
            }
        });
        getContentPane().add(cb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 327, -1, -1));

        jLabel11.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jLabel11.setText("Califica este libro:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 295, -1, -1));

        jLabel12.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel12.setText("Mejores calificados:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 510, 204, -1));

        cbRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRatingActionPerformed(evt);
            }
        });
        getContentPane().add(cbRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 530, 204, -1));

        jLabel14.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel14.setText("Descubre:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 444, -1, -1));

        cbDescubre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDescubreActionPerformed(evt);
            }
        });
        getContentPane().add(cbDescubre, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 469, 248, -1));

        bRecomendar.setText("Recomendar");
        bRecomendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRecomendarActionPerformed(evt);
            }
        });
        getContentPane().add(bRecomendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, 30));

        jLabel13.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel13.setText("Edición:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 219, -1, -1));

        lTitulo.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lTitulo.setText("--");
        getContentPane().add(lTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 173, -1, -1));

        lAutor.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lAutor.setText("--");
        getContentPane().add(lAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 199, -1, -1));

        lEdicion.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lEdicion.setText("--");
        getContentPane().add(lEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 219, -1, -1));

        lYear.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lYear.setText("--");
        getContentPane().add(lYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 243, -1, -1));

        lId.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        lId.setText("--");
        getContentPane().add(lId, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 153, -1, -1));

        jLabel16.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel16.setText("ISBN:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 153, -1, -1));

        lUser.setText("--");
        getContentPane().add(lUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
      cAdminBDD BDD = new cAdminBDD(ingresando);
      cSistemaDeRecomendacion sistema = new cSistemaDeRecomendacion();
    
    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        if(!tBuscar.getText().isEmpty()){
            sistema.busqueda(tBuscar.getText(), lId, lTitulo, lAutor, lEdicion, lYear, taResumen);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bRecomendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRecomendarActionPerformed
        try {
            sistema.cold_start(lUser.getText(), cbRating, cbView, cbInteres, cbDescubre);
            if(!lId.equals("--"))
                sistema.recomendacion_similitud(cbSimilares, lId.getText());
            if(!lUser.equals("--"))
                sistema.recomendacion_aprendizaje(cbInteres, lUser.getText());
            JOptionPane.showMessageDialog(null, "Se encontraron nuevas recomendaciones");
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bRecomendarActionPerformed

    private void cb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ActionPerformed
        BDD.ingresar_rating(lUser.getText(), lId.getText(), 5);
    }//GEN-LAST:event_cb5ActionPerformed

    private void cb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb4ActionPerformed
        BDD.ingresar_rating(lUser.getText(), lId.getText(), 4);
    }//GEN-LAST:event_cb4ActionPerformed

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        BDD.ingresar_rating(lUser.getText(), lId.getText(), 3);
    }//GEN-LAST:event_cb3ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        BDD.ingresar_rating(lUser.getText(), lId.getText(), 2);
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        BDD.ingresar_rating(lUser.getText(), lId.getText(), 1);
        
    }//GEN-LAST:event_cb1ActionPerformed

    private void cbDescubreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDescubreActionPerformed
        if(cbDescubre.isEnabled() && cbDescubre.getSelectedIndex() != -1){
            String a = lId.getText();
            String b = cbDescubre.getSelectedItem().toString().split(";")[1];
            sistema.show_book((String) cbDescubre.getSelectedItem(), lId, lTitulo, lAutor, lEdicion, lYear, taResumen);
            sistema.insertar_transaction(a, b);
            sistema.aumentar_vista(lId.getText());
        }
    }//GEN-LAST:event_cbDescubreActionPerformed

    private void cbRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRatingActionPerformed
        if(cbRating.isEnabled() && cbRating.getSelectedIndex() != -1){
            String a = lId.getText();
            String b = cbRating.getSelectedItem().toString().split(";")[1];
            sistema.show_book((String) cbRating.getSelectedItem(), lId, lTitulo, lAutor, lEdicion, lYear, taResumen);
            sistema.insertar_transaction(a, b);
            sistema.aumentar_vista(lId.getText());
        }
    }//GEN-LAST:event_cbRatingActionPerformed

    private void cbSimilaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSimilaresActionPerformed
        if(cbSimilares.isEnabled() && cbDescubre.getSelectedIndex() != -1){
            String a = lId.getText();
            String b = cbSimilares.getSelectedItem().toString().split(";")[1];
            sistema.show_book((String) cbSimilares.getSelectedItem(), lId, lTitulo, lAutor, lEdicion, lYear, taResumen);
            sistema.insertar_transaction(a, b);
            sistema.aumentar_vista(lId.getText());
        }
    }//GEN-LAST:event_cbSimilaresActionPerformed

    private void cbInteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInteresActionPerformed
        if(cbInteres.isEnabled() && cbInteres.getSelectedIndex() != -1){
            String a = lId.getText();
            String b = cbInteres.getSelectedItem().toString().split(";")[1];
            sistema.show_book((String) cbInteres.getSelectedItem(), lId, lTitulo, lAutor, lEdicion, lYear, taResumen);
            sistema.insertar_transaction(a, b);
            sistema.aumentar_vista(lId.getText());
        }
    }//GEN-LAST:event_cbInteresActionPerformed

    private void cbViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbViewActionPerformed
        if(cbView.isEnabled() && cbView.getSelectedIndex() != -1){
            String a = lId.getText();
            String b = cbView.getSelectedItem().toString().split(";")[1];
            sistema.show_book((String) cbView.getSelectedItem(), lId, lTitulo, lAutor, lEdicion, lYear, taResumen);
            sistema.insertar_transaction(a, b);
            sistema.aumentar_vista(lId.getText());
        }
    }//GEN-LAST:event_cbViewActionPerformed

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
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Session().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bRecomendar;
    private javax.swing.ButtonGroup bgGrupoCalificacion;
    private javax.swing.JRadioButton cb1;
    private javax.swing.JRadioButton cb2;
    private javax.swing.JRadioButton cb3;
    private javax.swing.JRadioButton cb4;
    private javax.swing.JRadioButton cb5;
    private javax.swing.JComboBox<String> cbDescubre;
    private javax.swing.JComboBox<String> cbInteres;
    private javax.swing.JComboBox<String> cbRating;
    private javax.swing.JComboBox<String> cbSimilares;
    private javax.swing.JComboBox<String> cbView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lAutor;
    private javax.swing.JLabel lEdicion;
    private javax.swing.JLabel lId;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lUser;
    private javax.swing.JLabel lYear;
    private javax.swing.JTextField tBuscar;
    private javax.swing.JTextArea taResumen;
    // End of variables declaration//GEN-END:variables
}
