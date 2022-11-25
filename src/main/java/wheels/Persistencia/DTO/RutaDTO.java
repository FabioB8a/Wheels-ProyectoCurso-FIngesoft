package wheels.Persistencia.DTO;

import lombok.Getter;
import lombok.Setter;

public abstract class RutaDTO {
    @Getter
    @Setter
    private String idRuta;
    @Getter
    @Setter
    private String puntoOrigen;
    @Getter
    @Setter
    private String puntoLlegada;
    @Getter
    @Setter
    private Integer cantPasajeros;
    @Getter
    @Setter
    private String horaLlegada;
    @Getter
    @Setter
    private String horaSalida;
    @Getter
    @Setter
    private String zona;

    public RutaDTO(String idRuta, String puntoOrigen, String puntoLlegada, Integer cantPasajeros, String horaLlegada, String horaSalida, String zona) {
        this.idRuta = idRuta;
        this.puntoOrigen = puntoOrigen;
        this.puntoLlegada = puntoLlegada;
        this.cantPasajeros = cantPasajeros;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.zona = zona;
    }

}