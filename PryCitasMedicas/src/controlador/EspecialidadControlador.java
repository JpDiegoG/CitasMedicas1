package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;

public class EspecialidadControlador {
    ArrayList<EspecialidadModelo> especialidadModelos;
        private static EspecialidadControlador instancia;

    public EspecialidadControlador() {
        this.especialidadModelos = new ArrayList<>();
    }
            
    public static EspecialidadControlador getInstancia(){
        if (instancia == null){
            instancia = new EspecialidadControlador();
            
        }
        return instancia ;
        
        
    }
    public EspecialidadModelo guardar(String nombre){
        EspecialidadModelo modelo = new EspecialidadModelo(nombre);
        especialidadModelos.add(modelo);
        return modelo;
    }
    
    public ArrayList <EspecialidadModelo> lista(){
        return especialidadModelos;
    }
    
    public EspecialidadModelo obtenerPorNombre(String nombre){
        for (EspecialidadModelo em : especialidadModelos){
            if(em.getNombre().equals(nombre)){
                return em;
            }
        }
        return null;
    }
}

