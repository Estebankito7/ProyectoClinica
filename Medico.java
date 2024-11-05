public class Medico extends Persona {

    private String registroMedico;

    // Constructor
    public Medico(String nombre, String documento, String telefono, String direccion, String correo, String registroMedico) {
        super(nombre, documento, telefono, direccion, correo);  
        this.registroMedico = registroMedico;
    }

    // Getter y Setter para registroMedico
    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }


    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + getNombre() + '\'' +
                ", documento='" + getDocumento() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", registroMedico='" + registroMedico + '\'' +
                '}';
    }
}
