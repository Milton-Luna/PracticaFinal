public abstract class Vuelo {
    private String origen;
    private String destino;
    private String duracion;
    private int plazas;

    public Vuelo(String origen, String destino, String duracion, int plazas) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.plazas = plazas;
    }

    // Getters y Setters
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return "Vuelo de " + origen + " a " + destino + " con una duración de " + duracion + " y " + plazas + " plazas.";
    }
}
