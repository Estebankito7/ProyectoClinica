
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

    public void Imprimir() {
        System.out.println("**********");
        System.out.println(Nombre);
        System.out.println(Documento);
        System.out.println(Telefono);
        System.out.println(Direccion);
        System.out.println(Correo);
        System.out.println("**********");
        System.out.println("");

}

}