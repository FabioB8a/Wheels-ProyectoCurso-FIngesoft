package wheels.Persistencia.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class RutaPasajerosDTO extends RutaDTO {
    @Getter
    @Setter
    ArrayList<String> nombrePasajeros;

    public RutaPasajerosDTO(String idRuta, String puntoOrigen, String puntoLlegada, Integer cantPasajeros, String horaLlegada, String horaSalida, String zona, ArrayList<String> nombrePasajeros) {
        super(idRuta, puntoOrigen, puntoLlegada, cantPasajeros, horaLlegada, horaSalida, zona);
        this.nombrePasajeros = nombrePasajeros;
    }

}