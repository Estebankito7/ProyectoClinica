
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SolicitudCitas extends JFrame {
    // private JFrame menupaciente;
    // private JButton botonCrear;
    // private JButton botonRegresar;

    @SuppressWarnings("unused")
    public SolicitudCitas(JFrame menupaciente) {
        // this.menupaciente = menupaciente;

        // Configuración de la ventana del menú del paciente
        setTitle("Solicitud de Citas");
        setSize(400, 350);
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
        JLabel etiquetaTitulo = new JLabel("Por favor ingrese los datos requeridos", SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        panel.add(etiquetaTitulo, gbc);

        // Campo para la identificacion
        JLabel etiquetaidentificacion = new JLabel("Identificacion");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(etiquetaidentificacion, gbc);

        JTextField campoidentificacion = new JTextField(5);
        gbc.gridx = 1;
        panel.add(campoidentificacion, gbc);

        // Crear un JLabel para mostrar la opción seleccionada
        JLabel labelSeleccion = new JLabel("Opción seleccionada: Ninguna");
        gbc.gridy = 3;
        gbc.gridx = -1;
        gbc.gridwidth = 0;
        panel.add(labelSeleccion, gbc);

        // Crear un botón para Generar Cita
        JButton botonGenerarCita = new JButton("Generar Cita");
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        add(botonGenerarCita,gbc);

        // Crear un botón para abrir la ventana de selección
        JButton botonAbrir = new JButton("Seleccione su requerimiento");
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        add(botonAbrir,gbc);

        // Agregar una acción al botón
        botonAbrir.addActionListener(e -> {
            // Crear el diálogo de selección
            JDialog dialogoSeleccion = new JDialog(menupaciente, "Seleccionar Opción", true);
            dialogoSeleccion.setSize(300, 200);
            dialogoSeleccion.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar los componentes
            dialogoSeleccion.setLocationRelativeTo(menupaciente); // Centrar el diálogo respecto a la ventana principal

            // Crear un JComboBox con opciones
            String[] opciones = { "Medicina General", "Odontología", "Optometría", "Pediatría" };
            JComboBox<String> comboBox = new JComboBox<>(opciones);

            // Crear un botón para mostrar la opción seleccionada
            JButton botonMostrar = new JButton("Mostrar Selección");

            // Agregar una acción al botón
            botonMostrar.addActionListener(event -> {
                // Obtener la opción seleccionada
                String seleccion = (String) comboBox.getSelectedItem();
                // Mostrar la opción seleccionada en un mensaje
                JOptionPane.showMessageDialog(dialogoSeleccion, "Has seleccionado: " + seleccion);
                // Actualizar el JLabel en la ventana principal
                labelSeleccion.setText("Opción seleccionada: " + seleccion);
                // Cerrar el diálogo
                dialogoSeleccion.dispose();
            });

            // Crear un panel y agregar los componentes
            JPanel panel1 = new JPanel();
            panel1.add(comboBox);
            panel1.add(botonMostrar);

            // Agregar el panel al diálogo
            dialogoSeleccion.getContentPane().add(panel1);

            // Hacer visible el diálogo
            dialogoSeleccion.setVisible(true);
        });

        // Agregar el botón al marco principal
       // GridBagConstraints gbc1 = new GridBagConstraints();
       // gbc1.insets = new Insets(10, 10, 10, 10); // Margen entre los elementos
       // gbc1.fill = GridBagConstraints.HORIZONTAL;
       // gbc1.gridx = 0;
       // gbc1.gridy = 1;
       // add(botonAbrir,gbc1);
        

        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });

        // Texto
        // JLabel label = new JLabel("¡Ingrese los datos seleccionados!");
        // label.setBounds(0, 50, 200, 30);
        // add(label);
        add(panel);
    }
}