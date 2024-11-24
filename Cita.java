import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Cita extends JFrame {

    private String fecha;
    private String hora;
    private String consultorio;
    private String area;
    private Medico medico;
    private Paciente paciente;
    private Especialista especialista;
    // Constructor
    public Cita(String fecha, String hora, String consultorio, String area, Medico medico, Especialista especialista,
            Paciente paciente) {

        this.fecha = fecha;
        this.hora = hora;
        this.consultorio = consultorio;
        this.area = area;
        this.medico = medico;
        this.paciente = paciente;
        this.especialista = especialista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", consultorio='" + consultorio + '\'' +
                ", medico=" + medico +
                ", paciente=" + paciente +
                '}';
    }

    public void Imprimir() {
        System.out.println("**********");
        System.out.println(fecha);
        System.out.println(hora);
        System.out.println(consultorio);
        System.out.println(area);
        System.out.println(medico.Nombre);
        System.out.println(especialista.Nombre);
        System.out.println(paciente.Nombre);
        System.out.println("**********");
        System.out.println("");

    }
public void ConfirmaCita (){
    String fechaCita = "2024-11-25";
    String horaCita = "10:00 AM";

    // Crear el mensaje con los datos del paciente
    String mensaje = "<html>Datos de la Cita:<br>" +
            "    Paciente: " + paciente.Nombre + "<br>" +
            "    Fecha: " + fechaCita + "<br>" +
            "    Hora: " + horaCita + "<br>" +
            "    Doctor: " + medico.Nombre + "<br>" +
            "    Especialista: " + especialista.Nombre + "</html>";

    // Configuración de la ventana de Confirmacion de cita

            setTitle("Cita generada con exito");
            setSize(300, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar los elementos
            setLocationRelativeTo(null); // Centrar en la pantalla

            // Centrar la ventana en la pantalla
            setLocationRelativeTo(null);

            // Crear un panel con GridBagLayout para posicionar los elementos
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Margen entre los elementos
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Etiqueta de instrucciones
            JLabel etiquetaTitulo = new JLabel("Cita generada con exito", SwingConstants.CENTER);
            etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 14));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            panel.add(etiquetaTitulo, gbc);

            JLabel nuevacita = new JLabel(mensaje);
            gbc.gridy = 1;
            gbc.gridwidth = 0;
            panel.add(nuevacita, gbc);

            // Mostrar la ventana
            setVisible(true);
            add(panel);

}

}
