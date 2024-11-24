import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroPaciente extends JFrame {
    private Paciente paciente;
    private JButton botonRegistrarse;
    private CallCenter callCenter;

    @SuppressWarnings("unused") // Elimina advertencias
    public RegistroPaciente(CallCenter callCenter, JFrame menupaciente) {
        this.callCenter = callCenter;
        paciente = new Paciente("", "", "", "", "", "");

        // Configuración de la ventana del menú del RegistroPaciente
        setTitle("Registro de Nuevo Paciente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar los elementos
        setLocationRelativeTo(null); // Centrar en la pantalla

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
        gbc.gridwidth = 2;
        panel.add(etiquetaTitulo, gbc);

        // Campo para el nombre y apellido
        JLabel etiquetanombre = new JLabel("Nombre y Apellido:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(etiquetanombre, gbc);

        JTextField camponombre = new JTextField(15);
        gbc.gridx = 1;
        panel.add(camponombre, gbc);

        // Campo para el documento
        JLabel etiquetadocumento = new JLabel("Identificación");
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(etiquetadocumento, gbc);

        JTextField campodocumento = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campodocumento, gbc);

        // Campo para el telefono
        JLabel etiquetatelefono = new JLabel("Número Telefónico");
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(etiquetatelefono, gbc);

        JTextField campotelefono = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campotelefono, gbc);

        // Campo para la direccion
        JLabel etiquetadireccion = new JLabel("Dirección");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(etiquetadireccion, gbc);

        JTextField campodireccion = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campodireccion, gbc);

        // Campo para el correo
        JLabel etiquetapellido = new JLabel("Mail:");
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(etiquetapellido, gbc);

        JTextField campomail = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campomail, gbc);

        // Campo para la contraseña
        JLabel etiquetacontraseña = new JLabel("Contraseña:");
        gbc.gridy = 6;
        gbc.gridx = 0;
        panel.add(etiquetacontraseña, gbc);

        JTextField campocontraseña = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campocontraseña, gbc);

        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });

        // Botón de registrarse
        botonRegistrarse = new JButton("Registrarse");
        gbc.gridy = 7;
        panel.add(botonRegistrarse, gbc);

        add(panel);

        // Darle funcion al boton Registrarse, cuando presiona el boton crea el paciente
        // si no existe en el listado
        botonRegistrarse.addActionListener(e -> {
            // Optener el texto del campo de texto
            paciente.Nombre = camponombre.getText();
            paciente.Documento = campodocumento.getText();
            paciente.Telefono = campotelefono.getText();
            paciente.Direccion = campodireccion.getText();
            paciente.Correo = campomail.getText();
            paciente.setContraseña(campocontraseña.getText());

            // Almacenar en una variable

            if (!paciente.Nombre.isEmpty() && !paciente.Correo.isEmpty() && !paciente.Documento.isEmpty()
                    && !paciente.Telefono.isEmpty() && !paciente.Direccion.isEmpty()
                    && !paciente.getContraseña().isEmpty()) {

                System.out.println("Nombre ingresado es: " + paciente.Nombre);
                System.out.println("Documento ingresado es: " + paciente.Documento);
                System.out.println("Telefono ingresado es: " + paciente.Telefono);
                System.out.println("Direccion ingresada es: " + paciente.Direccion);
                System.out.println("mail ingresado es: " + paciente.Correo);
                System.out.println("Contraseña ingresada es: " + paciente.getContraseña());

                Paciente revisapaciente = BuscarPaciente(paciente.Documento); // Metodo que busca paciente en lista de pacientes

                if (revisapaciente.Documento.isEmpty()) {
                    JOptionPane.showMessageDialog(menupaciente, "Su registro fue creado con exito", "Mensaje",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("Se registro con exito");
                    botonRegistrarse.setVisible(false);
                    camponombre.setText("");
                    campodocumento.setText("");
                    campotelefono.setText("");
                    campodireccion.setText("");
                    campomail.setText("");
                    campocontraseña.setText("");
                    callCenter.agregarPaciente(paciente);

                }else {
                    JOptionPane.showMessageDialog(menupaciente, "El paciente ya existe", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                System.out.println("El paciente ya existe");
                    camponombre.setText("");
                    campodocumento.setText("");
                    campotelefono.setText("");
                    campodireccion.setText("");
                    campomail.setText("");
                    campocontraseña.setText("");

                }

            } else {
                JOptionPane.showMessageDialog(menupaciente, "Algún campo está vacio", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                System.out.println("El campo de texto esta vacio");
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

}