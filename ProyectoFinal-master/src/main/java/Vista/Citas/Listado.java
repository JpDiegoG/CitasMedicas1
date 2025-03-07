package Vista.Citas;

import Controlador.CitaControlador;
import Controlador.PacienteControlador;
import Controlador.EspecialdadControlador;
import Controlador.MedicoControlador;
import Modelo.CitaM;
import Modelo.Especialidad;
import Modelo.MedicoM;
import Modelo.PacienteModelo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Listado extends javax.swing.JInternalFrame {
    DefaultTableModel tm = new DefaultTableModel();
    CitaControlador cic = CitaControlador.getInstancia();
    PacienteControlador cp = PacienteControlador.getInstancia();
    EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    MedicoControlador mc = MedicoControlador.getInstancia();
    
    public Listado() {
        initComponents();
        txttable.setModel(tm);
        String columnas[] = {"Paciente", "Especialidad", "Medico", "Descripcion", "Fecha","Hora","Estado"};
        for (String col : columnas) {
            tm.addColumn(col);
        }
        listartodo();
        CargarPaciente();
        CargarEspecialidad();
        CargarMedicos();
        CargarFecha();
        CargarEstado();
        
        cbxpacientes.addActionListener(e -> filtrarCitas());
        cbxespecialidad.addActionListener(e -> filtrarCitas());
        cbxmedicos.addActionListener(e -> filtrarCitas());
        cbxfecha.addActionListener(e -> filtrarCitas());
        cbxestado.addActionListener(e -> filtrarCitas());        
    }

    public void listartodo (){
        tm.setRowCount(0); // Limpiar la tabla antes de cargar los datos
    for (CitaM cim : cic.ListarCitas()) {
        Object[] fila = {
            cim.getPaciente().getNombre(),
            cim.getEspecialidad().getNombre(),
            cim.getMedico().getNombre(),
            cim.getDescripcion(),
            cim.getFecha(),
            cim.getHora(),
            cim.getEstado() // Mostrar el estado como String
        };
        tm.addRow(fila);
    }
    }
    private void CargarPaciente(){
        cbxpacientes.addItem("SELECCIONE.");
        for (PacienteModelo pa : cp.listadoCompleto()) {
            cbxpacientes.addItem(pa.getNombre());
        }
    }
    private void CargarEspecialidad(){
        cbxespecialidad.addItem("SELECCIONE.");
        for (Especialidad es : ec.Listado()) {
            cbxespecialidad.addItem(es.getNombre());
        }
    }
    private void CargarMedicos(){
        cbxmedicos.addItem("SELECCIONE.");    
        for (MedicoM medicoModelo : mc.ListarMedicos()) {
            cbxmedicos.addItem(medicoModelo.getNombre());
        }
    }
    private void CargarFecha(){
        cbxfecha.addItem("SELECCIONE.");    
        for (CitaM cf : cic.ListarCitas()) {
            cbxfecha.addItem(cf.getFecha());
        }
    }
    private void CargarEstado(){
        cbxestado.addItem("SELECCIONE.");    
        cbxestado.addItem("NO ATENDIDO");
        cbxestado.addItem("ATENDIDO");
    }
    
    private void filtrarCitas() {
        String pacientese = cbxpacientes.getSelectedItem().toString();
        String especialidadse = cbxespecialidad.getSelectedItem().toString();
        String medicose = cbxmedicos.getSelectedItem().toString();
        String fechase = cbxfecha.getSelectedItem().toString();
        String estadose = cbxestado.getSelectedItem().toString();
     // Limpiar la tabla antes de agregar nuevas filas
        tm.setRowCount(0);
        boolean existecitas = true;
        for (CitaM cim : cic.ListarCitas()) {
            boolean Paciente = pacientese.equals("SELECCIONE.") || cim.getPaciente().getNombre().equals(pacientese);
            boolean Especialidad = especialidadse.equals("SELECCIONE.") || cim.getEspecialidad().getNombre().equals(especialidadse);
            boolean Medico = medicose.equals("SELECCIONE.") || cim.getMedico().getNombre().equals(medicose);
            boolean Fecha = fechase.equals("SELECCIONE.") || cim.getFecha().equals(fechase);
            boolean Estado = estadose.equals("SELECCIONE.") || cim.getEstado().equals(estadose);

        // Solo agregar la cita si cumple con todos los filtros seleccionados
            if (Paciente && Especialidad && Medico && Fecha && Estado) {
                Object[] fila = {
                    cim.getPaciente().getNombre(),
                    cim.getEspecialidad().getNombre(),
                    cim.getMedico().getNombre(),
                    cim.getDescripcion(),
                    cim.getFecha(),
                    cim.getHora(),
                    cim.getEstado()
                };
                tm.addRow(fila);
                existecitas = false;
            }
        }
        if (existecitas) {
            JOptionPane.showMessageDialog(this, "NO EXISTEN CITAS.", "No hay citas", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txttable = new javax.swing.JTable();
        cbxpacientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxespecialidad = new javax.swing.JComboBox<>();
        cbxmedicos = new javax.swing.JComboBox<>();
        cbxfecha = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbxestado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Buscar por paciente:");

        txttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(txttable);

        jLabel2.setText("Buscar por especialidad:");

        jLabel3.setText("Buscar por medico:");

        jLabel4.setText("Buscar por fecha:");

        jButton1.setText("REFRESCAR CRITERIOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarEstado(evt);
            }
        });

        jLabel5.setText("Buscar por estado:");

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxpacientes, 0, 200, Short.MAX_VALUE)
                            .addComponent(cbxespecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxmedicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxfecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxmedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //reiniciar la posicion de los combobox
        cbxpacientes.setSelectedIndex(0);
        cbxmedicos.setSelectedIndex(0);
        cbxespecialidad.setSelectedIndex(0);
        cbxfecha.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ActualizarEstado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarEstado
        int filaSeleccionada = txttable.getSelectedRow();
    
        if (filaSeleccionada == -1) { 
            JOptionPane.showMessageDialog(this, "NINGUNA CITA SELECCIONADA.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String nombrePaciente = tm.getValueAt(filaSeleccionada, 0).toString();
        String fechaCita = tm.getValueAt(filaSeleccionada, 4).toString();
        String horaCita = tm.getValueAt(filaSeleccionada, 5).toString();
    
    // Buscar la cita
        for (CitaM cita : cic.ListarCitas()) {
            if (cita.getPaciente().getNombre().equals(nombrePaciente) &&
                cita.getFecha().equals(fechaCita) &&
                cita.getHora().equals(horaCita)) {
            
            // Cambiar estado
                cita.estado = !cita.estado;
            
            // Actualizar la tabla
                tm.setValueAt(cita.getEstado(), filaSeleccionada, 6);
            
                JOptionPane.showMessageDialog(this, "CITA ACTUALIZADA.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_ActualizarEstado

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaSeleccionada = txttable.getSelectedRow();
    
        if (filaSeleccionada != -1) { 
        String cedulaSeleccionada = txttable.getValueAt(filaSeleccionada, 0).toString();

        boolean eliminado = cic.eliminarCitaPorPaciente(cedulaSeleccionada);

            if (eliminado) {
                javax.swing.JOptionPane.showMessageDialog(this, "CITA ELIMINADA.");
            }

        tm.setRowCount(0);
        listartodo(); 
        } else {
        javax.swing.JOptionPane.showMessageDialog(this, "SELECCIONE UNA CITA.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxespecialidad;
    private javax.swing.JComboBox<String> cbxestado;
    private javax.swing.JComboBox<String> cbxfecha;
    private javax.swing.JComboBox<String> cbxmedicos;
    private javax.swing.JComboBox<String> cbxpacientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable txttable;
    // End of variables declaration//GEN-END:variables
}
