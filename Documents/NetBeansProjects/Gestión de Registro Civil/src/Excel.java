import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {
    
    public static void escribirExcel(ArrayList<Persona> personas, String archivo) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Personas");

        // Crear la fila de encabezados
        Row encabezado = sheet.createRow(0);
        encabezado.createCell(0).setCellValue("Nombre");
        encabezado.createCell(1).setCellValue("Edad");
        encabezado.createCell(2).setCellValue("RUT");
        encabezado.createCell(3).setCellValue("Ciudad");
        encabezado.createCell(4).setCellValue("Comuna");
        encabezado.createCell(5).setCellValue("Región");
        encabezado.createCell(6).setCellValue("Fecha de Nacimiento");

        // Llenar las filas con datos del ArrayList
        int rowNum = 1;
        for (Persona persona : personas) {
            Row fila = sheet.createRow(rowNum++);
            fila.createCell(0).setCellValue(persona.getNombre());
            fila.createCell(1).setCellValue(persona.getEdad());
            fila.createCell(2).setCellValue(persona.getRut());
        }

        // Escribir el archivo
        try (FileOutputStream fileOut = new FileOutputStream(archivo)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Archivo Excel generado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        Persona persona = new Persona(50, "Test", "6.666.666-6", new Lugar("TestCiudad", "TestComuna", "TestRegión"), new Fecha(10, 10, 2010));
        personas.add(persona);

        escribirExcel(personas, "C:\\Users\\PC RST GALAX\\Downloads\\excel.xlsx");
    }
}
