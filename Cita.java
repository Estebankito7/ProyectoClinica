public class Cita {
    
    private String fecha;
    private String hora;
    private String consultorio;
    private Medico medico;
    private Paciente paciente;

    // Constructor
    public Cita(String fecha, String hora, String consultorio, Medico medico, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.consultorio = consultorio;
        this.medico = medico;
        this.paciente = paciente;
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

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", consultorio='" + consultorio + '\'' +
                ", medico=" + medico +
                ", paciente=" + paciente +
                '}';
    }
}
