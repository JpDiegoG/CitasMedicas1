package Vista.especialidades;

import Controlador.EspecialdadControlador;
import Modelo.Especialidad;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Listado extends javax.swing.JInternalFrame {
    EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    DefaultTableModel tm = new DefaultTableModel();
//
    public Listado() {
        initComponents();
        tblListado.setModel(tm);
        String columnas[]={"ESPECIALIDADES"};
        tm.setColumnIdentifiers(columnas);
        CargarListado();
    }

    private void CargarListado(){
        for (Especialidad em : ec.Listado()) {
            Object[] fila ={em.getNombre()};
            tm.addRow(fila);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Buscar por nombre: ");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListado);

        jButton1.setText("ELIMINAR.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEspecialidad(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        tm.setRowCount(0);
        String cedula = txtbuscar.getText();
        for (Especialidad e : ec.BuscarEspecialidad(cedula)) {
            Object[] fila = {e.getNombre()};
            tm.addRow(fila);
        }
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filaSeleccionada = tblListado.getSelectedRow();
    
    if (filaSeleccionada != -1) { 
        String cedulaSeleccionada = tblListado.getValueAt(filaSeleccionada, 0).toString();

        boolean eliminado = ec.eliminarEspecialidad(cedulaSeleccionada);

        if (eliminado) {
            javax.swing.JOptionPane.showMessageDialog(this, "ESPECIALIDAD ELIMINADA.");
        }
        tm.setRowCount(0);
        CargarListado(); 
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "SELECCIONE UNA ESPECIALIDAD.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void actualizarEspecialidad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEspecialidad
        // TODO add your handling code here:
     int filaSeleccionada = tblListado.getSelectedRow();
        
        if (filaSeleccionada != -1) { 
            String nombre = tblListado.getValueAt(filaSeleccionada, 0).toString();

            // Abrir la pantalla de edición
            EditarEspecialidades editarEspecialidad = new EditarEspecialidades(nombre);
            this.getDesktopPane().add(editarEspecialidad); // Agregar la ventana de edición al JDesktopPane
            editarEspecialidad.setVisible(true);

            // Refrescar la tabla después de cerrar la ventana de edición
            editarEspecialidad.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                    CargarListado(); // Refrescar la tabla
                }
            });
            tm.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA ESPECIALIDAD.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarEspecialidad


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
