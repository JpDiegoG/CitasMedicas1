
package prycitasmedicas;

import controlador.EspecialidadControlador;
import controlador.MedicoControlador;
import controlador.PacienteControlador;
import modelo.EspecialidadModelo;
import vista.PantallaPrincipal;

public class PryCitasMedicas {

    public static void main(String[] args) {
        PacienteControlador pc=PacienteControlador.getInstancia();
        pc.guardarDatos("0504453622", "DIEGO", 19, true);
        pc.guardarDatos("414141", "MATIAS", 19, true);
        pc.guardarDatos("414141", "ANA", 19, false);
        
        EspecialidadControlador ec=EspecialidadControlador.getInstancia();
        EspecialidadModelo em1=ec.guardar("MEDICINA GENERAL");
        
        MedicoControlador mc=MedicoControlador.getInstancia();
        mc.guardar(em1, "1434143", "DOME", 26, false);
        
        PantallaPrincipal p = new PantallaPrincipal ();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
    
}
