import java.util.Date;
import java.util.List;

public class Admisionista extends Persona {
    private String usuario;
    private String contraseña;

    public Admisionista(String nombre, String documento, String telefono, String direccion, String correo, String usuario, String contraseña) {
        super(nombre, documento, telefono, direccion, correo);
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Método para validar las credenciales de un admisionista desde el CallCenter
    public static boolean validarCredenciales(CallCenter callCenter, String usuario, String contraseña) {
        List<Admisionista> listaAdmisionistas = callCenter.getListaAdmisionista();
        for (Admisionista adm : listaAdmisionistas) {
            if (adm.getUsuario().equals(usuario) && adm.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public void registrarCita(CallCenter callCenter, Cita cita) {
        callCenter.agregarCita(cita);
        System.out.println("Cita registrada exitosamente.");
    }

    public void verCitas(CallCenter callCenter) {
        List<Cita> citas = callCenter.getListaCitas();
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            System.out.println("=== Lista de Citas ===");
            for (Cita cita : citas) {
                System.out.println(cita);
            }
        }
    }

    public void reprogramarCita(CallCenter callCenter, Cita cita, Date nuevaFecha, String nuevaHora) {
        if (callCenter.getListaCitas().contains(cita)) {
            cita.setFecha(nuevaHora);
            cita.setHora(nuevaHora);
            System.out.println("Cita reprogramada exitosamente.");
        } else {
            System.out.println("La cita no existe en el sistema.");
        }
    }

    public void cancelarCita(CallCenter callCenter, Cita cita) {
        if (callCenter.getListaCitas().remove(cita)) {
            System.out.println("Cita cancelada exitosamente.");
        } else {
            System.out.println("La cita no existe en el sistema.");
        }
    }

    // Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return super.toString() + ", Usuario: " + usuario;
    }
}
