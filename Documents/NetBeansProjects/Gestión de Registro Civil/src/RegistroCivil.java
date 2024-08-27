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
        
        reader.close();
    }
    
    
    public static void mostrarMenu(ArrayList personas, ArrayList listaPersonasMenores, ArrayList listaPersonasMayores, ArrayList listaAdMayores) throws IOException{
        int opcion;
        do {
            System.out.println("---------------------------------");
            System.out.println("        MENÚ DE OPCIONES");
            System.out.println("---------------------------------");
            System.out.println("1) Agregar personas a la lista ");
            System.out.println("2) Ver lista de personas por edad");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            opcion = Integer.parseInt(reader.readLine());
            
            if(opcion == 1){
                agregarPersona(personas);
            } else if(opcion == 2){
                System.out.println("Estamos trabajando para usted :vv");
            } else if(opcion == 3) {
                System.out.println("Saliendo del menú. . .");
            }
            
        } while(opcion != 3);
        
    } 
    
    public static void main(String args[]) throws IOException {
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
        
        mostrarMenu(personas, listaPersonasMenoresEdad, listaPersonasMayoresEdad,listaPersonasAdultosMayores);
        
        
       // BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        
        //p1.presentarse();

    }
}
