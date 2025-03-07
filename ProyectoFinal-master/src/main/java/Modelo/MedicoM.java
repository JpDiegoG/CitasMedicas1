package Modelo;

public class MedicoM extends PacienteModelo {
    public  Especialidad especialidadmodelo;

    public MedicoM(Especialidad especialidadmodelo, String cedula, String nombre, int edad, boolean sexo) {
        super(cedula, nombre, edad, sexo);
        this.especialidadmodelo = especialidadmodelo;
    }

    public Especialidad getespecialidadmodelo() {
        return especialidadmodelo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setEspecialidadmodelo(Especialidad especialidadmodelo) {
        this.especialidadmodelo = especialidadmodelo;
    }
    public String GetEspecialidadmodelo(){
            return this.especialidadmodelo.getNombre();
    }

    public void setEspecialidad(Especialidad especialidad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
