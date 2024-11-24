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
        System.out.println("****************************");
        System.out.println("Datos del Paciente:");
        System.out.println("Nombre: " + Nombre);
        System.out.println("Documento: " + Documento);
        System.out.println("Teléfono: " + Telefono);
        System.out.println("Dirección: " + Direccion);
        System.out.println("Correo: " + Correo);
        System.out.println("****************************\n");
    }

}