package Controlador;
import Modelo.PacienteModelo;
import java.util.ArrayList;

public class PacienteControlador {
    public ArrayList<PacienteModelo>pacientes;

    public static PacienteControlador instancia;
    
    private PacienteControlador() {
    this.pacientes = new ArrayList<>();    
    }
    
    public static PacienteControlador getInstancia(){
        if(instancia == null){
            instancia = new PacienteControlador();
        }
        return instancia;
    }
    
    public PacienteModelo guardarDatos(String cedula, String nombre, int edad, boolean sexo){
        PacienteModelo modelopaciente = new  PacienteModelo(cedula, nombre, edad, sexo);
        pacientes.add(modelopaciente);
        return modelopaciente;
    }
    
    public ArrayList<PacienteModelo> listadoCompleto(){
        return pacientes;
    }
    
    public ArrayList<PacienteModelo>BuscarPaciente(String cedula){
        ArrayList<PacienteModelo> nuevaLista= new ArrayList<>();
        for (PacienteModelo paciente : pacientes) {
            if (paciente.getCedula().contains(cedula)){
                nuevaLista.add(paciente);
            }
        }
        return nuevaLista;
    }
    public PacienteModelo PacientePorCedula(String cedula){
        for (PacienteModelo paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)){
                return paciente;
            }
        }
        return null;
    }
    public boolean cedulaExiste(String cedula) {
        for (PacienteModelo paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }
    public boolean eliminarPaciente(String cedula) {
        for (PacienteModelo paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                pacientes.remove(paciente);
                return true;
            }
        }
        return false; 
    }
    
    public boolean actualizarPaciente(String cedulaAnterior, String cedula, String nombre, int edad, boolean sexo) {
    for (PacienteModelo paciente : pacientes) {
        if (paciente.getCedula().equals(cedulaAnterior)) {
            paciente.setCedula(cedula);
            paciente.setNombre(nombre);
            paciente.setEdad(edad);
            paciente.setSexo(sexo);
            return true; // Retorna true si la actualización fue exitosa
        }
    }
    return false; // Retorna false si no se encontró el paciente
}
}
