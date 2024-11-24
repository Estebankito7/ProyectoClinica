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
                JOptionPane.showMessageDialog(this, "No hay pacientes registrados.", "Pacientes",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Crear el StringBuilder para construir la información de los pacientes
                StringBuilder pacientesInfo = new StringBuilder("********** Lista de Pacientes **********\n\n");
                int contador = 1;

                // Construir la información de los pacientes
                for (Paciente paciente : pacientes) {
                    pacientesInfo.append("Paciente ").append(contador++).append(":\n")
                            .append("Nombre: ").append(paciente.getNombre()).append("\n")
                            .append("Documento: ").append(paciente.getDocumento()).append("\n")
                            .append("Teléfono: ").append(paciente.getTelefono()).append("\n")
                            .append("Dirección: ").append(paciente.getDireccion()).append("\n")
                            .append("Correo: ").append(paciente.getCorreo()).append("\n\n")
                            .append("****************************************\n");
                }

                // Crear un JTextArea para mostrar la información de los pacientes
                JTextArea textArea = new JTextArea(pacientesInfo.toString());
                textArea.setEditable(false); // Hacer que el texto no sea editable
                textArea.setLineWrap(true); // Ajustar el texto al ancho del área
                textArea.setWrapStyleWord(true); // Ajustar las líneas por palabras completas

                // Colocar el JTextArea dentro de un JScrollPane para habilitar el
                // desplazamiento
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400)); // Tamaño preferido del área de desplazamiento

                // Mostrar el JScrollPane dentro de un JOptionPane
                JOptionPane.showMessageDialog(this, scrollPane, "Pacientes", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        gbc.gridy = 0; // Fila 0
        add(botonVerPacientes, gbc);

        // Botón para ver lista de citas
        botonVerCitas = new JButton("Ver Lista de Citas");
        botonVerCitas.addActionListener(e -> {
            List<Cita> citas = callCenter.getListaCitas();
            if (citas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay citas registradas.", "Citas",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Crear el StringBuilder para construir la información de las citas
                StringBuilder citasInfo = new StringBuilder("********** Lista de Citas **********\n\n");
                int contador = 1;

                // Construir la información de las citas
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

                // Crear un JTextArea para mostrar la información de las citas
                JTextArea textArea = new JTextArea(citasInfo.toString());
                textArea.setEditable(false); // Hacer que el texto no sea editable
                textArea.setLineWrap(true); // Ajustar el texto al ancho del área
                textArea.setWrapStyleWord(true); // Ajustar las líneas por palabras completas

                // Colocar el JTextArea dentro de un JScrollPane para habilitar el
                // desplazamiento
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400)); // Tamaño preferido del área de desplazamiento

                // Mostrar el JScrollPane dentro de un JOptionPane
                JOptionPane.showMessageDialog(this, scrollPane, "Citas", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        gbc.gridy = 1; // Fila 1
        add(botonVerCitas, gbc);

        // Botón para ver lista de médicos
        botonVerMedicos = new JButton("Ver Lista de Médicos");
        botonVerMedicos.addActionListener(e -> {
            List<Medico> medicos = callCenter.getListaMedicos();
            if (medicos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay médicos registrados.", "Médicos",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Crear el StringBuilder para construir la información de los médicos
                StringBuilder medicosInfo = new StringBuilder("********** Lista de Médicos **********\n\n");
                int contador = 1;

                // Construir la información de los médicos
                for (Medico medico : medicos) {
                    medicosInfo.append("Médico ").append(contador++).append(":\n")
                            .append("Nombre: ").append(medico.getNombre()).append("\n")
                            .append("Especialidad: ").append("Médico General").append("\n") // Cambiar si es necesario
                            .append("Teléfono: ").append(medico.getTelefono()).append("\n")
                            .append("Correo: ").append(medico.getCorreo()).append("\n\n")
                            .append("****************************************\n\n");
                }

                // Crear un JTextArea para mostrar la información
                JTextArea textArea = new JTextArea(medicosInfo.toString());
                textArea.setEditable(false); // Hacer que el texto no sea editable
                textArea.setLineWrap(true); // Ajustar el texto al ancho del área
                textArea.setWrapStyleWord(true); // Ajustar las líneas por palabras completas

                // Colocar el JTextArea dentro de un JScrollPane para habilitar el
                // desplazamiento
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400)); // Tamaño preferido del área de desplazamiento

                // Mostrar el JScrollPane dentro de un JOptionPane
                JOptionPane.showMessageDialog(this, scrollPane, "Médicos", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gbc.gridy = 2; // Fila 2
        add(botonVerMedicos, gbc);

        // Botón para ver lista de especialistas
        botonVerEspecialistas = new JButton("Ver Lista de Especialistas");
        botonVerEspecialistas.addActionListener(e -> {
            List<Especialista> especialistas = callCenter.getListaEspecialistas();
            if (especialistas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay especialistas registrados.", "Especialistas",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Crear el StringBuilder para construir la información
                StringBuilder especialistasInfo = new StringBuilder("********** Lista de Especialistas **********\n\n");
                int contador = 1;

                // Construir la información de los especialistas
                for (Especialista especialista : especialistas) {
                    especialistasInfo.append("Especialista ").append(contador++).append(":\n")
                            .append("Nombre: ").append(especialista.getNombre()).append("\n")
                            .append("Documento: ").append(especialista.getDocumento()).append("\n")
                            .append("Teléfono: ").append(especialista.getTelefono()).append("\n")
                            .append("Dirección: ").append(especialista.getDireccion()).append("\n")
                            .append("Correo: ").append(especialista.getCorreo()).append("\n")
                            .append("Especialidad: ").append(especialista.getEspecialidad()).append("\n")
                            .append("Registro: ").append(especialista.getRegistro()).append("\n")
                            .append("Estado: ").append(especialista.getEstado()).append("\n\n")
                            .append("****************************************\n\n");
                }

                // Crear un JTextArea para mostrar la información
                JTextArea textArea = new JTextArea(especialistasInfo.toString());
                textArea.setEditable(false); // Hacer que el texto no sea editable
                textArea.setLineWrap(true); // Ajustar el texto al ancho del área
                textArea.setWrapStyleWord(true); // Ajustar las líneas por palabras completas

                // Colocar el JTextArea dentro de un JScrollPane para habilitar el
                // desplazamiento
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 400)); // Tamaño preferido del área de desplazamiento

                // Mostrar el JScrollPane dentro de un JOptionPane
                JOptionPane.showMessageDialog(this, scrollPane, "Especialistas", JOptionPane.INFORMATION_MESSAGE);

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
