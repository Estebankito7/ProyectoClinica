import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MenuOpcionesAdmisionista extends JFrame {
    private JButton botonVerPacientes;
    private JButton botonVerCitas;
    private JButton botonVerMedicos;
    private JButton botonVerEspecialistas;
    private JButton botonCerrarSesion;
    private JButton botonGenerarArchivo;

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
                JOptionPane.showMessageDialog(this, "No hay pacientes registrados.", "Pacientes",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Crear el StringBuilder para construir la información de los pacientes
                StringBuilder pacientesInfo = new StringBuilder("********** Lista de Pacientes **********\n\n");
                int contador = 1;

                for (Paciente paciente : pacientes) {
                    pacientesInfo.append("Paciente ").append(contador++).append(":\n")
                            .append("Nombre: ").append(paciente.getNombre()).append("\n")
                            .append("Documento: ").append(paciente.getDocumento()).append("\n")
                            .append("Teléfono: ").append(paciente.getTelefono()).append("\n")
                            .append("Dirección: ").append(paciente.getDireccion()).append("\n")
                            .append("Correo: ").append(paciente.getCorreo()).append("\n\n")
                            .append("****************************************\n");
                }

                JTextArea textArea = new JTextArea(pacientesInfo.toString());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400));

                JOptionPane.showMessageDialog(this, scrollPane, "Pacientes", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 0;
        add(botonVerPacientes, gbc);

        // Botón para ver lista de citas
        botonVerCitas = new JButton("Ver Lista de Citas");
        botonVerCitas.addActionListener(e -> {
            List<Cita> citas = callCenter.getListaCitas();
            if (citas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay citas registradas.", "Citas",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder citasInfo = new StringBuilder("********** Lista de Citas **********\n\n");
                int contador = 1;

                for (Cita cita : citas) {
                    citasInfo.append("Cita ").append(contador++).append(":\n")
                            .append("Fecha: ").append(cita.getFecha()).append("\n")
                            .append("Hora: ").append(cita.getHora()).append("\n")
                            .append("Consultorio: ").append(cita.getConsultorio()).append("\n")
                            .append("Área: ").append(cita.getArea()).append("\n")
                            .append("Médico: ").append(cita.getMedico().getNombre()).append("\n")
                            .append("Especialista: ").append(cita.getEspecialista().getNombre()).append("\n")
                            .append("Paciente: ").append(cita.getPaciente().getNombre()).append("\n\n")
                            .append("****************************************\n\n");
                }

                JTextArea textArea = new JTextArea(citasInfo.toString());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400));

                JOptionPane.showMessageDialog(this, scrollPane, "Citas", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 1;
        add(botonVerCitas, gbc);

        // Botón para ver lista de médicos
        botonVerMedicos = new JButton("Ver Lista de Médicos");
        botonVerMedicos.addActionListener(e -> {
            List<Medico> medicos = callCenter.getListaMedicos();
            if (medicos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay médicos registrados.", "Médicos",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder medicosInfo = new StringBuilder("********** Lista de Médicos **********\n\n");
                int contador = 1;

                for (Medico medico : medicos) {
                    medicosInfo.append("Médico ").append(contador++).append(":\n")
                            .append("Nombre: ").append(medico.getNombre()).append("\n")
                            .append("Teléfono: ").append(medico.getTelefono()).append("\n")
                            .append("Correo: ").append(medico.getCorreo()).append("\n\n")
                            .append("****************************************\n\n");
                }

                JTextArea textArea = new JTextArea(medicosInfo.toString());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400));

                JOptionPane.showMessageDialog(this, scrollPane, "Médicos", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 2;
        add(botonVerMedicos, gbc);

        // Botón para ver lista de especialistas
        botonVerEspecialistas = new JButton("Ver Lista de Especialistas");
        botonVerEspecialistas.addActionListener(e -> {
            List<Especialista> especialistas = callCenter.getListaEspecialistas();
            if (especialistas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay especialistas registrados.", "Especialistas",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder especialistasInfo = new StringBuilder("********** Lista de Especialistas **********\n\n");
                int contador = 1;

                for (Especialista especialista : especialistas) {
                    especialistasInfo.append("Especialista ").append(contador++).append(":\n")
                            .append("Nombre: ").append(especialista.getNombre()).append("\n")
                            .append("Especialidad: ").append(especialista.getEspecialidad()).append("\n")
                            .append("Teléfono: ").append(especialista.getTelefono()).append("\n")
                            .append("Correo: ").append(especialista.getCorreo()).append("\n\n")
                            .append("****************************************\n\n");
                }

                JTextArea textArea = new JTextArea(especialistasInfo.toString());
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400));

                JOptionPane.showMessageDialog(this, scrollPane, "Especialistas", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 3;
        add(botonVerEspecialistas, gbc);

        // Botón para generar archivo
        botonGenerarArchivo = new JButton("Generar Archivo");
        botonGenerarArchivo.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("Informacion del programa.txt")) {
                // Lista de Pacientes
                writer.write("********** Lista de Pacientes **********\n\n");
                int contador = 1;
                for (Paciente paciente : callCenter.getListaPacientes()) {
                    writer.write("Paciente " + contador++ + ":\n");
                    writer.write("Nombre: " + paciente.getNombre() + "\n");
                    writer.write("Documento: " + paciente.getDocumento() + "\n");
                    writer.write("Teléfono: " + paciente.getTelefono() + "\n");
                    writer.write("Dirección: " + paciente.getDireccion() + "\n");
                    writer.write("Correo: " + paciente.getCorreo() + "\n\n");
                    writer.write("****************************************\n");
                }
        
                // Lista de Médicos
                writer.write("\n********** Lista de Médicos **********\n\n");
                contador = 1;
                for (Medico medico : callCenter.getListaMedicos()) {
                    writer.write("Médico " + contador++ + ":\n");
                    writer.write("Nombre: " + medico.getNombre() + "\n");
                    writer.write("Teléfono: " + medico.getTelefono() + "\n");
                    writer.write("Correo: " + medico.getCorreo() + "\n\n");
                    writer.write("****************************************\n");
                }
        
                // Lista de Especialistas
                writer.write("\n********** Lista de Especialistas **********\n\n");
                contador = 1;
                for (Especialista especialista : callCenter.getListaEspecialistas()) {
                    writer.write("Especialista " + contador++ + ":\n");
                    writer.write("Nombre: " + especialista.getNombre() + "\n");
                    writer.write("Especialidad: " + especialista.getEspecialidad() + "\n");
                    writer.write("Teléfono: " + especialista.getTelefono() + "\n");
                    writer.write("Correo: " + especialista.getCorreo() + "\n\n");
                    writer.write("****************************************\n");
                }
        
                // Lista de Citas
                writer.write("\n********** Lista de Citas **********\n\n");
                contador = 1;
                for (Cita cita : callCenter.getListaCitas()) {
                    writer.write("Cita " + contador++ + ":\n");
                    writer.write("Fecha: " + cita.getFecha() + "\n");
                    writer.write("Hora: " + cita.getHora() + "\n");
                    writer.write("Consultorio: " + cita.getConsultorio() + "\n");
                    writer.write("Área: " + cita.getArea() + "\n");
                    writer.write("Médico: " + cita.getMedico().getNombre() + "\n");
                    writer.write("Especialista: " + cita.getEspecialista().getNombre() + "\n");
                    writer.write("Paciente: " + cita.getPaciente().getNombre() + "\n\n");
                    writer.write("****************************************\n");
                }
        
                JOptionPane.showMessageDialog(this, "Archivo generado exitosamente.", "Generar Archivo",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al generar el archivo: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        
        gbc.gridy = 4;
        add(botonGenerarArchivo, gbc);

        // Botón para cerrar sesión
        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.addActionListener(e -> dispose());
        gbc.gridy = 5;
        add(botonCerrarSesion, gbc);
    }
}
