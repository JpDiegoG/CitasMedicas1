package Vista.Medicos;

import Controlador.EspecialdadControlador;
import Controlador.MedicoControlador;
import Modelo.Especialidad;
import Modelo.MedicoM;
import javax.swing.JOptionPane;

public class Ingresar extends javax.swing.JInternalFrame {
    EspecialdadControlador ec = EspecialdadControlador.getInstancia();
    MedicoControlador mec = MedicoControlador.getInstancia();
    public Ingresar() {
        initComponents();
        for (Especialidad em : ec.Listado()) {
            cbxespecialidades.addItem(em.getNombre());
        }
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
        txtsexo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxespecialidades = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cedula: ");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Edad: ");

        txtsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOMBRE", "MUJER" }));

        jButton1.setText("GUARDAR.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearPaciente(evt);
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
                            .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxespecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxespecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearPaciente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPaciente
        String Cedula = txtcedula.getText();
        String Nombre= txtnombre.getText();
        String Edad= txtedad.getText();
        boolean Sexo = txtsexo.getSelectedItem().toString().equals("HOMBRE");
        String  nombreespecialidad = cbxespecialidades.getSelectedItem().toString();
        
        if (Cedula.isEmpty() || Nombre.isEmpty() || Edad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "LLENE TODOS LOS CAMPOS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Cedula.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "LA CEDULA DEBE CONTENER SOLO NUMEROS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Nombre.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "EL NOMBRE DEBE CONTENER SOLO LETRAS.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(Edad);
            if (edad <= 0) {
                JOptionPane.showMessageDialog(this, "LA EDAD DEBE SER UN NUMERO REAL.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "LA EDAD DEBE SER UN NUMERO.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (mec.medicoExiste(Cedula)) {
            JOptionPane.showMessageDialog(this, "ESTE MEDICO YA EXISTE.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        EspecialdadControlador ec = EspecialdadControlador.getInstancia();
        Especialidad em = ec.obtenernombre(nombreespecialidad);
        
        MedicoControlador mc = MedicoControlador.getInstancia();
        MedicoM mm = mc.Guardar(em, Cedula, Nombre, edad, Sexo);
        
        JOptionPane.showMessageDialog(this, "Guardado correctamente");
        txtcedula.setText("");
        txtnombre.setText("");
        txtedad.setText("");
    }//GEN-LAST:event_CrearPaciente


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxespecialidades;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JComboBox<String> txtsexo;
    // End of variables declaration//GEN-END:variables
}
