package controlador;

import java.util.ArrayList;
import modelo.PacienteModelo;

public class PacienteControlador {
    public ArrayList <PacienteModelo> pacienteModeloLista;
    private static PacienteControlador instancia;

    private PacienteControlador() {
        this.pacienteModeloLista = new ArrayList<>();
    }
    
    public static PacienteControlador getInstancia(){
        if (instancia == null){
            instancia = new PacienteControlador();
        }
        return instancia;
        
    }
    
    public PacienteModelo guardarDatos (String cedula, String nombres, int edad, boolean sexo){
        PacienteModelo modeloPaciente = new PacienteModelo(nombres, cedula, edad, sexo);
        pacienteModeloLista.add(modeloPaciente);
        return modeloPaciente;
        }
    
    public ArrayList <PacienteModelo> listadoCompleto (){
        return pacienteModeloLista;
    }
    
    public ArrayList <PacienteModelo> listadoCompletoPorCedula (String cedula){
        ArrayList <PacienteModelo> nuevoListado = new ArrayList<>();
        for (PacienteModelo pm : pacienteModeloLista) {
            if(pm.getCedula().contains(cedula)){
                nuevoListado.add(pm);
            }
            
        }
        return nuevoListado;
     }
    
    public PacienteModelo obtenerPorCedula(String cedula){
        for (PacienteModelo pm : pacienteModeloLista) {
            if(pm.getCedula().equals(cedula)){
                return pm;
            }     
        }
    return null;
    }
}


