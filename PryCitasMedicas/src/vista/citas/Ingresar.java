package vista.citas;

import controlador.CitasControlador;
import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import javax.swing.JOptionPane;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class Ingresar extends javax.swing.JInternalFrame {
    
    MedicoControlador mc=MedicoControlador.getInstancia();
    EspecialidadControlador ec=EspecialidadControlador.getInstancia();
    PacienteControlador pc=PacienteControlador.getInstancia();
    
    CitasControlador cc=CitasControlador.getInstancia();
    
    public Ingresar() {
        initComponents();
        
        //carguen en nuestro combo box la acarga automatica
        cargarPacienteAutomaticamente();
        cargarEspecialidadAutomaticamente();
        
        
        cbx_especialidades.addActionListener(e ->{
            String nombresEspecialidad=cbx_especialidades.getSelectedItem().toString();
            cbx_medicos.removeAllItems();
            if(!nombresEspecialidad.equals("SELECCIONES ESPECIALIDAD")){
                cargarAutomaticamenteMedicos(nombresEspecialidad);
            //System.out.println(nombresEspecialidad);
            }
    });
    
    }   
    private void cargarPacienteAutomaticamente(){
        for (PacienteModelo pm : pc.listadoCompleto() ) {
            cbx_pacientes.addItem(pm.getCedula()+" "+pm.getNombre());
        }
    }
    
    private void cargarEspecialidadAutomaticamente(){
        cbx_medicos.removeAllItems();
        cbx_especialidades.addItem("SELECCIONE ESPECIALIDAD");
        
    for (EspecialidadModelo em : ec.lista()) {
            cbx_especialidades.addItem(em.getNombre());
        }
    }
    
    private void cargarAutomaticamenteMedicos(String ne){
    
    for (MedicoModelo mm : mc.listadoPorEspecialidad(ne)) {
            cbx_medicos.addItem(mm.getCedula()+" "+mm.getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbx_pacientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbx_especialidades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbx_medicos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        txt_hora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();

        jLabel1.setText("SELECCIONAR PACIENTE");

        jLabel2.setText("SELECCIONE ESPECIALIDAD");

        cbx_especialidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel3.setText("SELECCIONE MEDICO");

        jLabel4.setText("PARA QUE NECESITA LA CITA?");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        jLabel5.setText("FECHA");

        jLabel6.setText("HORA");

        jLabel7.setText("DD/MM/YYYY");

        jLabel8.setText("HH/MM");

        btn_guardar.setText("GENERAR TURNO");
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbx_pacientes, 0, 393, Short.MAX_VALUE)
                                .addComponent(cbx_especialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbx_medicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_fecha)
                            .addComponent(txt_hora, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbx_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbx_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btn_guardar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
    String paciente = cbx_pacientes.getSelectedItem().toString();
    String pacientePartes[]=paciente.split(" ");
    String cedulaPaciente=pacientePartes[0];
    PacienteModelo pm = pc.obtenerPorCedula(cedulaPaciente);
    
    String medico = cbx_medicos.getSelectedItem().toString();
    String medicoPartes[]=medico.split(" ");
    String cedulaMedico=medicoPartes[0];
    MedicoModelo mm = mc.obtenerPorCedula(cedulaMedico);
    
    EspecialidadModelo em= mm.getEspecialidadModelo();
    CitaModelo cm=cc.guardar(pm, mm, em, txt_descripcion.getText(), txt_fecha.getText(), txt_hora.getText());
    JOptionPane.showMessageDialog(this, "CITA INGRESA PARA EL DIA"+
            cm.getFecha()+" PARA LAS"+
            cm.getHora()+" CON EL MEDICO"+
            cm.getMm().getNombre()+
            " PARA LA ESPECIALIDAD"+
            cm.getEm().getNombre());
    }//GEN-LAST:event_btn_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbx_especialidades;
    private javax.swing.JComboBox<String> cbx_medicos;
    private javax.swing.JComboBox<String> cbx_pacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
