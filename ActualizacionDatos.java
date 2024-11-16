import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActualizacionDatos extends JFrame {
 //   private JFrame menupaciente;
 //   private JButton botonCrear;
 //   private JButton botonRegresar;

    public ActualizacionDatos(JFrame menupaciente) {
  //      this.menupaciente = menupaciente;

        // Configuración de la ventana del menú del paciente
        setTitle("Actualizacion de datos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Añadir un listener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar la ventana anterior al cerrar esta
                menupaciente.setVisible(true);
            }
        });



        //Texto
        JLabel label = new JLabel("¡Ingrese los datos a actualizar!");
        label.setBounds(0, 50, 200, 30);
        add(label);
    }
}