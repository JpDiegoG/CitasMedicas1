package com.mycompany.prycitasmedicas;
import Controlador.CitaControlador;
import Controlador.PacienteControlador;
import Controlador.EspecialdadControlador;
import Controlador.MedicoControlador;
import Modelo.Especialidad;
import Vista.Principal;

public class PryCitasMedicas {

    public static void main(String[] args) {
        Principal p = new Principal();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        
        PacienteControlador cp = PacienteControlador.getInstancia();
        cp.guardarDatos("0504453622", "DIEGO", 19, true);
        cp.guardarDatos("2652428292", "MATIAS", 20, true);
        cp.guardarDatos("8486958723", "ALEJANDRO", 18, true);
        
        EspecialdadControlador ec = EspecialdadControlador.getInstancia();
        Especialidad ec1 = ec.GuardarEspecialidad("CARDIOLOGIA");
        Especialidad ec2 = ec.GuardarEspecialidad("ODONTOLOGIA");
        Especialidad ec3 = ec.GuardarEspecialidad("TRAUMATOLOGIA");
        
        MedicoControlador mc = MedicoControlador.getInstancia();
        mc.Guardar(ec1, "3416578254", "MICHAEL", 56, true);
        mc.Guardar(ec2, "1237895261", "DOME", 54, false);
        mc.Guardar(ec3, "4567539514", "MARIA", 45, false);       
        
    }
}
