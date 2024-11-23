
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CancelarCitas extends JFrame {

    public CancelarCitas(JFrame menupaciente, CallCenter callCenter) {

        // Configuración de la ventana del menú del paciente
        setTitle("Cancelar Citas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        //Panel del titulo
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Cancelar Cita");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel);

        //Panel del formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("Identificación:");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField();

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        //Panel para el botón 
        JPanel buttonPanel = new JPanel();
        JButton cancelButton = new JButton("Cancelar Cita");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(cancelButton);

        // Agregar los paneles al marco principal
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Mostrar la ventana
        setVisible(true);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto de los campos de entrada
                String identificacion = idField.getText();
                String password = new String(passwordField.getPassword());

                for( Cita cita : callCenter.getListaCitas() ){
                    System.out.println(cita.getPaciente().getDocumento().equals(identificacion));
                    if(cita.getPaciente().getDocumento().equals(identificacion)){
                        callCenter.cancelarCita(callCenter, cita);
                    } 
                }
            }
        });

        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });
    }
}
