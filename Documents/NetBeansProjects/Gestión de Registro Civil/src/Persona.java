public class Persona {
    private int edad;
    private String nombre;
    private String rut;
    private int vivo;
    // Donde nació?
    // Algun otro codigo?

    public Persona(int edad, String nombre, String rut) {
        this.edad = edad;
        this.nombre = nombre;
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
  
    
}
