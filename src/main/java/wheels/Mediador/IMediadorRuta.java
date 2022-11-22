package wheels.Mediador;

import wheels.Persistencia.DTO.PasajeroDTO;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaDTO;

public interface IMediadorRuta {

    boolean evaluarExistencia(String ruta);

    boolean crear(RutaConductorDTO rutaConductorDTO);

    Object evaluarNombreUsuario(Object llave);
    Object evaluarNombreConductor(Object llave);
    Object evaluarPuntoOrigen(Object llave);
    Object evaluarPuntoLlegada(Object llave);
    Object evaluarCantPasajeros(Object llave);
    Object evaluarHoraLlegada(Object llave);
    Object evaluarHoraSalida(Object llave);
    Object evaluarZona(Object llave);


}
