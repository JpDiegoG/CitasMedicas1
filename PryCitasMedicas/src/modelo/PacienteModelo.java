package modelo;

public class PacienteModelo {
    protected String nombre;
    protected String cedula;
    protected int edad;
    protected boolean sexo;

    public PacienteModelo(String nombre, String cedula, int edad, boolean sexo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public boolean getSexo() {
        return sexo;
    }
}


