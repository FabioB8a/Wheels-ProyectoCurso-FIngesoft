package wheels.Persistencia.DTO;

public class RutaConductorDTO extends RutaDTO {
    String nombreConductor;

    public RutaConductorDTO(String idRuta, String puntoOrigen, String puntoLlegada, Integer cantPasajeros, String horaLlegada, String horaSalida, String zona, String nombreConductor) {
        super(idRuta, puntoOrigen, puntoLlegada, cantPasajeros, horaLlegada, horaSalida, zona);
        this.nombreConductor = nombreConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }
}