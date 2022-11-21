package wheels.Mediador;

import wheels.Persistencia.DTO.PasajeroDTO;

public interface IMediadorPasajero {

    boolean evaluarExistencia(String correoInstitucional);

    boolean registrar(PasajeroDTO pasDTO);

    Object evaluarNombre(Object llave);

    Object evaluarContrasena(Object llave);

    Object evaluaruniversidad(Object llave);

    Object evaluartelefono(Object llave);

    Object evaluarCodigo(Object llave);

}

