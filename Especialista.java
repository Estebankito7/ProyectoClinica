public class Especialista extends Persona {

private String Registro;
private String Especialidad;
private String Estado;

public Especialista (String Nombre, String Documento, String Telefono, String Direccion, String Correo, String especialidad,String registro,String estado){

    super(Nombre, Documento, Telefono, Direccion, Correo);
    this.Estado = estado;
    this.Registro = registro;
    this.Especialidad = especialidad;
}

public String getRegistro() {
    return Registro;
}

public void setRegistro(String registro) {
    Registro = registro;
}

public String getEspecialidad() {
    return Especialidad;
}

public void setEspecialidad(String especialidad) {
    Especialidad = especialidad;
}

public String getEstado() {
    return Estado;
}

public void setEstado(String estado) {
    Estado = estado;
}
public void Imprimir() {
    System.out.println("**********");
    System.out.println(Nombre);
    System.out.println("CC:"+Documento);
    System.out.println("Tel:"+Telefono);
    System.out.println(Direccion);
    System.out.println(Correo);
    System.out.println(Especialidad);
    System.out.println(Registro);
    System.out.println(Estado);
    System.out.println("**********");
    System.out.println("");
}
}
