public class Paciente extends Persona {

    private String Codigo;
    
    public Paciente (String Nombre, String Documento, String Telefono, String Direccion, String Correo){
        super(Nombre,Documento,Telefono, Direccion, Correo );
    }
    
    public String getCodigo() {
        return Codigo;
    }
    
    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
    
}