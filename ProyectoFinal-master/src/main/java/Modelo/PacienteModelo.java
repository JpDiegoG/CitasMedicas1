package Modelo;

public class PacienteModelo {
    public String cedula;
    public String nombre;
    public int edad;
    public boolean sexo;

    public PacienteModelo(String cedula, String nombre, int edad, boolean sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    //
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

    public String getSexo() {
        return sexo ? "HOMBRE":"MUJER";
    }
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}
