
package controlador;

import java.util.ArrayList;
import modelo.EspecialidadModelo;
import modelo.MedicoModelo;


public class MedicoControlador {
     ArrayList<MedicoModelo> medicoModelos;
     private static MedicoControlador instancia;

    private MedicoControlador() {
        this.medicoModelos = new ArrayList<>();
    }
    public  static MedicoControlador getInstancia(){
        if(instancia==null){
            instancia=new MedicoControlador();
            
        }
        return instancia;
        
    }
    
    public MedicoModelo guardar(EspecialidadModelo em, String cedula, String nombres, int edad, boolean sexo){
        MedicoModelo mm=new MedicoModelo(em, nombres, cedula, edad, sexo);
        
        medicoModelos.add(mm);
        return mm;
    }
     public ArrayList<MedicoModelo> listadoCompleto(){
         return medicoModelos;    
     }
     
     public ArrayList<MedicoModelo>listadoPorEspecialidad(String n_e){
         ArrayList <MedicoModelo> nuevoListado = new ArrayList<>();
        for (MedicoModelo mm : medicoModelos ) {
            if(mm.getEspecialidadModelo().getNombre().contains(n_e)){
                nuevoListado.add(mm);
            }
            
        }
        return nuevoListado;
     }
     
     public MedicoModelo obtenerPorCedula(String cedula){
        for (MedicoModelo mm : medicoModelos) {
            if(mm.getCedula().equals(cedula)){
                return mm;
            }     
        }
    return null;
    }
     
}
