package modelo;

public class CitaModelo {
    public PacienteModelo pm;
    public MedicoModelo mm;
    public EspecialidadModelo em;
    public String descipcion;
    public String fecha;
    public String hora;

    public CitaModelo(PacienteModelo pm, MedicoModelo mm, EspecialidadModelo em, String descipcion, String fecha, String hora) {
        this.pm = pm;
        this.mm = mm;
        this.em = em;
        this.descipcion = descipcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public PacienteModelo getPm() {
        return pm;
    }

    public void setPm(PacienteModelo pm) {
        this.pm = pm;
    }

    public MedicoModelo getMm() {
        return mm;
    }

    public void setMm(MedicoModelo mm) {
        this.mm = mm;
    }

    public EspecialidadModelo getEm() {
        return em;
    }

    public void setEm(EspecialidadModelo em) {
        this.em = em;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
    