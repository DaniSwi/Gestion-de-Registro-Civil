import java.util.*;
import java.io.*;
//import javax.swing.*;

public class RegistroCivil {
 //private JFrame mainFrame;
    private ArrayList personas = new ArrayList();
    private ArrayList personasMenoresEdad = new ArrayList();
    private ArrayList personasMayoresEdad = new ArrayList();
    private ArrayList personasAdultosMayores = new ArrayList();
    private HashMap mapaPersonasPorEdad = new HashMap();
    
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
    public void manejarMapa(){
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
    
    
    public void mostrarMenu() throws IOException{
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
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\PC RST GALAX\\Documents\\NetBeansProjects\\Gestión de Registro Civil\\build\\classes\\datos3"))){
            System.out.println("Cargando archivo CSV. . .");
            String linea;
            while((linea = reader.readLine()) != null){
                String[] datos = linea.split(";");
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
    
    public static void main(String args[]) throws IOException{
        
        RegistroCivil regCivil = new RegistroCivil();
        
        regCivil.registrarPersonas();
        regCivil.manejarListasEdades();
        regCivil.manejarMapa();
        regCivil.mostrarMenu();

        

    }
    
    
    
}
