package Vista.especialidades;

import Controlador.EspecialdadControlador;
import javax.swing.JOptionPane;

public class Ingresar extends javax.swing.JInternalFrame {
    EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    //
    public Ingresar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtespecialidad = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Escriba la especialidad: ");

        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(BtnGuardar)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        String especialidad = txtespecialidad.getText();

        if (especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "PORFAVOR LLENE LOS CAMPOS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!especialidad.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(null, "LA ESPECIALIDAD SOLO DEBE CONTENER LETRAS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ec.especialidadExiste(especialidad)) {
            JOptionPane.showMessageDialog(null, "LA ESPECIALIDAD YA EXISTE.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ec.GuardarEspecialidad(especialidad);
        JOptionPane.showMessageDialog(null, txtespecialidad.getText()+" Ingresado correctamente");
        txtespecialidad.setText("");
    }//GEN-LAST:event_BtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtespecialidad;
    // End of variables declaration//GEN-END:variables
}
