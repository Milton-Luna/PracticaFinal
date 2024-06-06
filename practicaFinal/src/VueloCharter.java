public class VueloCharter extends Vuelo {
    private String operador;
    private String fechaVuelo;

    public VueloCharter(String origen, String destino, String duracion, String compania, String modeloAvion, int plazas, String operador, String fechaVuelo) {
        super(origen, destino, duracion, plazas);
        this.operador = operador;
        this.fechaVuelo = fechaVuelo;
    }

    // Getters y Setters
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    @Override
    public String toString() {
        return super.toString() + " Es un vuelo charter operado por " + operador + " con fecha de vuelo " + fechaVuelo + ".";
    }
}
