
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SolicitudCitas extends JFrame {
        private String seleccion;
       private String identificapaciente;
       private CallCenter callCenter;
       private JFrame menupaciente;


    @SuppressWarnings("unused")
    public SolicitudCitas(CallCenter callCenter, JFrame menupaciente) {
         this.menupaciente = menupaciente;
         this.callCenter=callCenter;

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
                seleccion = (String) comboBox.getSelectedItem();
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

        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });

        add(panel);

        // Darle funcion al boton Registrarse
        botonGenerarCita.addActionListener(e -> {
            // Optener el texto del campo de texto
            identificapaciente = campoidentificacion.getText();
            
            // Almacenar en una variable
            
            if (!identificapaciente.isEmpty()) {
                
                System.out.println("Paciente ingresado es: " + identificapaciente);

                Paciente paciente =BuscarPaciente(identificapaciente);
                Medico medico = new Medico("Pedro","","","","","");

                if (paciente.Documento.isEmpty()) {
                    System.out.println(" No se puede generar la cita porque el paciente no existe");
                    JOptionPane.showMessageDialog(menupaciente, "No se puede generar la cita porque el paciente no existe", "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                 } else {
                    
                    System.out.println(" Se ha generado una nueva cita con:"+ seleccion);
                    System.out.println("");
                    Cita cita = new Cita ("","","",medico,seleccion,paciente);
                    callCenter.agregarCita(cita);
                    JOptionPane.showMessageDialog(menupaciente, "Cita creada con exito", "Mensaje",
                            JOptionPane.WARNING_MESSAGE);
                 }
                }else {
                    JOptionPane.showMessageDialog(menupaciente, "Ingrese su identificaion de Paciente", "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("Ingrese su identificaion de Paciente");
                }

            });
        }

    private Paciente BuscarPaciente(String userId) {
        Paciente respuesta = new Paciente("","","","","");
        List<Paciente> users = callCenter.getListaPacientes();
  
        for (int i = 0; i < users.size(); i++) {
           Paciente revision = users.get(i);
           if (revision.Documento.equals(userId)) {
              respuesta = revision;
           }
        }
        return respuesta;
     }
}