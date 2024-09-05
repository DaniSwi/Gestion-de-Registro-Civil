import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegistroCivil extends Application{

    private ArrayList personas = new ArrayList();
    private ArrayList personasMenoresEdad = new ArrayList();
    private ArrayList personasMayoresEdad = new ArrayList();
    private ArrayList personasAdultosMayores = new ArrayList();
    private HashMap mapaPersonasPorEdad = new HashMap();
    private HashMap mapaPersonasPorRut = new HashMap();
    
    public void registrarPersonas(){   //Con el random para el relleno de datos del SIA avance.
        Random random = new Random();
        for(int i=0;i<20;++i){
            Persona persona = new Persona(random.nextInt(100), "Test", "6.666.666-6", new Lugar("TestCiudad", "TestComuna", "TestRegión"), new Fecha(10, 10, 2010));
            personas.add(persona);
        }
    } 
    
    public void mostrarLista(){   //Muestra la lista de personas en general.
        for(int i=0; i<this.personas.size(); ++i){
            Persona persona = (Persona)personas.get(i);
            persona.presentarse();
        }
    }
    
    public void manejarListasEdades() {
        for(int i=0; i<personas.size(); ++i){
            Persona persona = (Persona)personas.get(i);
            if(persona.getEdad() < 18){
                personasMenoresEdad.add(persona);
            } else if(persona.getEdad() >= 18 && persona.getEdad() < 65){
                personasMayoresEdad.add(persona);
            } else {
                personasAdultosMayores.add(persona);
            }
        }
    }
    public void manejarMapas(){
        for(int i=0; i<personas.size(); ++i){
            Persona persona = (Persona)personas.get(i);
            if(mapaPersonasPorEdad.containsKey(persona.getEdad())){
                ArrayList lista = (ArrayList)mapaPersonasPorEdad.get(persona.getEdad());
                lista.add(persona);
            } else {
                ArrayList lista = new ArrayList();
                lista.add(persona);
                mapaPersonasPorEdad.put(persona.getEdad(), lista);
            }
            if(mapaPersonasPorRut.containsKey(persona.getRut())){
                System.out.println("Persona ya ingresa en el sistema!");
            } else {
                mapaPersonasPorRut.put(persona.getRut(), persona);
            }
        }
    }
    
    public void agregarPersona() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre de la persona: ");
        String nombre = reader.readLine();
        System.out.println("Ingrese edad de la persona: ");
        int edad = Integer.parseInt(reader.readLine());
        System.out.println("Ingrese el rut de la persona: ");
        String rut = reader.readLine();
        System.out.println("Ingrese fecha de nacimiento de la persona.");
        System.out.println("Primero día de nacimiento: ");
        int dia = Integer.parseInt(reader.readLine());
        System.out.println("Mes de nacimiento: ");
        int mes = Integer.parseInt(reader.readLine());
        System.out.println("Año de nacimiento: ");
        int año = Integer.parseInt(reader.readLine());
        Fecha fecha = new Fecha(dia, mes, año);
        System.out.println("Ingrese lugar de nacimiento de la persona.");
        System.out.println("Primero ciudad de nacimiento: ");
        String ciudad = reader.readLine();
        System.out.println("Comuna de nacimiento: ");
        String comuna = reader.readLine();
        System.out.println("Región de nacimiento: ");
        String region = reader.readLine();
        Lugar lugar = new Lugar(ciudad, comuna, region);
        
        Persona persona = new Persona(edad, nombre, rut, lugar, fecha);
        personas.add(persona);
        System.out.println("Persona " + persona.getNombre() + " agregada correctamente!");
    }
    
    public void buscarPorEdades() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese una edad a buscar: ");
        int edad = Integer.parseInt(reader.readLine());
        if(mapaPersonasPorEdad.containsKey(edad)){
            ArrayList lista = (ArrayList)mapaPersonasPorEdad.get(edad);
            for(int i=0; i<lista.size(); ++i){
                Persona persona = (Persona)lista.get(i);
                persona.presentarse();
            }
        } else {
            System.out.println("No se ha encontrado registro de personas con la edad solicitada");
        }
    }
    
    
    public void mostrarMenuConsola() throws IOException{
        int opcion;
        do {
            System.out.println("---------------------------------");
            System.out.println("        MENÚ DE OPCIONES");
            System.out.println("---------------------------------");
            System.out.println("1) Agregar personas a la lista ");
            System.out.println("2) Ver lista de personas");
            System.out.println("3) Cargar archivo CSV de personas");
            System.out.println("4) Buscar personas por edades");
            System.out.println("5) Salir del menú");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            opcion = Integer.parseInt(reader.readLine());
            
            switch (opcion) {
                case 1 -> agregarPersona();
                case 2 -> mostrarLista();
                case 3 -> leerCSV();
                case 4 -> buscarPorEdades();
                case 5 -> {
                    System.out.println("Saliendo del menú. . .");
                    reader.close();
                }
                default -> System.out.println("Opción no válida, ingrese nuevamente.");
            }
        } while(opcion != 5);
        
    } 
    
    public void leerCSV() throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader("datos.csv"))){
            System.out.println("Cargando archivo CSV. . .");
            String linea;
            while((linea = reader.readLine()) != null){
                String[] datos = linea.split(",");
                int edad = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String rut = datos[2];
                String ciudad = datos[3];
                String comuna = datos[4];
                String region = datos[5];
                int dia = Integer.parseInt(datos[6]);
                int mes = Integer.parseInt(datos[7]);
                int año = Integer.parseInt(datos[8]);
                Lugar lugar = new Lugar(ciudad, comuna, region);
                Fecha fecha = new Fecha(dia, mes, año);
                Persona persona = new Persona(edad, nombre, rut, lugar, fecha);
                personas.add(persona);
                System.out.println("Persona " + persona.getNombre() + " cargada correctamente al sistema ");
            }
        }
    }
    
    private void abrirVentanaAgregarPersona() {
        Stage addStage = new Stage();
        addStage.setTitle("Agregar Persona");

        Label nameLabel = new Label("Nombre:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Edad:");
        TextField ageField = new TextField();

        Label rutLabel = new Label("RUT:");
        TextField rutField = new TextField();
        
        Label diaNacLabel = new Label("Día nacimiento:");
        TextField diaNacField = new TextField();
        
        Label mesNacLabel = new Label("Mes nacimiento:");
        TextField mesNacField = new TextField();
        
        Label añoNacLabel = new Label("Año nacimiento:");
        TextField añoNacField = new TextField();
        
        Label ciudadNacLabel = new Label("Lugar de nacimiento:");
        TextField ciudadNacField = new TextField();
        
        Label comunaNacLabel = new Label("Comuna de nacimiento:");
        TextField comunaNacField = new TextField();
        
        Label regionNacLabel = new Label("Región de nacimiento:");
        TextField regionNacField = new TextField();

        Button saveButton = new Button("Guardar");
        saveButton.setOnAction(e -> {
            String nombre = nameField.getText();
            String rut = rutField.getText();

            try {
            int edad = Integer.parseInt(ageField.getText());
            int dia = Integer.parseInt(diaNacField.getText());
            int mes = Integer.parseInt(mesNacField.getText());
            int año = Integer.parseInt(añoNacField.getText());
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || año < 1900 || año > 2024) {
                throw new NumberFormatException("Fecha no válida");
            }
            
            Fecha fecha = new Fecha(dia, mes, año);
            
            String ciudad = ciudadNacField.getText();
            String comuna = comunaNacField.getText();
            String region = regionNacField.getText();
            
            Lugar lugar = new Lugar(ciudad, comuna, region);

            Persona persona = new Persona(edad, nombre, rut, lugar, fecha);
            personas.add(persona);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Persona agregada");
            alert.setHeaderText(null);
            alert.setContentText("Persona agregada: " + nombre);
            alert.showAndWait();

            nameField.clear();
            ageField.clear();
            rutField.clear();
            diaNacField.clear();
            mesNacField.clear();
            añoNacField.clear();
            ciudadNacField.clear();
            comunaNacField.clear();
            regionNacField.clear();
        } catch (NumberFormatException ex) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error de entrada");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("ERROR: Ingreso de un texto en un campo de números");
            errorAlert.showAndWait();
        }
    });

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);
        grid.add(rutLabel, 0, 2);
        grid.add(rutField, 1, 2);
        grid.add(diaNacLabel, 0, 3);
        grid.add(diaNacField, 1, 3);
        grid.add(mesNacLabel, 0, 4);
        grid.add(mesNacField, 1, 4);
        grid.add(añoNacLabel, 0, 5);
        grid.add(añoNacField, 1, 5);
        grid.add(ciudadNacLabel, 0, 6);
        grid.add(ciudadNacField, 1, 6);
        grid.add(comunaNacLabel, 0, 7);
        grid.add(comunaNacField, 1, 7);
        grid.add(regionNacLabel, 0, 8);
        grid.add(regionNacField, 1, 8);
        grid.add(saveButton, 1, 9);

        Scene scene = new Scene(grid, 600, 600);
        addStage.setScene(scene);
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.setResizable(false);
        addStage.centerOnScreen();
        addStage.showAndWait();
    }
    
    private void abrirVentanaVerPersonas() {
    Stage viewStage = new Stage();
    viewStage.setTitle("Lista de Personas");

    TextArea textArea = new TextArea();
    textArea.setEditable(false);

    StringBuilder builder = new StringBuilder();
    for (int i=0; i<this.personas.size(); ++i) {
        Persona persona = (Persona)this.personas.get(i);
        builder.append(persona.getNombre()).append(" - ").append(persona.getEdad()).append(" años\n");
    }

    textArea.setText(builder.toString());

    Scene scene = new Scene(textArea, 600, 600);
    viewStage.setScene(scene);
    viewStage.initModality(Modality.APPLICATION_MODAL);
    viewStage.setResizable(false);
    viewStage.centerOnScreen();
    viewStage.showAndWait();
}
    public void abrirVentanaEliminarPersona(){
        Stage eliminarStage = new Stage();
        eliminarStage.setTitle("Eliminar a una persona de la lista");
        
        Label rutLabel = new Label("Rut: ");
        TextField  rutField = new TextField();
        Button saveButton = new Button("Guardar");
         saveButton.setOnAction(e -> {
            String rut = rutField.getText();
            if(mapaPersonasPorRut.containsKey(rut)){
                mapaPersonasPorRut.remove(rut);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Persona eliminada");
                alert.setHeaderText(null);
                alert.setContentText("Persona con RUT: " + rut + "eliminada exitosamente del sistema");
                alert.showAndWait();
            }
        });
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(rutLabel, 0, 0);
        grid.add(rutField, 1, 0);
        grid.add(saveButton, 1, 2);
        Scene scene = new Scene(grid, 600, 600);
        eliminarStage.setScene(scene);
        eliminarStage.initModality(Modality.APPLICATION_MODAL);
        eliminarStage.setResizable(false);
        eliminarStage.centerOnScreen();
        eliminarStage.showAndWait();
    }
    
    public void start(Stage primaryStage) {
        registrarPersonas();
        primaryStage.setTitle("Gestión de Registro Civil");

        Button addButton = new Button("Agregar Persona");
        Button viewButton = new Button("Ver Lista de Personas");
        Button deleteButton = new Button("Eliminar a una persona");
        Button exitButton = new Button("Salir");

        addButton.setOnAction(e -> abrirVentanaAgregarPersona());
        viewButton.setOnAction(e -> abrirVentanaVerPersonas());
        deleteButton.setOnAction(e -> abrirVentanaEliminarPersona());
        exitButton.setOnAction(e -> primaryStage.close());

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(addButton, 0, 0);
        grid.add(viewButton, 1, 0);
        grid.add(deleteButton, 2, 0);
        grid.add(exitButton, 3, 0);

        Scene scene = new Scene(grid, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    /* public void excear(Excel excel) {
        try {
            excel.escribirExcel(personas);
            System.out.println("Datos escritos en el archivo exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
    
    public static void main(String args[]) throws IOException{
        
        RegistroCivil regCivil = new RegistroCivil();
        
      // Excel excel = new Excel("C:\\Users\\PC RST GALAX\\Documents\\NetBeansProjects\\Gestión de Registro Civil\\build\\classes\\excel.xlsx");
        
        regCivil.registrarPersonas();
        regCivil.manejarListasEdades();
        regCivil.manejarMapas();
        regCivil.mostrarMenuConsola();
        
       // regCivil.excear(excel);
        
        
        launch(args);
        

    }
    
}
