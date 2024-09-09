import javax.swing.*;
import java.util.*;
import javax.swing.JFrame;

public class Grafico extends JFrame {

    public Grafico(ArrayList menoresEdad, ArrayList mayoresEdad, ArrayList adultosMayores) {

            String[] opciones = {"Gráfico de Barra", "Gráfico de Torta", "Gráfico de Línea"};
            int seleccion = JOptionPane.showOptionDialog(
                    null, 
                    "Selecciona el gráfico que deseas ver", 
                    "Selección de Gráfico", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]);

            switch (seleccion) {
                case 0:
                    GraficoBarra graficoBarra = new GraficoBarra(menoresEdad, mayoresEdad, adultosMayores);
                    graficoBarra.setSize(800, 600);
                    graficoBarra.setLocationRelativeTo(null);
                    graficoBarra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    graficoBarra.setVisible(true);
                    break;

                case 1:
                    // Mostrar gráfico de torta
                    GraficoTorta graficoTorta = new GraficoTorta(menoresEdad, mayoresEdad, adultosMayores);
                    graficoTorta.setSize(800, 600);
                    graficoTorta.setLocationRelativeTo(null);
                    graficoTorta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    graficoTorta.setVisible(true);
                    break;

                case 2:
                    // Mostrar gráfico de línea
                    GraficoLineas graficoLinea = new GraficoLineas(menoresEdad, mayoresEdad, adultosMayores);
                    graficoLinea.setSize(800, 600);
                    graficoLinea.setLocationRelativeTo(null);
                    graficoLinea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    graficoLinea.setVisible(true);
                    break;
        }
    }    
}
