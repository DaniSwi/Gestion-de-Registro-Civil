import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
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
        
        mostrarMenu(personas, listaPersonasMenoresEdad, listaPersonasMayoresEdad, listaPersonasAdultosMayores);
        
        
       // BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        
        //p1.presentarse();

    }
}
