package Vista.especialidades;

import Controlador.EspecialdadControlador;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class EditarEspecialidades extends javax.swing.JInternalFrame {
    private String nombreAnterior; // Almacena el nombre de la especialidad que se está editando
    private EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    public EditarEspecialidades(String nombreAnterior) {
        
        this.nombreAnterior = nombreAnterior;
        initComponents();
        txtnombre.setText(nombreAnterior);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("NOMBRE:");

        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_guardar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
    String nombre = txtnombre.getText().trim();

        // Validaciones
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "EL NOMBRE NO PUEDE ESTAR VACÍO", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar la especialidad
        boolean actualizado = ec.actualizarEspecialidad(nombreAnterior, nombre);

        if (actualizado) {
            JOptionPane.showMessageDialog(this, "ESPECIALIDAD ACTUALIZADA EXITOSAMENTE!");
            this.dispose(); // Cerrar la ventana de edición después de guardar
        } else {
            JOptionPane.showMessageDialog(this, "ERROR AL ACTUALIZAR LA ESPECIALIDAD", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
