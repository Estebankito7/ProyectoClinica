import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CallCenter {

    private List<Cita> listaCitas;
    private List<Paciente> listaPacientes;
    private List<Medico> listaMedicos;
    private List<Especialista> listaEspecialistas;
    private Calendario calendario;

    private List<Admisionista> listaAdmisionista;
    private String Nombre;
    private String Documento;
    private String Mail;
    

    public CallCenter() {
        listaCitas = new ArrayList<>();
        listaPacientes = new ArrayList<>();
        listaMedicos = new ArrayList<>();
        listaEspecialistas = new ArrayList<>();
        listaAdmisionista = new ArrayList<>();
        calendario = new Calendario();
        
    }

    public void agregarCita(Cita cita) {
        listaCitas.add(cita);
    }

    public void agregarPaciente(Paciente pacient) {
      
        listaPacientes.add(pacient);
        
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
    public void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Call Center Informacion.txt", true))) {
            writer.write("=== Lista de Citas ===\n");
            for (Cita cita : listaCitas) {
                writer.write(cita.toString() + "\n");
            }

            writer.write("\n=== Lista de Usuarios ===\n");
            for (Persona usuario : listaPacientes) {
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
      public void AgregarListaMedicos(){
        Medico medico = new Medico("Mario Correa", "1.125.345.321","3176654876","Calle 23 # 4-56", "mariocorrea@gmail.com","R2478","Disponible");;
        agregarMedico(medico);
        medico = new Medico("Diego Bejarano", "94.786.432","3164453583","Carrera 1 # 23-67", "diegobejarano@gmail.com","R5734","Disponible");
        agregarMedico(medico);
        medico = new Medico("Francisco Gonzalez", "3.564.786","3125567863","Calle 45 # 35-66", "franciscogonzalez@gmail.com","R4578","Disponible");
        agregarMedico(medico);
        medico = new Medico("Pedro Ochoa", "94.565.434","3129984456","Avenida 3 # 5-78", "pedroochoa@gmail.com","R2734","Disponible");
        agregarMedico(medico);
      }

      public void AgregarListaEspecialistas(){
        Especialista especialista = new Especialista("Jhonn Orozco","94050302","3137658748","Carrera 70 # 23-54","jhonnorozco@gmail.com","Optometría","R3456","Disponible");;
        agregarEspecialista(especialista);
        especialista = new Especialista("Carlos Rodriguez", "93485738","3174566534","Calle 9b #  3-12","carlosrodriguez@gmail.com","Optometría","R2467","Disponible");
        agregarEspecialista(especialista);
        especialista = new Especialista("Luis Paz", "93483654","3174566534","Calle 34 #  2-45","luispaz@gmail.com","Odontología","R6745","Disponible");
        agregarEspecialista(especialista);
        especialista = new Especialista("Jorge Cardona", "94485445","3194566533","Calle 6 #  12-12","jorgecardona@gmail.com","Odontología","R8574","Disponible");
        agregarEspecialista(especialista);
        especialista = new Especialista("Maria Benavidez", "95485734","3124546531","Carrea 5b #  34-12","mariabenavidez@gmail.com","Pediatría","R9045","Disponible");
        agregarEspecialista(especialista);
        especialista = new Especialista("Claudia Tabares", "93485738","3154566678","Calle 21 #  56-12","claudiatabares@gmail.com","Pediatría","R8924","Disponible");
        agregarEspecialista(especialista);
        System.out.println(""+ especialista.Nombre+" , "+ especialista.Documento+" , "+especialista.getEspecialidad());
    
      }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

}
    
