public class Lugar {
    String ciudad;
    String comuna;
    String region;
    
    public Lugar(String ciudad, String comuna, String region){
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public String mostrarLugar(){
        return (this.ciudad + ", en la comuna de " + this.comuna + ", en la región de " + this.region);
    }
    
}
