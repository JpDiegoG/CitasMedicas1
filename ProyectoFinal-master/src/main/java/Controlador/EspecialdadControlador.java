package Controlador;

import Modelo.Especialidad;
import java.util.ArrayList;

public class EspecialdadControlador {
    ArrayList<Especialidad> especialidad;
    private static EspecialdadControlador instancia;

    private EspecialdadControlador() {
        this.especialidad = new ArrayList<>();
    }
    
    public static EspecialdadControlador getInstancia(){
        if(instancia == null){
            instancia = new EspecialdadControlador();
        }
        return instancia;
    }
    
    public Especialidad GuardarEspecialidad(String especialidad){
        Especialidad modelo = new Especialidad(especialidad);
        this.especialidad.add(modelo);
        return modelo;
    }
    
    public ArrayList<Especialidad> Listado(){
        return especialidad;
    }
    
    public Especialidad obtenernombre(String nombre){
        for (Especialidad em : especialidad) {
            if(em.getNombre().equals(nombre)){
                return em;
            }
        }
        return null;
    }
    
    public ArrayList<Especialidad>BuscarEspecialidad(String cedula){
        ArrayList<Especialidad> nuevaLista= new ArrayList<>();
        for (Especialidad especialidadn : especialidad) {
            if (especialidadn.getNombre().contains(cedula)){
                nuevaLista.add(especialidadn);
            }  
        }
        return nuevaLista;
    }
    public boolean especialidadExiste(String especialidadex) {
        for (Especialidad espe : especialidad) {
            if (espe.getNombre().equals(especialidadex)) {
                return true;
            }
        }
        return false;
    }
    public boolean eliminarEspecialidad(String cedula) {
        for (Especialidad espe : especialidad) {
            if (espe.getNombre().equals(cedula)) {
                especialidad.remove(espe);
                return true;
            }
        }
        return false; 
    }
    
    public boolean actualizarEspecialidad(String nombreAnterior, String nombreNuevo) {
    for (Especialidad e : especialidad) {
        if (e.getNombre().equals(nombreAnterior)) {
            e.setNombre(nombreNuevo);
            return true; // Retorna true si la actualización fue exitosa
        }
    }
    return false; // Retorna false si no se encontró la especialidad
}
}
