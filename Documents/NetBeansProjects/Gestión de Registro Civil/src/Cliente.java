public class Cliente extends Persona {
    
    private Boolean tieneAntecedentes;
    private Pasaporte pasaporte;
    
    public Cliente(int edad, String nombre, String rut, Lugar lugarNacimiento, Fecha fechaNacimiento, Boolean tieneAntecedentes){
        super(edad, nombre, rut, lugarNacimiento, fechaNacimiento);
        this.tieneAntecedentes = tieneAntecedentes;
    }
    
    public void setPasaporte(Pasaporte p){
        this.pasaporte = p;
    }
    
    public Boolean getTieneAntecedentes(){
        return tieneAntecedentes;
    }
    
    public void setTieneAntecedentes(Boolean ant){
        this.tieneAntecedentes = ant;
    }  
}
