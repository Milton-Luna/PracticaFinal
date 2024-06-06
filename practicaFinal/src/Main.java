import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, Aeropuerto> aeropuertos = new HashMap<>();

    public static void main(String[] args) {
        try {
            cargarDatosDesdeArchivo("src/datos.txt");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        mostrarVuelosSalida();
        mostrarVuelosLlegada();
    }

    private static void cargarDatosDesdeArchivo(String archivo) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
        String linea;

        while ((linea = reader.readLine()) != null) {
            if (linea.startsWith("#")) {
                continue; // Ignorar comentarios
            }

            String[] partes = linea.split(";");
            switch (partes[0]) {
                case "Aeropuertos":
                    break; // Header
                case "Vuelos":
                    break; // Header
                default:
                    if (partes.length == 5) { // Aeropuerto
                        String gmtStr = partes[4].replaceAll("[^\\d-]", "");
                        int gmt = Integer.parseInt(gmtStr);
                        Aeropuerto aeropuerto = new Aeropuerto(partes[0], partes[1], partes[2], partes[3], gmt);
                        aeropuertos.put(partes[0], aeropuerto);
                    } else if (partes.length == 9 || partes.length == 10) { // Vuelo
                        Aeropuerto origen = aeropuertos.get(partes[1]);
                        Aeropuerto destino = aeropuertos.get(partes[2]);

                        if (origen == null) {
                            System.err.println("Error: El aeropuerto de origen con código " + partes[1] + " no existe.");
                            continue;
                        }

                        if (destino == null) {
                            System.err.println("Error: El aeropuerto de destino con código " + partes[2] + " no existe.");
                            continue;
                        }

                        if (partes[0].equals("R")) {
                            VueloRegular vuelo = new VueloRegular(partes[1], partes[2], partes[3], partes[4], partes[5], Integer.parseInt(partes[6]), partes[7]);
                            origen.agregarVueloSalida(vuelo);
                            destino.agregarVueloLlegada(vuelo);
                        } else if (partes[0].equals("C")) {
                            VueloCharter vuelo = new VueloCharter(partes[1], partes[2], partes[3], partes[4], partes[5], Integer.parseInt(partes[6]), partes[7], partes[8]);
                            origen.agregarVueloSalida(vuelo);
                            destino.agregarVueloLlegada(vuelo);
                        }
                    }
                    break;
            }
        }

        reader.close();
    }

    private static void mostrarVuelosSalida() {
        for (Aeropuerto aeropuerto : aeropuertos.values()) {
            System.out.println("Vuelos de salida desde " + aeropuerto.getNombre() + ":");
            for (Vuelo vuelo : aeropuerto.getVuelosSalida()) {
                System.out.println(vuelo);
            }
        }
    }

    private static void mostrarVuelosLlegada() {
        for (Aeropuerto aeropuerto : aeropuertos.values()) {
            System.out.println("Vuelos de llegada a " + aeropuerto.getNombre() + ":");
            for (Vuelo vuelo : aeropuerto.getVuelosLlegada()) {
                System.out.println(vuelo);
            }
        }
    }
}
