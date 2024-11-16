import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;

public class ProgramaDeCitas extends JFrame implements ActionListener {
    private JButton botonPaciente;
    private JButton botonAdmisionista;
    private JButton botonlistaPacientes;
    private JButton botonlistaCitas;
    private JLabel titulo;
    private CallCenter callCenter;

    public ProgramaDeCitas() {
        // this.callcenter = callcenter;
        callCenter = new CallCenter();
        // Configuración de la ventana
        setTitle("Programa de citas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Crear y agregar el subtítulo en la parte superior
        titulo = new JLabel("Seleccione el tipo de usuario", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        // Crear el panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Crear y agregar los botones al panel
        botonPaciente = new JButton("Paciente");
        botonAdmisionista = new JButton("Admisionista");
        botonlistaPacientes = new JButton("Lista de Pacientes");
        botonlistaCitas = new JButton("Lista de Citas");

        // Agregar listeners a los botones
        botonPaciente.addActionListener(this);
        botonAdmisionista.addActionListener(this);
        botonlistaPacientes.addActionListener(this);
        botonlistaCitas.addActionListener(this);

        // Agregar los botones al panel de botones
        panelBotones.add(botonPaciente);
        panelBotones.add(botonAdmisionista);
        panelBotones.add(botonlistaPacientes);
        panelBotones.add(botonlistaCitas);

        // Agregar el panel de botones en el centro
        add(panelBotones, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == openSecondButton) {
        if (e.getSource() == botonPaciente) {
            // Crear y mostrar la segunda ventana
            MenuPaciente menupaciente = new MenuPaciente(callCenter, ProgramaDeCitas.this);
            menupaciente.setVisible(true);
            // Ocultar la ventana principal
            setVisible(false);
        } else if (e.getSource() == botonAdmisionista) {

            // Mostrar el menú del admisionista y esconder esta ventana
            MenuAdmisionista menuadmisionista = new MenuAdmisionista(this);
            menuadmisionista.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == botonlistaPacientes) {

            // Mostrar el menú del admisionista y esconder esta ventana

            List<Paciente> users = callCenter.getListaPacientes();
            if (users.size() == 0) {
                System.out.println("No hay usuarios para mostrar");
            }
            for (int i = 0; i < users.size(); i++) {
                System.out.print("" + (i + 1));
                users.get(i).Imprimir();

            }
        } else if (e.getSource() == botonlistaCitas) {

            // Mostrar el menú del admisionista y esconder esta ventana

            List<Cita> citas = callCenter.getListaCitas();
            if (citas.size() == 0) {
                System.out.println("No hay citas para mostrar");
            }
            for (int i = 0; i < citas.size(); i++) {
                System.out.print("" + (i + 1));
                citas.get(i).Imprimir();

            }
        }
    }
}
