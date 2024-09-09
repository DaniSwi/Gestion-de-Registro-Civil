import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JFrame;
import java.util.*;

public class GraficoTorta extends JFrame {

    public GraficoTorta(ArrayList menoresEdad, ArrayList mayoresEdad, ArrayList adultosMayores) {
        // Crear el conjunto de datos
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Menores de edad", menoresEdad.size());
        dataset.setValue("Mayores de edad", mayoresEdad.size());
        dataset.setValue("Adultos mayores", adultosMayores.size());

        // Crear el gráfico de torta
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Distribución de Personas", // Título del gráfico
                dataset,                    // Datos
                true,                       // Incluye leyenda
                true,                       // Usa tooltips
                false);                     // URL de generación (innecesario en este caso)

        // Crear el panel con el gráfico y agregarlo al JFrame
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }
    
}
