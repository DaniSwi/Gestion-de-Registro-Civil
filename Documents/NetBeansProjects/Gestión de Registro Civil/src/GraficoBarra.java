import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraficoBarra extends JFrame {

     public GraficoBarra(ArrayList menoresEdad, ArrayList mayoresEdad, ArrayList adultosMayores) {
        // Crear el conjunto de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agregar datos de las listas
        dataset.addValue(menoresEdad.size(), "Categoría", "Menores de edad");
        dataset.addValue(mayoresEdad.size(), "Categoría", "Mayores de edad");
        dataset.addValue(adultosMayores.size(), "Categoría", "Adultos mayores");

        // Crear el gráfico
        JFreeChart barChart = ChartFactory.createBarChart(
                "Distribución de Personas", // Título del gráfico
                "Categoría",                // Eje X
                "Cantidad",                 // Eje Y
                dataset);                   // Datos

        // Crear el panel con el gráfico y agregarlo al JFrame
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
     }
}
