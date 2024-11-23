import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Calendario {

    private LocalDate fechaActual;
    private LocalDate finDeAño;
    private List<String> DiasHabiles;

    public Calendario(){
   
        // Crear un marco (ventana)
        //JFrame frame = new JFrame("Días Hábiles hasta el 31 de Diciembre");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(400, 300);

        // Obtener la fecha actual
        fechaActual = LocalDate.now();
        finDeAño = LocalDate.of(fechaActual.getYear(), 12, 31);

        // Lista para almacenar los días hábiles
         DiasHabiles = new ArrayList<>();

        // Iterar sobre los días desde la fecha actual hasta el 31 de diciembre
        LocalDate dia = fechaActual;
        while (!dia.isAfter(finDeAño)) {
            DayOfWeek diaSemana = dia.getDayOfWeek();
            // Excluir los días 24, 25 y 31 de diciembre
            if (diaSemana != DayOfWeek.SUNDAY && !(dia.getMonthValue() == 12 && (dia.getDayOfMonth() == 24 || dia.getDayOfMonth() == 25 || dia.getDayOfMonth() == 31))) {
                DiasHabiles.add(dia.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }
            dia = dia.plusDays(1);
        }

        // Crear una etiqueta con los días hábiles
        StringBuilder texto = new StringBuilder("<html>Días hábiles desde hoy hasta el 31 de diciembre:<br>");
        for (String d : DiasHabiles) {
            texto.append(d).append("<br>");
        }
       // texto.append("</html>");
       // JLabel label = new JLabel(texto.toString());
       // frame.add(label);

        // Hacer visible la ventana
        //frame.setVisible(true);
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }

    public LocalDate getFinDeAño() {
        return finDeAño;
    }

    public void setFinDeAño(LocalDate finDeAño) {
        this.finDeAño = finDeAño;
    }

    public List<String> getDiasHabiles() {
        return DiasHabiles;
    }

    public void setDiasHabiles(List<String> diasHabiles) {
        DiasHabiles = diasHabiles;
    }
}