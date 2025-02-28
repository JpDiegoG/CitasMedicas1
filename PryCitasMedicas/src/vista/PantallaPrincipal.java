
package vista;

import vista.pacientes.Ingresar;
import vista.pacientes.Listado;


public class PantallaPrincipal extends javax.swing.JFrame {

    public PantallaPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor_principal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menu_ingresar_paciente = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menu_ingresar_especialidades = new javax.swing.JMenuItem();
        menu_listado_especialidades = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menu_ingresar_medico = new javax.swing.JMenuItem();
        menu_listado_medicos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menu_ingresar_citas = new javax.swing.JMenuItem();
        menu_listado_citas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contenedor_principalLayout = new javax.swing.GroupLayout(contenedor_principal);
        contenedor_principal.setLayout(contenedor_principalLayout);
        contenedor_principalLayout.setHorizontalGroup(
            contenedor_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        contenedor_principalLayout.setVerticalGroup(
            contenedor_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        jMenu1.setText("INICIO");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("PACIENTES");

        menu_ingresar_paciente.setText("INGRESAR ");
        menu_ingresar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ingresar_pacienteActionPerformed(evt);
            }
        });
        jMenu2.add(menu_ingresar_paciente);

        jMenuItem2.setText("LISTADO");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("ESPECIALIDADES");

        menu_ingresar_especialidades.setText("INGRESAR");
        menu_ingresar_especialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ingresar_especialidadesActionPerformed(evt);
            }
        });
        jMenu3.add(menu_ingresar_especialidades);

        menu_listado_especialidades.setText("LISTADO");
        menu_listado_especialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listado_especialidadesActionPerformed(evt);
            }
        });
        jMenu3.add(menu_listado_especialidades);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("MEDICOS");

        menu_ingresar_medico.setText("INGRESAR");
        menu_ingresar_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ingresar_medicoActionPerformed(evt);
            }
        });
        jMenu4.add(menu_ingresar_medico);

        menu_listado_medicos.setText("LISTADO");
        menu_listado_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listado_medicosActionPerformed(evt);
            }
        });
        jMenu4.add(menu_listado_medicos);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("CITAS");

        menu_ingresar_citas.setText("INGRESAR");
        menu_ingresar_citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ingresar_citasActionPerformed(evt);
            }
        });
        jMenu5.add(menu_ingresar_citas);

        menu_listado_citas.setText("LISTADO");
        menu_listado_citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listado_citasActionPerformed(evt);
            }
        });
        jMenu5.add(menu_listado_citas);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor_principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor_principal))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_ingresar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ingresar_pacienteActionPerformed
        //cargue la pantalla de ingresar se encuentra en view.paciente4
        contenedor_principal.removeAll();
        Ingresar i = new Ingresar();
        contenedor_principal.add(i).setVisible(true);
        
    }//GEN-LAST:event_menu_ingresar_pacienteActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        contenedor_principal.removeAll();
        contenedor_principal.add(new Listado()).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menu_ingresar_especialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ingresar_especialidadesActionPerformed
      contenedor_principal.removeAll();
      contenedor_principal.add(new vista.especialidades.Ingresar()).setVisible(true);
    }//GEN-LAST:event_menu_ingresar_especialidadesActionPerformed

    private void menu_listado_especialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listado_especialidadesActionPerformed
      contenedor_principal.removeAll();
      contenedor_principal.add(new vista.especialidades.Lista()).setVisible(true);
    }//GEN-LAST:event_menu_listado_especialidadesActionPerformed

    private void menu_ingresar_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ingresar_medicoActionPerformed
       contenedor_principal.removeAll();
      contenedor_principal.add(new vista.medicos.Ingresar()).setVisible(true);
    }//GEN-LAST:event_menu_ingresar_medicoActionPerformed

    private void menu_listado_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listado_medicosActionPerformed
       contenedor_principal.removeAll();
      contenedor_principal.add(new vista.medicos.Listado()).setVisible(true);
    }//GEN-LAST:event_menu_listado_medicosActionPerformed

    private void menu_ingresar_citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ingresar_citasActionPerformed
        // TODO add your handling code here:
      contenedor_principal.removeAll();
      contenedor_principal.add(new vista.citas.Ingresar()).setVisible(true);
    }//GEN-LAST:event_menu_ingresar_citasActionPerformed

    private void menu_listado_citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listado_citasActionPerformed
        // TODO add your handling code here:
      contenedor_principal.removeAll();
      contenedor_principal.add(new vista.citas.Listado()).setVisible(true);
    }//GEN-LAST:event_menu_listado_citasActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedor_principal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menu_ingresar_citas;
    private javax.swing.JMenuItem menu_ingresar_especialidades;
    private javax.swing.JMenuItem menu_ingresar_medico;
    private javax.swing.JMenuItem menu_ingresar_paciente;
    private javax.swing.JMenuItem menu_listado_citas;
    private javax.swing.JMenuItem menu_listado_especialidades;
    private javax.swing.JMenuItem menu_listado_medicos;
    // End of variables declaration//GEN-END:variables
}
