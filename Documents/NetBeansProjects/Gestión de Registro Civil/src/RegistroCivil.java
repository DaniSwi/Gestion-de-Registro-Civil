import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;

/*
Por favor, antes de ejecutar el programa asegúrese de que las librerías con los archivos de JavaFX y Apache POI estén en su IDE.
Las carpetas las puede encontrar en este mismo archivo, así que no debe descargar nada.
 */
public class RegistroCivil extends Application {

    private ArrayList personas = new ArrayList();
    private ArrayList personasMenoresEdad = new ArrayList();
    private ArrayList personasMayoresEdad = new ArrayList();
    private ArrayList personasAdultosMayores = new ArrayList();
    private HashMap mapaPersonasPorEdad = new HashMap();
    private HashMap mapaPersonasPorRut = new HashMap();
    private Excel archivoExcel = new Excel();
    private HashMap mapaClientes = new HashMap();

    public void registrarPersonas() {
        Persona p1 = new Persona(99, "Sara", "23357956-1", new Lugar("Puerto Montt", "Ovalle", "Antofagasta"), new Fecha(9, 3, 1969));
        Persona p2 = new Persona(11, "Pedro", "5550575-0", new Lugar("Valparaíso", "Los Ángeles", "Arica y Parinacota"), new Fecha(21, 6, 1993));
        Persona p3 = new Persona(21, "Paula", "17262816-2", new Lugar("Puerto Montt", "Viña del Mar", "Araucanía"), new Fecha(12, 9, 1960));
        Persona p4 = new Persona(38, "Alberto", "11371883-0", new Lugar("Temuco", "Los Ángeles", "Tarapacá"), new Fecha(10, 7, 1990));
        Persona p5 = new Persona(82, "Miguel", "9590795-9", new Lugar("Santiago", "Viña del Mar", "Metropolitana"), new Fecha(20, 3, 1993));
        Persona p6 = new Persona(96, "María", "19635664-7", new Lugar("Iquique", "Calama", "Antofagasta"), new Fecha(8, 8, 2022));
        Persona p7 = new Persona(6, "Alberto", "9890438-4", new Lugar("Arica", "Curicó", "Araucanía"), new Fecha(2, 7, 1952));
        Persona p8 = new Persona(51, "Fernando", "23949546-5", new Lugar("Iquique", "Las Condes", "Coquimbo"), new Fecha(2, 7, 1969));
        Persona p9 = new Persona(81, "Lucía", "11449729-3", new Lugar("Iquique", "San Antonio", "Coquimbo"), new Fecha(16, 9, 1985));
        Persona p10 = new Persona(60, "Lucía", "19423827-0", new Lugar("Valparaíso", "Curicó", "Valparaíso"), new Fecha(4, 9, 1979));
        Persona p11 = new Persona(72, "Alberto", "7426286-2", new Lugar("Concepción", "Curicó", "Los Lagos"), new Fecha(6, 7, 1963));
        Persona p12 = new Persona(17, "Miguel", "22029861-5", new Lugar("Puerto Montt", "San Antonio", "Metropolitana"), new Fecha(18, 6, 1959));
        Persona p13 = new Persona(50, "Fernando", "15676106-6", new Lugar("Arica", "San Antonio", "Biobío"), new Fecha(28, 2, 2005));
        Persona p14 = new Persona(84, "Alberto", "2860212-6", new Lugar("Santiago", "Providencia", "O'Higgins"), new Fecha(3, 3, 1970));
        Persona p15 = new Persona(93, "Lucía", "24047495-4", new Lugar("Puerto Montt", "Ovalle", "Araucanía"), new Fecha(9, 8, 1976));
        Persona p16 = new Persona(22, "Carmen", "16226319-4", new Lugar("Valparaíso", "Quillota", "Coquimbo"), new Fecha(15, 9, 1982));
        Persona p17 = new Persona(31, "Marta", "2640942-6", new Lugar("Valparaíso", "Providencia", "Coquimbo"), new Fecha(7, 1, 1963));
        Persona p18 = new Persona(20, "Raúl", "3371485-4", new Lugar("Iquique", "Los Ángeles", "Valparaíso"), new Fecha(25, 11, 2001));
        Persona p19 = new Persona(26, "Miguel", "20098814-6", new Lugar("Santiago", "Quillota", "Antofagasta"), new Fecha(5, 3, 2017));
        Persona p20 = new Persona(93, "Marta", "2934189-3", new Lugar("Rancagua", "Viña del Mar", "Los Lagos"), new Fecha(22, 6, 2004));
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);
        personas.add(p7);
        personas.add(p8);
        personas.add(p9);
        personas.add(p10);
        personas.add(p11);
        personas.add(p12);
        personas.add(p13);
        personas.add(p14);
        personas.add(p15);
        personas.add(p16);
        personas.add(p17);
        personas.add(p18);
        personas.add(p19);
        personas.add(p20);
    }

    public void mostrarLista() {   //Muestra la lista de personas en general.
        for (int i = 0; i < this.personas.size(); ++i) {
            Persona persona = (Persona) personas.get(i);
            persona.presentarse();
        }
    }

    public void manejarListasEdades() { // Organiza las listas de personas clasificadas por edades.
        for (int i = 0; i < personas.size(); ++i) {
            Persona persona = (Persona) personas.get(i);
            if (persona.getEdad() < 18) {
                personasMenoresEdad.add(persona);
            } else if (persona.getEdad() >= 18 && persona.getEdad() < 65) {
                personasMayoresEdad.add(persona);
            } else {
                personasAdultosMayores.add(persona);
            }
        }
    }

    public void manejarMapas() { // Pobla los mapas con las claves correspondientes.
        for (int i = 0; i < personas.size(); ++i) {
            Persona persona = (Persona) personas.get(i);
            if (mapaPersonasPorEdad.containsKey(persona.getEdad())) {
                ArrayList lista = (ArrayList) mapaPersonasPorEdad.get(persona.getEdad());
                lista.add(persona);
            } else {
                ArrayList lista = new ArrayList();
                lista.add(persona);
                mapaPersonasPorEdad.put(persona.getEdad(), lista);
            }
            if (!mapaPersonasPorRut.containsKey(persona.getRut())) {
                mapaPersonasPorRut.put(persona.getRut(), persona);
            }
        }
    }

    public void agregarPersona() throws IOException { // Agrega persona a la lista de personas del sistema.
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

        if (mapaPersonasPorEdad.containsKey(persona.getEdad())) {
            ArrayList lista = (ArrayList) mapaPersonasPorEdad.get(persona.getEdad());
            lista.add(persona);
        } else {
            ArrayList lista = new ArrayList();
            lista.add(persona);
            mapaPersonasPorEdad.put(persona.getEdad(), lista);
        }
        if (!mapaPersonasPorRut.containsKey(persona.getRut())) {
            mapaPersonasPorRut.put(persona.getRut(), persona);
        }

        if (persona.getEdad() < 18) {
            personasMenoresEdad.add(persona);
        } else if (persona.getEdad() >= 18 && persona.getEdad() < 65) {
            personasMayoresEdad.add(persona);
        } else {
            personasAdultosMayores.add(persona);
        }

    }

    public void buscarPorEdades() throws IOException { //Busca en el sistema personas con la edad solicitada.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese una edad a buscar: ");
        int edad = Integer.parseInt(reader.readLine());
        if (mapaPersonasPorEdad.containsKey(edad)) {
            ArrayList lista = (ArrayList) mapaPersonasPorEdad.get(edad);
            for (int i = 0; i < lista.size(); ++i) {
                Persona persona = (Persona) lista.get(i);
                persona.presentarse();
            }
        } else {
            System.out.println("No se ha encontrado registro de personas con la edad solicitada");
        }
    }

    public void buscarPorRut() throws IOException { //Busca en el sistema a la persona con rut dado.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese RUT para buscar: ");
        String rut = reader.readLine();
        try {
            if(validarRut(rut)){
                System.out.println("Validación exitosa");
            }
        } catch(InvalidRutException e){
            System.out.println("Error de validación del rut");
        }
        if (mapaPersonasPorRut.containsKey(rut)) {
            Persona persona = (Persona) mapaPersonasPorRut.get(rut);
            persona.presentarse();
        } else {
            System.out.println("Persona no figura en el sistema!");
        }
    }

    public Boolean estaPersonaEnLista(String rut) { //Revisa si existe la persona en el sistema con el rut ingresado.
        for (int i = 0; i < personas.size(); ++i) {
            Persona persona = (Persona) personas.get(i);
            if (persona.getRut().equals(rut)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarPersona() throws IOException { //Elimina a la persona con el rut ingresado de todo el sistema.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el RUT de la persona a eliminar: ");
        String rut = reader.readLine();
        if (estaPersonaEnLista(rut)) {           //Si la persona está en la lista implica que también se agrego a los mapas
            Persona persona = (Persona) mapaPersonasPorRut.get(rut);
            ArrayList lista = (ArrayList) mapaPersonasPorEdad.get(persona.getEdad());
            for (int i = 0; i < lista.size(); ++i) {
                Persona person = (Persona) lista.get(i);
                if (person.getRut().equals(rut)) {
                    lista.remove(i);
                    break;
                }
            }
            for (int j = 0; j < personas.size(); ++j) {
                Persona person = (Persona) personas.get(j);
                if (person.getRut().equals(rut)) {
                    personas.remove(j);
                    break;
                }
            }
            if (persona.getEdad() < 18) {
                for (int i = 0; i < personasMenoresEdad.size(); ++i) {
                    Persona p = (Persona) personasMenoresEdad.get(i);
                    if (p.getRut().equals(rut)) {
                        personasMenoresEdad.remove(i);
                        break;
                    }
                }
            } else if (persona.getEdad() < 65) {
                for (int i = 0; i < personasMayoresEdad.size(); ++i) {
                    Persona p = (Persona) personasMayoresEdad.get(i);
                    if (p.getRut().equals(rut)) {
                        personasMayoresEdad.remove(i);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < personasAdultosMayores.size(); ++i) {
                    Persona p = (Persona) personasAdultosMayores.get(i);
                    if (p.getRut().equals(rut)) {
                        personasAdultosMayores.remove(i);
                        break;
                    }
                }
            }
            mapaPersonasPorRut.remove(rut);
            System.out.println("Persona eliminada exitosamente!");
        } else {
            System.out.println("Persona no encontrada en el sistema!");
        }
    }

    public void leerCSV() throws IOException { //Lee el archivo CSV y lo ingresa a la lista del sistema.
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.csv"))) {
            System.out.println("Cargando archivo CSV. . .");
            String linea;
            while ((linea = reader.readLine()) != null) {
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

    public void cambiarNombrePersona() throws IOException { //Se le modifica el nombre a una persona y lo cambia en todo el sistema.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el RUT de la persona a modificar el nombre: ");
        String rut = reader.readLine();
        if (estaPersonaEnLista(rut)) {
            System.out.println("Ingrese el nuevo nombre de la persona: ");
            String nombre = reader.readLine();
            Persona persona = (Persona) mapaPersonasPorRut.get(rut);
            persona.setNombre(nombre);
            ArrayList lista = (ArrayList) mapaPersonasPorEdad.get(persona.getEdad());
            for (int i = 0; i < lista.size(); ++i) {
                Persona person = (Persona) lista.get(i);
                if (person.getRut().equals(rut)) {
                    person.setNombre(nombre);
                    break;
                }
            }
            for (int j = 0; j < personas.size(); ++j) {
                Persona person = (Persona) personas.get(j);
                if (person.getRut().equals(rut)) {
                    person.setNombre(nombre);
                    break;
                }
            }
            if (persona.getEdad() < 18) {
                for (int i = 0; i < personasMenoresEdad.size(); ++i) {
                    Persona p = (Persona) personasMenoresEdad.get(i);
                    if (p.getRut().equals(rut)) {
                        p.setNombre(nombre);
                        break;
                    }
                }
            } else if (persona.getEdad() < 65) {
                for (int i = 0; i < personasMayoresEdad.size(); ++i) {
                    Persona p = (Persona) personasMayoresEdad.get(i);
                    if (p.getRut().equals(rut)) {
                        p.setNombre(nombre);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < personasAdultosMayores.size(); ++i) {
                    Persona p = (Persona) personasAdultosMayores.get(i);
                    if (p.getRut().equals(rut)) {
                        p.setNombre(nombre);
                        break;
                    }
                }
            }
            System.out.println("Cambio de nombre exitoso!");
        } else {
            System.out.println("Persona no encontrada en el sistema!");
        }
    }
    
    public boolean validarRut(String rut) throws InvalidRutException {
        rut = rut.replace(".","").replace("-", "");
        if(rut.length() < 8 || rut.length() > 9){
            throw new InvalidRutException("Rut inválido, debe tener entre 8 y 9 caracteres");
        }
        return true;
    }
    
    public boolean validarEdad(int edad) throws UnsupportedEdadException {
        if(edad < 0 || edad > 120){
            throw new UnsupportedEdadException("Edad no válida");
        }
        return true;
    }

    public void mostrarMenuConsola() throws IOException { //Muestra las opciones en consola.
        int opcion;
        try {
            do {
                System.out.println("---------------------------------");
                System.out.println("        MENÚ DE OPCIONES");
                System.out.println("---------------------------------");
                System.out.println("1) Agregar personas a la lista ");
                System.out.println("2) Ver lista de personas");
                System.out.println("3) Cargar archivo CSV de personas");
                System.out.println("4) Buscar personas por edad");
                System.out.println("5) Eliminar a una persona del sistema");
                System.out.println("6) Modificar nombre a una persona");
                System.out.println("7) Buscar por rut");
                System.out.println("8) Salir del menú");

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1 ->
                        agregarPersona();
                    case 2 ->
                        mostrarLista();
                    case 3 ->
                        leerCSV();
                    case 4 ->
                        buscarPorEdades();
                    case 5 ->
                        eliminarPersona();
                    case 6 ->
                        cambiarNombrePersona();
                    case 7 ->
                        buscarPorRut();
                    case 8 -> {
                        System.out.println("Saliendo del menú. . .");
                        reader.close();
                    }
                    default ->
                        System.out.println("Opción no válida, ingrese nuevamente.");
                }
            } while (opcion != 8);
        } catch (IllegalArgumentException e) {
            System.out.println("Ingresaste algo no válido! " + e.getMessage());
        }
    }

    /*
    Funcionalidades de ventanas con JavaFX, por favor ingresar las librerías correspondientes para que funcione correctamente
     */
    private void abrirVentanaAgregarPersona() throws UnsupportedFechaException {
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
        
        Button backButton = new Button("Volver");
        backButton.setOnAction(e -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });

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
                    throw new UnsupportedFechaException("Fecha no válida");
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
            } catch (UnsupportedFechaException ex) {
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
        grid.add(backButton, 1, 10);

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
        for (int i = 0; i < this.personas.size(); ++i) {
            Persona persona = (Persona) this.personas.get(i);
            builder.append(persona.presentarse('A'));
        }

        textArea.setText(builder.toString());

        Scene scene = new Scene(textArea, 600, 600);
        viewStage.setScene(scene);
        viewStage.initModality(Modality.APPLICATION_MODAL);
        viewStage.setResizable(false);
        viewStage.centerOnScreen();
        viewStage.showAndWait();
    }

    public void abrirVentanaEliminarPersona() {
        Stage eliminarStage = new Stage();
        eliminarStage.setTitle("Eliminar a una persona del sistema");

        Label rutLabel = new Label("Rut: ");
        TextField rutField = new TextField();
        Button saveButton = new Button("Guardar");
        saveButton.setOnAction(e -> {
            String rut = rutField.getText();
            if (mapaPersonasPorRut.containsKey(rut)) {
                Persona persona = (Persona) mapaPersonasPorRut.get(rut);
                ArrayList lista = (ArrayList) mapaPersonasPorEdad.get(persona.getEdad());
                for (int i = 0; i < lista.size(); ++i) {
                    Persona person = (Persona) lista.get(i);
                    if (person.getRut().equals(rut)) {
                        lista.remove(i);
                        break;
                    }
                }
                for (int j = 0; j < personas.size(); ++j) {
                    Persona person = (Persona) personas.get(j);
                    if (person.getRut().equals(rut)) {
                        personas.remove(j);
                        break;
                    }
                }
                if (persona.getEdad() < 18) {
                    for (int i = 0; i < personasMenoresEdad.size(); ++i) {
                        Persona p = (Persona) personasMenoresEdad.get(i);
                        if (p.getRut().equals(rut)) {
                            personasMenoresEdad.remove(i);
                            break;
                        }
                    }
                } else if (persona.getEdad() < 65) {
                    for (int i = 0; i < personasMayoresEdad.size(); ++i) {
                        Persona p = (Persona) personasMayoresEdad.get(i);
                        if (p.getRut().equals(rut)) {
                            personasMayoresEdad.remove(i);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < personasAdultosMayores.size(); ++i) {
                        Persona p = (Persona) personasAdultosMayores.get(i);
                        if (p.getRut().equals(rut)) {
                            personasAdultosMayores.remove(i);
                            break;
                        }
                    }
                }
                mapaPersonasPorRut.remove(rut);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Persona eliminada");
                alert.setHeaderText(null);
                alert.setContentText("Persona se ha eliminado del sistema exitosamente!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Persona no encontrada en el sistema");
                alert.setHeaderText(null);
                alert.setContentText("Persona no se ha registrado en el sistema o no existe!");
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

    public void vaciarCSV() {
        try (FileWriter writer = new FileWriter("output.csv", false)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirVentanaGenerarCSV() {
        vaciarCSV();
        Stage csvStage = new Stage();
        csvStage.setTitle("Generar archivo CSV");
        Button generateButton = new Button("Generar");
        generateButton.setOnAction(e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {
                writer.write("Nombre,Rut,Edad");
                writer.newLine();
                for (int i = 0; i < personas.size(); ++i) {
                    Persona p = (Persona) personas.get(i);
                    writer.write(p.presentarse('C'));
                    writer.newLine();
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Archivo generado");
                alert.setHeaderText(null);
                alert.setContentText("Archivo *output.csv* generado correctamente!");
                alert.showAndWait();
            } catch (IOException r) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al generar archivo");
                alert.setHeaderText(null);
                alert.setContentText("Archivo no ha podido ser generado");
                alert.showAndWait();
            }
        });
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(generateButton, 1, 2);
        Scene scene = new Scene(grid, 200, 200);
        csvStage.setScene(scene);
        csvStage.initModality(Modality.APPLICATION_MODAL);
        csvStage.setResizable(false);
        csvStage.centerOnScreen();
        csvStage.showAndWait();
    }
    
    public void gestionarPasaporte(Cliente c){
        LocalDate fechaActual = LocalDate.now();
        Fecha fechaHoy = new Fecha(fechaActual.getDayOfMonth(), fechaActual.getMonthValue(), fechaActual.getYear());
        LocalDate fechaCaducidad = fechaActual.plusYears(10);
        Fecha fechaVencimiento = new Fecha(fechaCaducidad.getDayOfMonth(), fechaCaducidad.getMonthValue(), fechaCaducidad.getYear());
        Pasaporte pas = new Pasaporte(c, c.getLugarNacimiento(), c.getFechaNacimiento(), fechaHoy, fechaVencimiento);
        c.setPasaporte(pas);
    }

    public void gestionarViajeCliente() {
        Stage viajeStage = new Stage();
        viajeStage.setTitle("Gestionar viaje a cliente");
        Label rutLabel = new Label("Rut del cliente: ");
        TextField rutField = new TextField();
        Button saveButton = new Button("Guardar");
        Button backButton = new Button("Volver");
        backButton.setOnAction(e -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close(); // Cierra la ventana actual
        });
        saveButton.setOnAction(e -> {
            String rut = rutField.getText();
            if(mapaPersonasPorRut.containsKey(rut)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Antecedentes");
                alert.setHeaderText("Consulta de Antecedentes");
                alert.setContentText("¿El cliente tiene antecedentes?");
                ButtonType buttonSi = new ButtonType("Sí");
                ButtonType buttonNo = new ButtonType("No");
                alert.getButtonTypes().setAll(buttonSi, buttonNo);
                Optional<ButtonType> result = alert.showAndWait();
                 if (result.isPresent() && result.get() == buttonSi) {
                     Alert alerta = new Alert(Alert.AlertType.WARNING);
                     alerta.setTitle("Cliente con antecedentes");
                     alerta.setHeaderText(null);
                     alerta.setContentText("Cliente con antecedentes criminales, no podrá crearse el pasaporte");
                     alerta.showAndWait();
                     Persona persona = (Persona) mapaPersonasPorRut.get(rut);
                     Cliente cliente = new Cliente(persona.getEdad(), persona.getNombre(), rut, persona.getLugarNacimiento(), persona.getFechaNacimiento(), true);
                     mapaClientes.put(rut, cliente);
                 } else {
                     Persona persona = (Persona) mapaPersonasPorRut.get(rut);
                     Cliente cliente = new Cliente(persona.getEdad(), persona.getNombre(), rut, persona.getLugarNacimiento(), persona.getFechaNacimiento(), false);
                     gestionarPasaporte(cliente);
                     Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                     alerta.setTitle("Pasaporte creado");
                     alert.setHeaderText(null);
                     alerta.setContentText("Pasaporte del clente creado!");
                     alerta.showAndWait();
                     mapaClientes.put(rut, cliente);
                 }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Persona no encontrada");
                alert.setHeaderText(null);
                alert.setContentText("Persona no ha sido encontrada en el sistema");
                alert.showAndWait();
            }
        });
        
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(rutLabel, 0, 0);
        grid.add(rutField, 1, 0);
        grid.add(saveButton, 1, 2);
        grid.add(backButton, 1, 3);
        Scene scene = new Scene(grid, 600, 600);
        viajeStage.setScene(scene);
        viajeStage.initModality(Modality.APPLICATION_MODAL);
        viajeStage.setResizable(false);
        viajeStage.centerOnScreen();
        viajeStage.showAndWait();
    }
    
    public void crearGraficos(){
        Grafico grafico = new Grafico(personasMenoresEdad, personasMayoresEdad, personasAdultosMayores);
    }

    public void start(Stage primaryStage) {

        registrarPersonas();
        manejarListasEdades();
        manejarMapas();

        primaryStage.setTitle("Gestión de Registro Civil");

        Button addButton = new Button("Agregar Persona");
        Button viewButton = new Button("Ver Lista de Personas");
        Button deleteButton = new Button("Eliminar a una persona");
        Button generateCSVButton = new Button("Generar CSV de las personas");
        Button crearPasaporteButton = new Button("Crear pasaporte cliente");
        Button crearGraficoButton = new Button("Crear gráfico datos");
        Button exitButton = new Button("Salir");

        addButton.setOnAction(e -> abrirVentanaAgregarPersona());
        viewButton.setOnAction(e -> abrirVentanaVerPersonas());
        deleteButton.setOnAction(e -> abrirVentanaEliminarPersona());
        generateCSVButton.setOnAction(e -> abrirVentanaGenerarCSV());
        crearPasaporteButton.setOnAction(e -> gestionarViajeCliente());
        crearGraficoButton.setOnAction(e -> crearGraficos());
        exitButton.setOnAction(e -> primaryStage.close());

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(addButton, 0, 0);
        grid.add(viewButton, 1, 0);
        grid.add(deleteButton, 2, 0);
        grid.add(generateCSVButton, 0, 1);
        grid.add(crearPasaporteButton, 1, 1);
        grid.add(crearGraficoButton, 2, 1);
        grid.add(exitButton, 4, 5);

        Scene scene = new Scene(grid, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public void excear() {
        archivoExcel.escribirExcel(personas);
        System.out.println("Datos escritos en el archivo exitosamente.");
    }

    public static void main(String args[]) throws IOException {

        RegistroCivil regCivil = new RegistroCivil();

        regCivil.registrarPersonas();
        regCivil.manejarListasEdades();
        regCivil.manejarMapas();
        regCivil.mostrarMenuConsola();
        regCivil.excear();

        launch(args);

    }
}

//Solucionar menu ventanas (centrar más los botones)
//Volver para atrás menú
//bug graficos! solucionado wa