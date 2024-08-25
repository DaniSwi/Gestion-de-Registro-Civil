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
        
        
        
        //p1.presentarse();
        
        /*
        int edad = p1.getEdad();
        if(edad < 18){
            listaPersonasMenoresEdad.add(p1);
        } else if(edad >= 18){
            listaPersonasMayoresEdad.add(p1);
        } else {
            listaPersonasAdultosMayores.add(p1);
        }
        */
    }

}
