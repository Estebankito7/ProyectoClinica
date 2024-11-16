public class Persona {

    protected String Nombre;
    protected String Documento;
    protected String Telefono;
    protected String Direccion;
    protected String Correo;

    public Persona(String nombre, String documento, String telefono, String direccion, String correo){
        
        this.Nombre = nombre;
        this.Documento = documento;
        this.Telefono = telefono;
        this.Direccion = direccion;
        this.Correo = correo;

    }


    //Getters
    public String getNombre() {
        return this.Nombre;
    }

    public String getDocumento() {
        return this.Documento;
    }

    public String getTelefono() {
        return this.Telefono;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public String getCorreo() {
        return this.Correo;
    }

    //Setters
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.Documento = documento;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + this.Nombre + '\'' +
                ", documento='" + this.Documento + '\'' +
                ", telefono='" + this.Telefono + '\'' +
                ", direccion='" + this.Direccion + '\'' +
                ", correo='" + this.Correo + '\'' +
                '}';
    }
}
