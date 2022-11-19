package wheels.Mediador;

import wheels.Persistencia.DTO.PasajeroDTO;

public interface IMediadorPasajero {

    boolean evaluarExistencia(String correoInstitucional);
    boolean registrar(PasajeroDTO pasDTO);

}
