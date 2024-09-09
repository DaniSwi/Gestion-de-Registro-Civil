import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import java.util.*;

public class GraficoLineas extends JFrame {

    public GraficoLineas(ArrayList menoresEdad, ArrayList mayoresEdad, ArrayList adultosMayores) {
        // Crear el conjunto de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Suponiendo que tienes datos para diferentes años, puedes ajustar esto según necesites
        dataset.addValue(menoresEdad.size(), "Menores de edad", "2024");
        dataset.addValue(mayoresEdad.size(), "Mayores de edad", "2024");
        dataset.addValue(adultosMayores.size(), "Adultos mayores", "2024");

        dataset.addValue(menoresEdad.size() + 5, "Menores de edad", "2025"); // Ejemplo de incremento en años
        dataset.addValue(mayoresEdad.size() + 3, "Mayores de edad", "2025");
        dataset.addValue(adultosMayores.size() + 2, "Adultos mayores", "2025");

        // Crear el gráfico de línea
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Tendencia de Personas por Edad",  // Título del gráfico
                "Año",                            // Etiqueta del eje X
                "Cantidad",                       // Etiqueta del eje Y
                dataset);                         // Conjunto de datos

        // Crear el panel con el gráfico y agregarlo al JFrame
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }
}
