package InterfazGrafica;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ProgramaDeCitas extends JFrame implements ActionListener {
    // private JButton openSecondButton;
    private JButton botonPaciente;
    private JButton botonAdmisionista;
    private JLabel titulo;

    public ProgramaDeCitas() {
        // Configuración de la ventana
        setTitle("Programa de citas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Crear y agregar el subtítulo en la parte superior
        titulo = new JLabel("Seleccione el tipo de usuario", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        // Crear el panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Crear y agregar los botones al panel
        botonPaciente = new JButton("Paciente");
        botonAdmisionista = new JButton("Admisionista");

        // Agregar listeners a los botones
        botonPaciente.addActionListener(this);
        botonAdmisionista.addActionListener(this);
        
        // Agregar los botones al panel de botones
        panelBotones.add(botonPaciente);
        panelBotones.add(botonAdmisionista);
        
        // Agregar el panel de botones en el centro
        add(panelBotones, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // if (e.getSource() == openSecondButton) {
        if (e.getSource() == botonPaciente) {
             //Crear y mostrar la segunda ventana
            MenuPaciente menupaciente = new MenuPaciente(this);
            menupaciente.setVisible(true);
            // Ocultar la ventana principal
            setVisible(false);
        }else if (e.getSource() == botonAdmisionista) {
            
            // Mostrar el menú del admisionista y esconder esta ventana
            MenuAdmisionista menuadmisionista = new MenuAdmisionista(this);
            menuadmisionista.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana principal
        ProgramaDeCitas programadecitas = new ProgramaDeCitas();
        programadecitas.setVisible(true);
    }
}