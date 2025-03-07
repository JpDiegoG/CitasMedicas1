package Modelo;

public class CitaM {
    public PacienteModelo paciente;
    public Especialidad especialidad;
    public MedicoM medico;
    public String descripcion;
    public String fecha;
    public String hora;
    public boolean estado;

    public CitaM(PacienteModelo paciente, Especialidad especialidad, MedicoM medico, String descripcion, String fecha, String hora, boolean estado) {
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.medico = medico;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public PacienteModelo getPaciente() {
        return paciente;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public MedicoM getMedico() {
        return medico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    public String getEstado() {
        return estado ? "NO ATENDIDO":"ATENDIDO";
    }
}
