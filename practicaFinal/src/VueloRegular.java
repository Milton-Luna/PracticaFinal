public class VueloRegular extends Vuelo {
    private String compania;
    private String modeloAvion;
    private String frecuencia;

    public VueloRegular(String origen, String destino, String duracion, String compania, String modeloAvion, int plazas, String frecuencia) {
        super(origen, destino, duracion, plazas);
        this.compania = compania;
        this.modeloAvion = modeloAvion;
        this.frecuencia = frecuencia;
    }

    // Getters y Setters
    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return super.toString() + " Es un vuelo regular operado por " + compania + " en un " + modeloAvion + " con frecuencia " + frecuencia + ".";
    }
}
