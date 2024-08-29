import java.util.*;
import java.io.*;

public class RegistroCivil {
    public static void registrarPersonas(ArrayList personas){
        Random random = new Random();
        for(int i=0;i<20;++i){
            Persona persona = new Persona(random.nextInt(100), "Test", "6.666.666-6", new Lugar("TestCiudad", "TestComuna", "TestRegión"), new Fecha(10, 10, 2010));
            personas.add(persona);
        }
    } 
    public static void mostrarLista(ArrayList lista){
        for(int i=0; i<lista.size(); ++i){
            Persona persona = (Persona)lista.get(i);
            persona.presentarse();
        }
    }
    public static void manejarListasEdades(ArrayList menores, ArrayList mayores, ArrayList adMayores, ArrayList personas) {
        for(int i=0; i<personas.size(); ++i){
            Persona persona = (Persona)personas.get(i);
            if(persona.getEdad() < 18){
                menores.add(persona);
            } else if(persona.getEdad() >= 18 && persona.getEdad() < 65){
                mayores.add(persona);
            } else {
                adMayores.add(persona);
            }
        }
    }
    public static void manejarMapa(HashMap mapa, ArrayList list){
        for(int i=0; i<list.size(); ++i){
            Persona persona = (Persona)list.get(i);
            mapa.put(persona.getEdad(), persona);
        }
    }
    public static void agregarPersona(ArrayList personas) throws IOException{
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

    public static void mostrarMenu(ArrayList personas, ArrayList listaPersonasMenores, ArrayList listaPersonasMayores, ArrayList listaAdMayores) throws IOException{
        int opcion;
        do {
            System.out.println("---------------------------------");
            System.out.println("        MENÚ DE OPCIONES");
            System.out.println("---------------------------------");
            System.out.println("1) Agregar personas a la lista ");
            System.out.println("2) Ver lista de personas por edad");
            System.out.println("3) Cargar archivo CSV de personas");
            System.out.println("4) Salir del menú");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            opcion = Integer.parseInt(reader.readLine());
            
            if(opcion == 1){
                agregarPersona(personas);
            } else if(opcion == 2){
                System.out.println("Estamos trabajando para usted :vv");
            } else if(opcion == 3) {
                leerCSV(personas);
            } else if(opcion == 4){
                System.out.println("Saliendo del menú. . .");
                reader.close();
            } else {
                System.out.println("Opción no válida, ingrese nuevamente.");
            }
            
        } while(opcion != 4);
        
    } 
    
    public static void leerCSV(ArrayList personas) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\PC RST GALAX\\Documents\\NetBeansProjects\\Gestión de Registro Civil\\build\\classes\\file.csv"))){
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
    
    public static void main(String args[]) throws IOException {
        
        System.out.println("Hola Chiquis!");
        HashMap mapaPersonasPorEdad = new HashMap();
        ArrayList listaPersonasMenoresEdad = new ArrayList();
        ArrayList listaPersonasMayoresEdad = new ArrayList();
        ArrayList listaPersonasAdultosMayores = new ArrayList();
        //Persona p1 = new Persona(20, "Juan", "20.726.245-6", new Lugar("El Belloto", "Quilpué", "Valparaíso"), new Fecha(10, 8, 2004));
        
        
        ArrayList personas = new ArrayList();
        registrarPersonas(personas);
        mostrarLista(personas);
        
        manejarListasEdades(listaPersonasMenoresEdad, listaPersonasMayoresEdad, listaPersonasAdultosMayores, personas);
        
        System.out.println("Aca van las listas, menores");
        mostrarLista(listaPersonasMenoresEdad);
        System.out.println("Mayores");
        mostrarLista(listaPersonasMayoresEdad);
        System.out.println("AdMayores");
        mostrarLista(listaPersonasAdultosMayores);
        
        manejarMapa(mapaPersonasPorEdad, personas);
        
        mostrarMenu(personas, listaPersonasMenoresEdad, listaPersonasMayoresEdad, listaPersonasAdultosMayores);
        
        
        
       // BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        
        //p1.presentarse();

    }
}
