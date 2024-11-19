public class Medico extends Persona {

    private String RegistroMedico;
    private String Estado;

    // Constructor
    public Medico(String nombre, String documento, String telefono, String direccion, String correo,
            String registroMedico,String estado) {
        super(nombre, documento, telefono, direccion, correo);
        this.RegistroMedico = registroMedico;
        this.Estado= estado;
    }

    // Getter y Setter para registroMedico
    public String getRegistroMedico() {
        return RegistroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.RegistroMedico = registroMedico;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + getNombre() + '\'' +
                ", documento='" + getDocumento() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", registroMedico='" + RegistroMedico + '\'' +
                '}';
    }

    public void Imprimir() {
        System.out.println("**********");
        System.out.println(Nombre);
        System.out.println(Documento);
        System.out.println(Telefono);
        System.out.println(Direccion);
        System.out.println(Correo);
        System.out.println(RegistroMedico);
        System.out.println(Estado);
        System.out.println("**********");
        System.out.println("");
    }

}
