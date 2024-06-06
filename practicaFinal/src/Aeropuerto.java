import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String poblacion;
    private String pais;
    private int gmt;
    private List<Vuelo> vuelosSalida;
    private List<Vuelo> vuelosLlegada;

    public Aeropuerto(String codigo, String nombre, String poblacion, String pais, int gmt) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;
        this.gmt = gmt;
        this.vuelosSalida = new ArrayList<>();
        this.vuelosLlegada = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public String getPais() {
        return pais;
    }

    public int getGmt() {
        return gmt;
    }

    public void agregarVueloSalida(Vuelo vuelo) {
        vuelosSalida.add(vuelo);
    }

    public void agregarVueloLlegada(Vuelo vuelo) {
        vuelosLlegada.add(vuelo);
    }

    public List<Vuelo> getVuelosSalida() {
        return vuelosSalida;
    }

    public List<Vuelo> getVuelosLlegada() {
        return vuelosLlegada;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", pais='" + pais + '\'' +
                ", gmt=" + gmt +
                '}';
    }
}
