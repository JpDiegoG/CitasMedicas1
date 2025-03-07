package Vista.Medicos;

import Controlador.EspecialdadControlador;
import Controlador.MedicoControlador;
import Modelo.Especialidad;
import javax.swing.JOptionPane;

public class EditarMedico extends javax.swing.JInternalFrame {
    private String cedulaAnterior; // Almacena la cédula del médico que se está editando
    private MedicoControlador mc = MedicoControlador.getInstancia();
    private EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    public EditarMedico(String cedula, String nombre, int edad, String sexo, String especialidad) {
        initComponents();
        this.cedulaAnterior = cedula;
        initComponents();

        // Cargar los datos del médico en los campos de texto
        txtcedula.setText(cedula);
        txtnombre.setText(nombre);
        txtedad.setText(String.valueOf(edad));
        cbx_sexo.setSelectedItem(sexo);
        // Cargar las especialidades en el JComboBox
        for (Especialidad em : ec.Listado()) {
            cbx_especialidades.addItem(em.getNombre());
        }

        // Seleccionar la especialidad actual del médico
        cbx_especialidades.setSelectedItem(especialidad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        cbx_sexo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_especialidades = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cedula: ");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Edad: ");

        cbx_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOMBRE", "MUJER" }));

        jButton1.setText("GUARDAR.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarMedico(evt);
            }
        });

        jLabel4.setText("Sexo: ");

        jLabel5.setText("Especialidad: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcedula, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txtnombre)
                            .addComponent(txtedad)
                            .addComponent(cbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbx_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarMedico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarMedico
        String cedula = txtcedula.getText().trim();
    String nombre = txtnombre.getText().trim();
    boolean sexo = cbx_sexo.getSelectedItem().toString().equals("HOMBRE");
    String nombreEspecialidad = cbx_especialidades.getSelectedItem().toString();

    // Validaciones
    if (cedula.isEmpty() || nombre.isEmpty() || txtedad.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "LLENAR TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!cedula.matches("\\d{10}")) {  // Ajusta la longitud según tu necesidad
        JOptionPane.showMessageDialog(this, "LA CEDULA DEBE CONTENER 10 DÍGITOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int edad;
    try {
        edad = Integer.parseInt(txtedad.getText().trim());
        if (edad <= 0) {
            JOptionPane.showMessageDialog(this, "LA EDAD NO PUEDE SER NEGATIVA", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "INGRESE UN NÚMERO VÁLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener la especialidad seleccionada
    EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    Especialidad em = ec.obtenernombre(nombreEspecialidad);

    // Actualizar los datos del médico
    boolean actualizado = mc.actualizarMedico(cedulaAnterior, cedula, nombre, edad, sexo, em);

    if (actualizado) {
        JOptionPane.showMessageDialog(this, nombre + " ACTUALIZADO EXITOSAMENTE!");
        this.dispose(); // Cerrar la ventana de edición después de guardar
    } else {
        JOptionPane.showMessageDialog(this, "ERROR AL ACTUALIZAR EL MÉDICO", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_GuardarMedico


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx_especialidades;
    private javax.swing.JComboBox<String> cbx_sexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
