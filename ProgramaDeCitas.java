import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramaDeCitas extends JFrame implements ActionListener {
    private JButton botonPaciente;
    private JButton botonAdmisionista;
    private JLabel tituloPrincipal;
    private JLabel tituloSecundario;
    private JLabel imagenLabel;
    private CallCenter callCenter;

    public ProgramaDeCitas() {
        // Crear una instancia de CallCenter
        callCenter = new CallCenter();
        callCenter.AgregarListaMedicos();
        callCenter.AgregarListaEspecialistas();

        // Configuración de la ventana
        setTitle("Programa de citas");
        setSize(400, 400); // Ajustar tamaño para incluir la imagen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un panel para los títulos e imagen
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS)); // Organizar títulos y la imagen verticalmente
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir márgenes

        // Título principal
        tituloPrincipal = new JLabel("Programa de Citas Médicas", SwingConstants.CENTER);
        tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
        tituloPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente

        // Cargar imagen debajo del título principal
        ImageIcon imagen = new ImageIcon("C:\\Users\\USUARIO\\Desktop\\logo.jpg"); // Asegúrate de que la ruta sea válida
        Image imagenEscalada = imagen.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Ajustar tamaño de la imagen
        imagen = new ImageIcon(imagenEscalada);
        imagenLabel = new JLabel(imagen);
        imagenLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente
        
        // Título secundario
        tituloSecundario = new JLabel("Seleccione el tipo de usuario", SwingConstants.CENTER);
        tituloSecundario.setFont(new Font("Arial", Font.PLAIN, 16));
        tituloSecundario.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente

    
        // Agregar títulos e imagen al panel superior
        panelSuperior.add(tituloPrincipal);
        panelSuperior.add(Box.createVerticalStrut(10)); // Espacio entre título principal y secundario
        panelSuperior.add(tituloSecundario);
        panelSuperior.add(Box.createVerticalStrut(15)); // Espacio entre títulos e imagen
        panelSuperior.add(imagenLabel);

        // Agregar el panel superior en la parte superior
        add(panelSuperior, BorderLayout.NORTH);

        // Crear el panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Crear y agregar los botones al panel
        botonPaciente = new JButton("Paciente");
        botonAdmisionista = new JButton("Admisionista");

        // Agregar listeners a los botones
        botonPaciente.addActionListener(this);
        botonAdmisionista.addActionListener(this);

        // Agregar los botones al panel de botones
        panelBotones.add(botonPaciente);
        panelBotones.add(botonAdmisionista);

        // Agregar el panel de botones en el centro
        add(panelBotones, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonPaciente) {
            // Crear y mostrar la ventana del paciente
            MenuPaciente menupaciente = new MenuPaciente(callCenter, ProgramaDeCitas.this);
            menupaciente.setVisible(true);
            // Ocultar la ventana principal
            setVisible(false);
        } else if (e.getSource() == botonAdmisionista) {
            // Mostrar el menú del admisionista y esconder esta ventana
            MenuAdmisionista menuadmisionista = new MenuAdmisionista(this, callCenter);
            menuadmisionista.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgramaDeCitas programa = new ProgramaDeCitas();
            programa.setVisible(true);
        });
    }
}
