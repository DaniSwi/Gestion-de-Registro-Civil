public class Pasaporte {
    
    private Persona titular;
    private Lugar lugarNacimiento;
    private Fecha fechaNacimiento;
    private Fecha emisionDoc;
    private Fecha caducidadDoc;

    public Pasaporte(Persona titular, Lugar lugarNacimiento, Fecha fechaNacimiento, Fecha emisionDoc, Fecha caducidadDoc) {
        this.titular = titular;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.emisionDoc = emisionDoc;
        this.caducidadDoc = caducidadDoc;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
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

    public Persona getTitular() {
        return titular;
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