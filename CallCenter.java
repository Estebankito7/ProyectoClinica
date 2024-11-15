import java.io.*;
import java.util.ArrayList;
import java.util.List;
import InterfazGrafica.RegistroPaciente;

public class CallCenter {

    private List<Cita> listaCitas;
    private List<Paciente> listaUsuarios;
    private List<Medico> listaMedicos;
    private List<Especialista> listaEspecialistas;
    private String Nombre;
    private String Documento;
    private String Mail;

    public CallCenter() {
        listaCitas = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        listaMedicos = new ArrayList<>();
        listaEspecialistas = new ArrayList<>();

    }

    public void agregarCita(Cita cita) {
        listaCitas.add(cita);
    }

    public void agregarUsuario(Paciente usuario) {
        Paciente paciente = new Paciente(Nombre, Documento, Mail, null, null);
        listaUsuarios.add(paciente);
        
    }

    public void agregarMedico(Medico medico) {
        listaMedicos.add(medico);
    }

    public void agregarEspecialista(Especialista especialista) {
        listaEspecialistas.add(especialista);
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public List<Paciente> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public List<Especialista> getListaEspecialistas() {
        return listaEspecialistas;
    }

    public void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Call Center Informacion.txt", true))) {
            writer.write("=== Lista de Citas ===\n");
            for (Cita cita : listaCitas) {
                writer.write(cita.toString() + "\n");
            }

            writer.write("\n=== Lista de Usuarios ===\n");
            for (Persona usuario : listaUsuarios) {
                writer.write(usuario.toString() + "\n");
            }

            writer.write("\n=== Lista de Medicos ===\n");
            for (Medico medico : listaMedicos) {
                writer.write(medico.toString() + "\n");
            }

            writer.write("\n=== Lista de Especialistas ===\n");
            for (Especialista especialista : listaEspecialistas) {
                writer.write(especialista.toString() + "\n");
            }

            writer.write("\n=========================\n");
            System.out.println("Datos guardados en data.txt correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public void CreaRegistroPaciente() {
        RegistroPaciente reg1 = new RegistroPaciente(null);
        Nombre = reg1.getNombreregistro();
        Documento = reg1.getDocumentoregistro();
        Mail = reg1.getMailregistro();

    }
}
