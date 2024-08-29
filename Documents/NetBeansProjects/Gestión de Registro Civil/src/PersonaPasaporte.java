
public class PersonaPasaporte {
    private String nombre;
    private Lugar lugarNacimiento;
    private Fecha fechaNacimiento;
    private Fecha emisionDoc;
    private Fecha caducidadDoc;

    public PersonaPasaporte(String nombre, Lugar lugarNacimiento, Fecha fechaNacimiento, Fecha emisionDoc, Fecha caducidadDoc) {
        this.nombre = nombre;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.emisionDoc = emisionDoc;
        this.caducidadDoc = caducidadDoc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugarNacimiento(Lugar lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEmisionDoc(Fecha emisionDoc) {
        this.emisionDoc = emisionDoc;
    }

    public void setCaducidadDoc(Fecha caducidadDoc) {
        this.caducidadDoc = caducidadDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public Lugar getLugarNacimiento() {
        return lugarNacimiento;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Fecha getEmisionDoc() {
        return emisionDoc;
    }

    public Fecha getCaducidadDoc() {
        return caducidadDoc;
    }

}