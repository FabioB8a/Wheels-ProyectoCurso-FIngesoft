package wheels.Persistencia.DTO;

import lombok.Getter;
import lombok.Setter;

public class RutaConductorDTO extends RutaDTO {
    @Getter
    @Setter
    String nombreConductor;

    public RutaConductorDTO(String idRuta, String puntoOrigen, String puntoLlegada, Integer cantPasajeros, String horaLlegada, String horaSalida, String zona, String nombreConductor) {
        super(idRuta, puntoOrigen, puntoLlegada, cantPasajeros, horaLlegada, horaSalida, zona);
        this.nombreConductor = nombreConductor;
    }

}