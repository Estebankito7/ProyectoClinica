public class Paciente extends Persona {

    private String Codigo;
    private String Contraseña;
    
    public Paciente (String Nombre, String Documento, String Telefono, String Direccion, String Correo, String Contraseña){
        super(Nombre,Documento,Telefono, Direccion, Correo );

        this.Contraseña = Contraseña;
    }
    
    public String getCodigo() {
        return Codigo;
    }
    
    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
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