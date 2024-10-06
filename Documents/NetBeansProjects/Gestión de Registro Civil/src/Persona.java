/**
 * La clase Persona representa a una persona con nombre, edad, rut y lugar de nacimiento.
 */
public class Persona {
    
    private int edad;
    private String nombre;
    private String rut;
    private Lugar lugarNacimiento;
    private Fecha fechaNacimiento;

    /**
     * Constructor de la clase Persona.
     * 
     * @param edad La edad de la persona
     * @param nombre El nombre de la persona
     * @param rut El RUT de la persona
     * @param lugarNacimiento El lugar de nacimiento de la persona
     * @param fechaNacimiento La fecha de nacimiento de la persona
     */
    public Persona(int edad, String nombre, String rut, Lugar lugarNacimiento, Fecha fechaNacimiento) {
        this.edad = edad;
        this.nombre = nombre;
        this.rut = rut;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve la edad de la persona.
     * 
     * @return la edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     * 
     * @param edad La nueva edad.
     */
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
    
    public Lugar getLugarNacimiento(){
        return lugarNacimiento;
    }
    
    public void setLugarNacimiento(Lugar lugarNacimiento){
        this.lugarNacimiento = lugarNacimiento;
    }
    
    public Fecha getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Fecha fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void presentarse(){
        System.out.println("Hola me llamo " + this.nombre + ", tengo " + this.edad + " años, naci en " + lugarNacimiento.mostrarLugar());
    }
    
    public String presentarse(int n) {
        return nombre + " - " + edad + "años.\n";
    }
    
    public boolean esMayorEdad(){
        return this.edad >= 18;
    }    
}
