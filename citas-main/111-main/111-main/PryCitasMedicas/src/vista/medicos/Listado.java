package vista.medicos;

import controlador.MedicoControlador;
import javax.swing.table.DefaultTableModel;
import modelo.MedicoModelo;

public class Listado extends javax.swing.JInternalFrame {

    private DefaultTableModel tablemodel;
    private MedicoControlador mc = MedicoControlador.getInstancia();
    
    public Listado() {
        initComponents();
        configurarTabla();
        cargarListadoMedicos();
}
        
        private void configurarTabla() {
        tablemodel = new DefaultTableModel();
        tbl_listado.setModel(tablemodel);
        String[] columnas = {"CÉDULA", "NOMBRES", "EDAD", "SEXO", "ESPECIALIDAD"};
        tablemodel.setColumnIdentifiers(columnas);
    }
    
  private void cargarListadoMedicos() {
    tablemodel.setRowCount(0); 
    for (MedicoModelo mm : mc.listadoCompleto()) {
        System.out.println("Edad de " + mm.getNombre() + ": " + mm.getEdad());
        
        Object[] fila = {
            mm.getCedula(), 
            mm.getNombre(), 
            mm.getEdad(), 
            mm.getSexo() ? "Masculino" : "Femenino",  // Convertir boolean a texto
            mm.getEspecialidadModelo().getNombre()
        };
        tablemodel.addRow(fila);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_buscarcedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listado = new javax.swing.JTable();

        jLabel1.setText("BUSCAR POR CEDULA ");

        txt_buscarcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarcedulaActionPerformed(evt);
            }
        });
        txt_buscarcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarcedulaKeyReleased(evt);
            }
        });

        tbl_listado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_listado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txt_buscarcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_buscarcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarcedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarcedulaActionPerformed

    private void txt_buscarcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarcedulaKeyReleased
    String cedula = txt_buscarcedula.getText().trim();
        tablemodel.setRowCount(0);
        
        for (MedicoModelo mm : mc.listadoCompleto()) {
            if (mm.getCedula().startsWith(cedula)) { 
                Object[] fila = {
                    mm.getCedula(), 
                    mm.getNombre(), 
                    mm.getEdad(), 
                    mm.getSexo() ? "Masculino" : "Femenino",  
                    mm.getEspecialidadModelo().getNombre()
                };
                tablemodel.addRow(fila);
            }
        }
    }//GEN-LAST:event_txt_buscarcedulaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_listado;
    private javax.swing.JTextField txt_buscarcedula;
    // End of variables declaration//GEN-END:variables
}