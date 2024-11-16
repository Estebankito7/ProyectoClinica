import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistroPaciente extends JFrame {
  //  private JFrame menupaciente;
  
    private String nombreregistro;
    private String documentoregistro;
    private String mailregistro;
    private JPasswordField campocontraseña;
    private JButton botonRegistrarse;
    

    @SuppressWarnings("unused") //Elimina advertencias
    public RegistroPaciente(JFrame menupaciente) {
    //    this.menupaciente = menupaciente;

        // Configuración de la ventana del menú del RegistroPaciente
        setTitle("Registro de Nuevo Paciente");
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
        gbc.gridwidth = 2;
        panel.add(etiquetaTitulo, gbc);

        // Campo para el nombre
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

        // Campo para el apellido
        JLabel etiquetapellido = new JLabel("Mail:");
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(etiquetapellido, gbc);

        JTextField campomail = new JTextField(15);
        gbc.gridx = 1;
        panel.add(campomail, gbc);

        // Campo para la contraseña
        JLabel etiquetacontraseña = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(etiquetacontraseña, gbc);

        campocontraseña = new JPasswordField(15);
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
        gbc.gridy = 5;
        panel.add(botonRegistrarse, gbc);

        add(panel);

        // Darle funcion al boton Registrarse
        botonRegistrarse.addActionListener(e -> {
            // Optener el texto del campo de texto
            nombreregistro = camponombre.getText();
            documentoregistro = campodocumento.getText();
            mailregistro = campomail.getText();

            // Almacenar en una variable
            
            if (!nombreregistro.isEmpty() && !mailregistro.isEmpty() && !documentoregistro.isEmpty()) {
                
                System.out.println("Nombre ingresado es: " + nombreregistro);
                System.out.println("Documento ingresado es: " + documentoregistro);
                System.out.println("mail ingresado es: " + mailregistro);
                
                JOptionPane.showMessageDialog(menupaciente, "Su registro fue creado con exito", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
                System.out.println("Se registro con exito");
                botonRegistrarse.setVisible(false);
                camponombre.setText("");
                campodocumento.setText("");
                campomail.setText("");

            } else {
                JOptionPane.showMessageDialog(menupaciente, "Algún campo está vacio", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                System.out.println("El campo de texto esta vacio");
            }

        });
    }


    public String getNombreregistro() {
        return nombreregistro;
    }

    public void setNombreregistro(String nombreregistro) {
        this.nombreregistro = nombreregistro;
    }

    public String getDocumentoregistro() {
        return documentoregistro;
    }

    public void setDocumentoregistro(String documentoregistro) {
        this.documentoregistro = documentoregistro;
    }

    public String getMailregistro() {
        return mailregistro;
    }

    public void setMailregistro(String mailregistro) {
        this.mailregistro = mailregistro;
    }

    public JPasswordField getCampocontraseña() {
        return campocontraseña;
    }

    public void setCampocontraseña(JPasswordField campocontraseña) {
        this.campocontraseña = campocontraseña;
    }

}