import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioCambio extends JFrame {
    private JTextField nombreField, documentoField, telefonoField, direccionField, correoField, contraseñaField;
    private JButton cambiarDatosButton;

    public FormularioCambio(Paciente paciente, JFrame menuPaciente) {
        setTitle("Cambiar Datos del Paciente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre elementos
        gbc.fill = GridBagConstraints.HORIZONTAL; // Solo llenar horizontalmente

        // Asegura que los componentes ocupen todo el espacio horizontal
        gbc.weightx = 1.0;

        // Añadir etiqueta principal en la parte superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // La etiqueta ocupa las dos columnas
        JLabel tituloLabel = new JLabel("Por favor ingrese los datos a cambiar", JLabel.CENTER);
        panel.add(tituloLabel, gbc);

        // Crear y agregar componentes con campos de texto más largos
        addLabelAndField(panel, gbc, "Nombre:", nombreField = new JTextField(20), 1);
        addLabelAndField(panel, gbc, "Documento:", documentoField = new JTextField(20), 2);
        addLabelAndField(panel, gbc, "Teléfono:", telefonoField = new JTextField(20), 3);
        addLabelAndField(panel, gbc, "Dirección:", direccionField = new JTextField(20), 4);
        addLabelAndField(panel, gbc, "Correo:", correoField = new JTextField(20), 5);
        addLabelAndField(panel, gbc, "Contraseña:", contraseñaField = new JTextField(20), 6);

        // Botón centrado
        cambiarDatosButton = new JButton("Cambiar Datos");
        gbc.gridx = 0;
        gbc.gridy = 7;  // Se desplaza a la fila 6
        gbc.gridwidth = 2;
        panel.add(cambiarDatosButton, gbc);

        cambiarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String documento = documentoField.getText();
                String telefono = telefonoField.getText();
                String direccion = direccionField.getText();
                String correo = correoField.getText();
                String contraseña = contraseñaField.getText();

                if (nombre.isEmpty() || documento.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || correo.isEmpty() || contraseña.isEmpty()){
                    JOptionPane.showMessageDialog(FormularioCambio.this, "Por favor ingrese todos los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    paciente.setNombre(nombre);
                    paciente.setDocumento(documento);
                    paciente.setTelefono(telefono);
                    paciente.setDireccion(direccion);
                    paciente.setCorreo(correo);
                    paciente.setContraseña(contraseña);
                    JOptionPane.showMessageDialog(FormularioCambio.this, "Sus datos han sido actualizados", "Información", JOptionPane.INFORMATION_MESSAGE);
                    paciente.Imprimir();
                }
            }
        });

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menuPaciente.setVisible(true);
            }
        });
    }

    private void addLabelAndField(JPanel panel, GridBagConstraints gbc, String label, JTextField field, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

}
