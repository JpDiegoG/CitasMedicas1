package controlador;

import java.util.ArrayList;
import modelo.CitaModelo;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;
import modelo.PacienteModelo;

public class CitasControlador {
    public ArrayList<CitaModelo>citaModelos;
    
    private static CitasControlador instancia;

    public CitasControlador() {
        citaModelos = new ArrayList<>();
    }
    
    public static CitasControlador getInstancia(){
    if(instancia==null){
        instancia=new CitasControlador();
        }
    return instancia;
    };
    
    public CitaModelo guardar(PacienteModelo pm,MedicoModelo mm,EspecialidadModelo em,String descipcion,String fecha,String hora){
        CitaModelo cm=new CitaModelo(pm, mm, em, descipcion, fecha, hora);
        citaModelos.add(cm);
        return cm;
    }
}
