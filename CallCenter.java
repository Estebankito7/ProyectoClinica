import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CallCenter {

    private List<Cita> listaCitas;
    private List<Paciente> listaPacientes;
    private List<Medico> listaMedicos;
    private List<Especialista> listaEspecialistas;
    private List<Admisionista> listaAdmisionista;
    private Calendario calendario;

    public CallCenter() {
        listaCitas = new ArrayList<>();
        listaPacientes = new ArrayList<>();
        listaMedicos = new ArrayList<>();
        listaEspecialistas = new ArrayList<>();
        listaAdmisionista = new ArrayList<>();
        calendario = new Calendario();
    }

    // Métodos para agregar elementos a las listas
    public void agregarCita(Cita cita) {
        listaCitas.add(cita);
    }

    public void agregarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        listaMedicos.add(medico);
    }

    public void agregarEspecialista(Especialista especialista) {
        listaEspecialistas.add(especialista);
    }

    public void cancelarCita(CallCenter callCenter, Cita cita) {
        if (callCenter.listaCitas.remove(cita)) {
            System.out.println("Cita cancelada exitosamente.");
        } else {
            System.out.println("La cita no existe en el sistema.");
        }
    }


    // Agregar un admisionista a la lista
    public boolean agregarAdmisionista(Admisionista admisionista) {
        for (Admisionista existente : listaAdmisionista) {
            if (existente.getUsuario().equals(admisionista.getUsuario())) {
                System.out.println("El usuario ya existe: " + admisionista.getUsuario());
                return false;
            }
        }
        listaAdmisionista.add(admisionista);
        System.out.println("Admisionista registrado: " + admisionista.getUsuario());
        return true;
    }

    // Validar credenciales de un admisionista
    public boolean validarAdmisionista(String usuario, String contraseña) {
        for (Admisionista admisionista : listaAdmisionista) {
            if (admisionista.getUsuario().equals(usuario) && admisionista.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    // Métodos para obtener listas
    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public List<Especialista> getListaEspecialistas() {
        return listaEspecialistas;
    }

    public List<Admisionista> getListaAdmisionista() {
        return listaAdmisionista;
    }

    // Inicializar admisionistas predefinidos
    public void inicializarAdmisionistas() {
        agregarAdmisionista(new Admisionista("Carlos Lopez", "12345678", "3171234567", "Calle 10 # 5-30", "carlos@gmail.com", "carlos", "89030346"));
        agregarAdmisionista(new Admisionista("Ana Perez", "87654321", "3157654321", "Carrera 15 # 45-60", "ana@gmail.com", "ana", "89030345"));
        agregarAdmisionista(new Admisionista("Luis Ramirez", "11223344", "3109876543", "Avenida 30 # 20-50", "luis@gmail.com", "luis", "89030344"));
    }

    // Inicializar médicos predefinidos
    public void AgregarListaMedicos() {
        agregarMedico(new Medico("Mario Correa", "1.125.345.321", "3176654876", "Calle 23 # 4-56", "mariocorrea@gmail.com", "R2478", "Disponible"));
        agregarMedico(new Medico("Diego Bejarano", "94.786.432", "3164453583", "Carrera 1 # 23-67", "diegobejarano@gmail.com", "R5734", "Disponible"));
        agregarMedico(new Medico("Francisco Gonzalez", "3.564.786", "3125567863", "Calle 45 # 35-66", "franciscogonzalez@gmail.com", "R4578", "Disponible"));
        agregarMedico(new Medico("Pedro Ochoa", "94.565.434", "3129984456", "Avenida 3 # 5-78", "pedroochoa@gmail.com", "R2734", "Disponible"));
    }

    // Inicializar especialistas predefinidos
    public void AgregarListaEspecialistas() {
        agregarEspecialista(new Especialista("Jhonn Orozco", "94050302", "3137658748", "Carrera 70 # 23-54", "jhonnorozco@gmail.com", "Optometría", "R3456", "Disponible"));
        agregarEspecialista(new Especialista("Carlos Rodriguez", "93485738", "3174566534", "Calle 9b # 3-12", "carlosrodriguez@gmail.com", "Optometría", "R2467", "Disponible"));
        agregarEspecialista(new Especialista("Luis Paz", "93483654", "3174566534", "Calle 34 # 2-45", "luispaz@gmail.com", "Odontología", "R6745", "Disponible"));
        agregarEspecialista(new Especialista("Jorge Cardona", "94485445", "3194566533", "Calle 6 # 12-12", "jorgecardona@gmail.com", "Odontología", "R8574", "Disponible"));
        agregarEspecialista(new Especialista("Maria Benavidez", "95485734", "3124546531", "Carrea 5b # 34-12", "mariabenavidez@gmail.com", "Pediatría", "R9045", "Disponible"));
        agregarEspecialista(new Especialista("Claudia Tabares", "93485738", "3154566678", "Calle 21 # 56-12", "claudiatabares@gmail.com", "Pediatría", "R8924", "Disponible"));
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
}
