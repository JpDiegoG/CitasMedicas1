package modelo;

public class MedicoModelo extends PacienteModelo {
    
    private EspecialidadModelo especialidadModelo;

    public MedicoModelo(EspecialidadModelo especialidadModelo, String nombre, String cedula, int edad, boolean sexo) {
        super(nombre, cedula, edad, sexo); 
        this.especialidadModelo = especialidadModelo;
    }

    public EspecialidadModelo getEspecialidadModelo() {
        return especialidadModelo;
    }

    public void setEspecialidadModelo(EspecialidadModelo especialidadModelo) {
        this.especialidadModelo = especialidadModelo;
    }
    
}
