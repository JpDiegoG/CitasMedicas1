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

public class Ingresar extends javax.swing.JInternalFrame {
    PacienteControlador cp = PacienteControlador.getInstancia();
    EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    MedicoControlador mc = MedicoControlador.getInstancia();
    CitaControlador cc = CitaControlador.getInstancia();
    
    public Ingresar() {
        initComponents();
        CargarPaciente();
        CargarEspecialidad();
        cbxespecialidades.addActionListener(e ->{
            String nombreEspecialidad= cbxespecialidades.getSelectedItem().toString();
            
            if (!nombreEspecialidad.equals("SELECIONE ESPECIALIDAD")){
                CargarMedicos(nombreEspecialidad);
            }
        });
                
    }

    private void CargarPaciente(){
        for (PacienteModelo pa : cp.listadoCompleto()) {
            cbxpacientes.addItem(pa.getCedula()+" "+pa.getNombre());
        }
    }
    
    private void CargarEspecialidad(){
        cbxespecialidades.addItem("SELECCIONE ESPECIALIDAD.");
        for (Especialidad es : ec.Listado()) {
            cbxespecialidades.addItem(es.getNombre());
        }
    }
    private void CargarMedicos(String ne){
        cbxmedicos.removeAllItems();
        for (MedicoM medicoModelo : mc.ListadoPorEspecilidad(ne)) {
            cbxmedicos.addItem(medicoModelo.getCedula()+ " "+medicoModelo.getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxpacientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxespecialidades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxmedicos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        txthora = new javax.swing.JTextField();
        BtnGuardarCita = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("SELECCIONAR PACIENTE: ");

        jLabel2.setText("SELECCIONE ESPECIALIDAD:");

        jLabel3.setText("SELECCIONE EL MEDICO:");

        jLabel4.setText("¿Para que necesita la cita?");

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane1.setViewportView(txtdescripcion);

        jLabel5.setText("FECHA:");

        jLabel6.setText("HORA:");

        BtnGuardarCita.setText("GUARDAR ");
        BtnGuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarCitaActionPerformed(evt);
            }
        });

        jLabel7.setText("dd/mm/yyyy");

        jLabel8.setText("hh:mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(cbxmedicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbxespecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(cbxpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BtnGuardarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxespecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxmedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnGuardarCita)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarCitaActionPerformed
        //PACIENTE
        String infpaciente = cbxpacientes.getSelectedItem().toString();
        String pacientepar[] = infpaciente.split(" ");
        String cedpaciente = pacientepar[0];
        PacienteModelo pm = cp.PacientePorCedula(cedpaciente);
        //MEDICO
        String infmedicos = cbxmedicos.getSelectedItem().toString();
        String medicopar[] = infmedicos.split(" ");
        String cedmedico = medicopar[0];
        MedicoM mm = mc.MedicoPorCeducla(cedmedico);
        //ESPECIALIDAD
        Especialidad em = mm.getespecialidadmodelo();
        String descripcion = txtdescripcion.getText();
        String Fecha = txtfecha.getText();
        String hora = txthora.getText();
        boolean estado = true;
        
        if (descripcion.isEmpty() || Fecha.isEmpty() || hora.isEmpty()) {
            JOptionPane.showMessageDialog(this, "LLENE LOS CAMPOS VACIOS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!descripcion.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "LA DESCRIPCION DEBE CONTENER LETRAS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "LA FECHA DEBE SEGIR EL FORMATO: dd/mm/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!hora.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "LA HORA DEBE SEGIR EL FORMATO: hh:mm.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        CitaM cm = cc.Guardar(pm, em, mm, descripcion, Fecha, hora, estado);
        
        JOptionPane.showMessageDialog(
                this,
                "Cita ingresada para la fecha: "+
                cm.getFecha()+
                "  Para la: "+
                cm.getHora()+
                "  Con el medico: "+
                cm.getMedico().getNombre()+
                "  De especialidad: "+
                cm.getEspecialidad().getNombre()
        );
        txtdescripcion.setText("");
        txtfecha.setText("");
        txthora.setText("");
    }//GEN-LAST:event_BtnGuardarCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardarCita;
    private javax.swing.JComboBox<String> cbxespecialidades;
    private javax.swing.JComboBox<String> cbxmedicos;
    private javax.swing.JComboBox<String> cbxpacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthora;
    // End of variables declaration//GEN-END:variables
}
