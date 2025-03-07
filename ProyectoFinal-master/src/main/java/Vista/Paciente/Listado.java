package Vista.Paciente;

import Controlador.PacienteControlador;
import Modelo.PacienteModelo;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Listado extends javax.swing.JInternalFrame {
    private JDesktopPane desktopPane;
    DefaultTableModel tm = new DefaultTableModel();
    PacienteControlador PC = PacienteControlador.getInstancia();
    //
    public Listado(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        initComponents();
        tablalist.setModel(tm);
        String columnas[] = {"Cedula", "Nombres", "Edad", "Sexo"};
        tm.addColumn(columnas[0]);
        tm.addColumn(columnas[1]);
        tm.addColumn(columnas[2]);
        tm.addColumn(columnas[3]);
        
        listartodo();
    }
    public void listartodo (){
        for (PacienteModelo PM : PC.listadoCompleto()) {
            Object[] fila ={PM.getCedula(), PM.getNombre(), PM.getEdad(), PM.getSexo()};
            tm.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalist = new javax.swing.JTable();
        txtcedulab = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cedula a buscar: ");

        tablalist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablalist);

        txtcedulab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
        });

        jButton1.setText("ELIMINAR.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDatos(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarDatos(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcedulab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcedulab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
        tm.setRowCount(0);
        String cedula = txtcedulab.getText();
        for (PacienteModelo PM : PC.BuscarPaciente(cedula)) {
            Object[] fila = {PM.getCedula(), PM.getNombre(), PM.getEdad(), PM.getSexo()};
            tm.addRow(fila);
        }
    }//GEN-LAST:event_txtcedulaKeyReleased

    private void eliminarDatos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDatos
        int filaSeleccionada = tablalist.getSelectedRow();
    
    if (filaSeleccionada != -1) { 
        String cedulaSeleccionada = tablalist.getValueAt(filaSeleccionada, 0).toString();

        boolean eliminado = PC.eliminarPaciente(cedulaSeleccionada);

        if (eliminado) {
            javax.swing.JOptionPane.showMessageDialog(this, "PACIENTE ELIMINADO.");
        }

        tm.setRowCount(0);
        listartodo(); 
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "SELECCIONE UN PACIENTE.");
    }
    }//GEN-LAST:event_eliminarDatos

    private void actualizarDatos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarDatos
        
        int filaSeleccionada = tablalist.getSelectedRow();
    
    if (filaSeleccionada != -1) { 
        String cedula = tablalist.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tablalist.getValueAt(filaSeleccionada, 1).toString();
        int edad = Integer.parseInt(tablalist.getValueAt(filaSeleccionada, 2).toString());
        String sexo = tablalist.getValueAt(filaSeleccionada, 3).toString();

        // Abrir la pantalla de edición
        EditarPaciente editarPaciente = new EditarPaciente(desktopPane, cedula, nombre, edad, sexo); // Pasar desktopPane
        desktopPane.add(editarPaciente);
        editarPaciente.setVisible(true);
        editarPaciente.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                listartodo(); // Refrescar la tabla
            }
        });
        tm.setRowCount(0);
    } else {
        JOptionPane.showMessageDialog(this, "SELECCIONE UN PACIENTE.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_actualizarDatos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablalist;
    private javax.swing.JTextField txtcedulab;
    // End of variables declaration//GEN-END:variables
}
