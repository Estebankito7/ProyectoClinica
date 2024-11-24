
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
    private JFrame programadecitas;

    public MenuPaciente(CallCenter callCenter, JFrame programadecitas) {
       this.programadecitas = programadecitas;
            this.callCenter= callCenter;

        // Configuración de la ventana del menú del paciente
        setTitle("Programa de Citas");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10)); // Mantener GridLayout con 5 filas

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Crear el texto de bienvenida
        JLabel mensajeBienvenida = new JLabel("Bienvenido querido usuario, porfavor seleccione una opcion:",
                SwingConstants.CENTER);
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 14));

        // Inicializar y configurar el botón
        botonRegistrarse = new JButton("Registro");
        botonRegistrarse.setBounds(50, 50, 200, 30);
        botonRegistrarse.addActionListener(this);
        botonSolicitudCitas = new JButton("Solicitud de citas");
        botonSolicitudCitas.setBounds(50, 50, 200, 30);
        botonSolicitudCitas.addActionListener(this);
        botonCancelarCitas = new JButton("Cancelar citas");
        botonCancelarCitas.setBounds(50, 50, 200, 30);
        botonCancelarCitas.addActionListener(this);
        botonActualizacionDatos = new JButton("Actualización Datos");
        botonActualizacionDatos.setBounds(50, 50, 200, 30);
        botonActualizacionDatos.addActionListener(this);

        // Agregar los elementos al panel con GridLayout
        add(mensajeBienvenida); // Añadir el mensaje de bienvenida
        add(botonRegistrarse);
        add(botonSolicitudCitas);
        add(botonCancelarCitas);
        add(botonActualizacionDatos);

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
            ActualizacionDatos actualizaciondatos = new ActualizacionDatos(this, callCenter);
            actualizaciondatos.setVisible(true);
            setVisible(false);
        }
    }
}