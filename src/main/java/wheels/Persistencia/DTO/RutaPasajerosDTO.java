package wheels.Persistencia.DTO;

import java.util.ArrayList;

public class RutaPasajerosDTO extends RutaDTO{
    ArrayList<String> nombrePasajeros;

    public RutaPasajerosDTO(String idRuta, String puntoOrigen, String puntoLlegada, Integer cantPasajeros, String horaLlegada, String horaSalida, String zona,ArrayList<String> nombrePasajeros) {
        super(idRuta, puntoOrigen, puntoLlegada, cantPasajeros, horaLlegada, horaSalida, zona);
        this.nombrePasajeros = nombrePasajeros;
    }

    public ArrayList<String> getNombrePasajeros() {
        return nombrePasajeros;
    }

    public void setNombrePasajeros(ArrayList<String> nombrePasajeros) {
        this.nombrePasajeros = nombrePasajeros;
    }
}
