
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SolicitudCitas extends JFrame {
    private String seleccion;
    private Paciente paciente;
    private CallCenter callCenter;
    private JFrame menupaciente;
    private Medico medico;
    private Especialista especialista;
    public String warning;
    private JTextField campoidentificacion;
    private JPasswordField campocontraseña;
    private JLabel labelSeleccion;

    @SuppressWarnings("unused")
    public SolicitudCitas(CallCenter callCenter, JFrame menupaciente) {
        this.menupaciente = menupaciente;
        this.callCenter = callCenter;
        warning = "null";
        seleccion = "";

        // Configuración de la ventana del menú del paciente
        setTitle("Solicitud de Citas");
        setSize(400, 300);
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
        JLabel etiquetaidentificacion = new JLabel("Identificación");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(etiquetaidentificacion, gbc);

        campoidentificacion = new JTextField(5);
        gbc.gridx = 1;
        panel.add(campoidentificacion, gbc);

        // Campo para la contraseña
        JLabel etiquetacontraseña = new JLabel("Contraseña");
        gbc.gridy = 2;
        gbc.gridx = -1;
        gbc.gridwidth = 1;
        panel.add(etiquetacontraseña, gbc);

        campocontraseña = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(campocontraseña, gbc);

        // Crear un JLabel para mostrar la opción seleccionada
        labelSeleccion = new JLabel("Opción seleccionada: Ninguna");
        gbc.gridy = 3;
        gbc.gridx = -1;
        gbc.gridwidth = 0;
        panel.add(labelSeleccion, gbc);

        // Crear un botón para Generar Cita
        JButton botonGenerarCita = new JButton("Generar Cita");
        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        add(botonGenerarCita, gbc);

        // Crear un botón para abrir la ventana de selección
        JButton botonAbrir = new JButton("Seleccione su requerimiento");
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        add(botonAbrir, gbc);

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

        // Darle funcion al boton Generar Cita
        botonGenerarCita.addActionListener(e -> {
            // Optener el texto del campo de texto
            String identificapaciente = campoidentificacion.getText();
            char[] entradacontraseña = campocontraseña.getPassword();
            String identificacontraseña = new String(entradacontraseña);
            boolean revisioncontraseña = false;

            System.out.println("Paciente ingresado es: " + identificapaciente);
            System.out.println("Contraseña ingresada es: " + identificacontraseña);

            // Almacenar en una variable

            if (!identificapaciente.isEmpty() && !identificacontraseña.isEmpty() && seleccion != "") {

                paciente = BuscarPaciente(identificapaciente); // Metodo que busca paciente en lista de pacientes

                if (!paciente.Documento.isEmpty()) {

                    revisioncontraseña = checkcontraseña(identificacontraseña, paciente); // Metodo que chequea
                                                                                          // contraseña de paciente
                    if (revisioncontraseña) {

                        if (seleccion.equals("Medicina General")) { // Seleccion de medico medicina general
                            medico = SeleccionarMedico();
                            especialista = new Especialista("", "", "", "", "", "", "", "");
                            if (medico.Nombre.isEmpty()) {
                                warning = "error medico";
                                System.out.println(" No se puede generar porque no hay medicos disponibles");
                                JOptionPane.showMessageDialog(menupaciente,
                                        "No se puede generar porque no hay medicos disponibles",
                                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                                resetcampos();
                            }
                        } else {
                            especialista = SeleccionarEspecialista(seleccion); // Seleccion medico especialista
                            medico = new Medico("", "", "", "", "", "", "");
                            if (especialista.Nombre.isEmpty()) {
                                warning = "error especialista";
                                System.out.println(" No se puede generar porque no hay especialista disponibles");
                                JOptionPane.showMessageDialog(menupaciente,
                                        "No se puede generar porque no hay medicos disponibles",
                                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                                resetcampos();
                            }
                        }
                        if (!callCenter.getListaCitas().isEmpty()) {
                            
                            System.out.println("Revision de cita paciente");
                            Cita cita = new Cita("", "", "", seleccion, medico, especialista, paciente);
                            Cita revision = cita;
                            boolean confirm= false;
                            for (int i = 0; i < callCenter.getListaCitas().size(); i++) {
                                revision = callCenter.getListaCitas().get(i);
                                
                                if (revision.getPaciente().Documento.equals(identificapaciente)) {
                                    System.out.println("Encontro paciente en citas");
                                    if (revision.getArea().equals(seleccion)) {
                                        System.out.println(
                                                " No se puede generar la cita porque el paciente ya tiene una cita asignada");
                                        JOptionPane.showMessageDialog(menupaciente,
                                                "No se puede generar la cita porque el paciente ya tiene una cita asignada",
                                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                                                confirm=true;
                                       resetcampos();
                                       break;
                                    }
                                }
                            }
                            System.out.println(""+confirm);
                            if (confirm ==false){
                                GeneraCita(cita);
                            }

                        }else{
                            System.out.println(" Se ha generado una nueva cita con:" + seleccion);
                            System.out.println("Medico:" + medico.Nombre);
                            System.out.println("Especialista:" + especialista.Nombre);
                            System.out.println("");
                            Cita cita = new Cita("", "", "", seleccion, medico, especialista, paciente);
                            GeneraCita(cita);
                            
                        }
                        

                    } else {

                        System.out.println(" Contraseña incorrecta");
                        JOptionPane.showMessageDialog(menupaciente,
                                "Contraseña incorrecta",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                        resetcampos();

                    }

                    

                } else {
                    System.out.println(" No se puede generar la cita porque el paciente no existe");
                    JOptionPane.showMessageDialog(menupaciente,
                            "No se puede generar la cita porque el paciente no existe. Regístrese en el menú anterior",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    resetcampos();
                }

                System.out.println("check contraseña es: " + revisioncontraseña);
                System.out.println("Entro");
                System.out.println("warning es :" + warning);
                System.out.println("indentifica es :" + identificapaciente);
                System.out.println("contraseña es :" + identificacontraseña);
                System.out.println("seleccion es :" + seleccion);
                System.out.println("paciente es :" + paciente);

            } else {
                JOptionPane.showMessageDialog(menupaciente,
                        "Ingrese su identificacion de Paciente y Contraseña, seleccione el tipo de servicio que requiere, si no se ha registrado, regístrese en el menu anterior",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                System.out.println("Ingrese su identificacion de Paciente y Contraseña");
                resetcampos();
            }

        });

    }

    private Paciente BuscarPaciente(String userId) {
        Paciente respuesta = new Paciente("", "", "", "", "", "");
        List<Paciente> users = callCenter.getListaPacientes();

        for (int i = 0; i < users.size(); i++) {
            Paciente revision = users.get(i);
            if (revision.Documento.equals(userId)) {
                respuesta = revision;
            }
        }
        return respuesta;
    }

    private boolean checkcontraseña(String identificacontraseña, Paciente paciente) {
        System.out.println("contraseña pacientes es: " + paciente.getContraseña());
        boolean respuesta = false;
        if (!identificacontraseña.isEmpty()) {
            if (identificacontraseña.equals(paciente.getContraseña())) {
                respuesta = true;
                return respuesta;
            } else
                return false;
        }
        return respuesta;
    }

    private Medico SeleccionarMedico() {
        Medico respuesta = new Medico("", "", "", "", "", "", "");
        List<Medico> medicos = callCenter.getListaMedicos();

        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            if (medico.getEstado().equals("Disponible")) {
                respuesta = medico;
                break;
            }
        }
        System.out.println("medico: " + respuesta.Nombre);
        return respuesta;
    }

    private Especialista SeleccionarEspecialista(String seleccion) {
        Especialista respuesta = new Especialista("", "", "", "", "", "", "", "");
        List<Especialista> especialistas = callCenter.getListaEspecialistas();

        for (int i = 0; i < especialistas.size(); i++) {
            Especialista especialista = especialistas.get(i);
            if (especialista.getEspecialidad().equals(seleccion)) {
                if (especialista.getEstado().equals("Disponible")) {
                    respuesta = especialista;
                }
            }
        }
        return respuesta;
    }

    private void resetcampos(){
        campoidentificacion.setText("");
        campocontraseña.setText("");
        seleccion = "";
        labelSeleccion.setText("Opción seleccionada: " + seleccion);
    } 

    private void GeneraCita(Cita cita){
        callCenter.agregarCita(cita);
        medico.setEstado("No Disponible");
        especialista.setEstado("No Disponible");
        JOptionPane.showMessageDialog(menupaciente, "Cita creada con exito", "Mensaje",
                JOptionPane.WARNING_MESSAGE);
        resetcampos();
    }
}