import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuOpcionesAdmisionista extends JFrame {
    private JButton botonVerPacientes;
    private JButton botonVerCitas;
    private JButton botonVerMedicos;
    private JButton botonVerEspecialistas;
    private JButton botonCerrarSesion;

    @SuppressWarnings("unused")
    public MenuOpcionesAdmisionista(CallCenter callCenter, JFrame programacitas) {
        // Configuración de la ventana
        setTitle("Menú de Opciones Admisionista");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuración del layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margen entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Botones con el mismo ancho
        gbc.weightx = 1.0; // Expandir horizontalmente
        gbc.gridx = 0; // Posición de columna (siempre la misma para centrar)

        // Botón para ver lista de pacientes
        botonVerPacientes = new JButton("Ver Lista de Pacientes");
        botonVerPacientes.addActionListener(e -> {
            List<Paciente> pacientes = callCenter.getListaPacientes();
            if (pacientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay pacientes registrados.", "Pacientes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder pacientesInfo = new StringBuilder("Lista de Pacientes:\n");
                for (Paciente paciente : pacientes) {
                    pacientesInfo.append(paciente.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(this, pacientesInfo.toString(), "Pacientes", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 0; // Fila 0
        add(botonVerPacientes, gbc);

        // Botón para ver lista de citas
        botonVerCitas = new JButton("Ver Lista de Citas");
        botonVerCitas.addActionListener(e -> {
            List<Cita> citas = callCenter.getListaCitas();
            if (citas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay citas registradas.", "Citas", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder citasInfo = new StringBuilder("Lista de Citas:\n");
                for (Cita cita : citas) {
                    citasInfo.append(cita.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(this, citasInfo.toString(), "Citas", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 1; // Fila 1
        add(botonVerCitas, gbc);

        // Botón para ver lista de médicos
        botonVerMedicos = new JButton("Ver Lista de Médicos");
        botonVerMedicos.addActionListener(e -> {
            List<Medico> medicos = callCenter.getListaMedicos();
            if (medicos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay médicos registrados.", "Médicos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder medicosInfo = new StringBuilder("Lista de Médicos:\n");
                for (Medico medico : medicos) {
                    medicosInfo.append(medico.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(this, medicosInfo.toString(), "Médicos", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 2; // Fila 2
        add(botonVerMedicos, gbc);

        // Botón para ver lista de especialistas
        botonVerEspecialistas = new JButton("Ver Lista de Especialistas");
        botonVerEspecialistas.addActionListener(e -> {
            List<Especialista> especialistas = callCenter.getListaEspecialistas();
            if (especialistas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay especialistas registrados.", "Especialistas", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder especialistasInfo = new StringBuilder("Lista de Especialistas:\n");
                for (Especialista especialista : especialistas) {
                    especialistasInfo.append(especialista.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(this, especialistasInfo.toString(), "Especialistas", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 3; // Fila 3
        add(botonVerEspecialistas, gbc);

        // Botón para cerrar sesión y volver al menú anterior
        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.addActionListener(e -> {
            programacitas.setVisible(true);
            dispose();
        });
        gbc.gridy = 4; // Fila 4
        add(botonCerrarSesion, gbc);
    }
}
