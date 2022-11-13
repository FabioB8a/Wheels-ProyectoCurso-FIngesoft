package wheels.Persistencia.DTO;

public class RutaDTO {
    private String idRuta;
    private String puntoOrigen;
    private String puntoLlegada;
    private Integer cantPasajeros;
    private String horaLlegada;
    private String horaSalida;

    public RutaDTO(String idRuta, String puntoOrigen, String puntoLlegada, Integer cantPasajeros, String horaLlegada, String horaSalida) {
        this.idRuta = idRuta;
        this.puntoOrigen = puntoOrigen;
        this.puntoLlegada = puntoLlegada;
        this.cantPasajeros = cantPasajeros;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getPuntoOrigen() {
        return puntoOrigen;
    }

    public void setPuntoOrigen(String puntoOrigen) {
        this.puntoOrigen = puntoOrigen;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public Integer getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(Integer cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
}
