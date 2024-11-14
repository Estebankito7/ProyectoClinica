import java.util.Date;
import java.util.List;
import java.util.HashSet;

public class Admisionista<usuariosExistentes> extends Persona {
    private String usuario;
    private String contraseña;


    private static HashSet<String> usuariosExistentes = new HashSet<>();
    private static HashSet<String> contraseñasExistentes = new HashSet<>();

    public Admisionista(String nombre, String documento, String telefono, String direccion, String correo, String usuario, String contraseña) {
        super(nombre, documento, telefono, direccion, correo);

        if (usuariosExistentes.contains(usuario)) {
            throw new IllegalArgumentException("El nombre de usuario ya esta en uso. Intente con otro nomvre de usuario.");
        }

        if (contraseñasExistentes.contains(contraseña)) {
            throw new IllegalArgumentException("La contraseña ya esta en uso. Intente con otra tipo contraseña.");
        }

        this.usuario = usuario;
        this.contraseña = contraseña;
        
        usuariosExistentes.add(usuario);
        contraseñasExistentes.add(contraseña);
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


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuariosExistentes.contains(usuario)) {
            throw new IllegalArgumentException("El nombre de usuario ya esta en uso. Intente con otro nombre de usuario.");
        }
        usuariosExistentes.remove(this.usuario);
        this.usuario = usuario;
        usuariosExistentes.add(usuario);
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        if (contraseñasExistentes.contains(contraseña)) {
            throw new IllegalArgumentException("La contraseña ya está en uso. Intente con otra.Intente con otra tipo contraseña");
        }
        contraseñasExistentes.remove(this.contraseña);
        this.contraseña = contraseña;
        contraseñasExistentes.add(contraseña);
    }

    @Override
    public String toString() {
        return super.toString() + ", Usuario: " + usuario;
    }
}

