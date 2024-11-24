
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuPaciente extends JFrame implements ActionListener {
    // private JButton openThirdButton;
    private JButton botonRegistrarse;
    private JButton botonSolicitudCitas;
    private JButton botonCancelarCitas;
    private JButton botonActualizacionDatos;
    private CallCenter callCenter;

    public MenuPaciente(CallCenter callCenter, JFrame programadecitas) {
       this.callCenter= callCenter;

        // Configuración de la ventana del menú del paciente
        setTitle("Menu Paciente");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

         // Crear el texto de bienvenida
         JLabel mensajeBienvenida = new JLabel("Bienvenido al menu de paciente, por favor seleccione una opcion:",SwingConstants.CENTER);
         mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 14));
         add(mensajeBienvenida,BorderLayout.NORTH);


        // Crear el panel de botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,10,10));

        // Inicializar y configurar el botón
        botonRegistrarse = new JButton("Registro Paciente");
        botonSolicitudCitas = new JButton("Solicitud de citas");
        botonCancelarCitas = new JButton("Cancelar citas");
        botonActualizacionDatos = new JButton("Actualización Datos");

        panel.add(botonRegistrarse);
        panel.add(botonSolicitudCitas);
        panel.add(botonCancelarCitas);
        panel.add(botonActualizacionDatos);

        // Añadir margenes al panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

         // Añadir el panel de botones al centro de la ventana
         add(panel, BorderLayout.CENTER);


        // Agregar listeners a los botones
        botonRegistrarse.addActionListener(this);
        botonSolicitudCitas.addActionListener(this);
        botonCancelarCitas.addActionListener(this);
        botonActualizacionDatos.addActionListener(this);

        setVisible(true);

        
        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                programadecitas.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if (e.getSource() == botonRegistrarse) {
            // Crear y mostrar la tercera ventana
            RegistroPaciente registropaciente = new RegistroPaciente(callCenter,MenuPaciente.this);
            registropaciente.setVisible(true);
            // Ocultar la segunda ventana
            setVisible(false);
        }else if(e.getSource() == botonSolicitudCitas) {
            
            // Mostrar el menú de Solicitar Citas y esconder esta ventana
            SolicitudCitas solicitudcitas = new SolicitudCitas(callCenter, MenuPaciente.this);
            solicitudcitas.setVisible(true);
            setVisible(false);
        }else if(e.getSource() == botonCancelarCitas) {
            
            // Mostrar el menú del admisionista y esconder esta ventana
            CancelarCitas cancelarcitas = new CancelarCitas(this, callCenter);
            cancelarcitas.setVisible(true);
            setVisible(false);
        }else if(e.getSource() == botonActualizacionDatos) {
            
            // Mostrar el menú de Actualizar Datos y esconder esta ventana
            ActualizacionDatos actualizaciondatos = new ActualizacionDatos(this);
            actualizaciondatos.setVisible(true);
            setVisible(false);
        }
    }
}