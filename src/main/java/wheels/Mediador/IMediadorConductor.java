package wheels.Mediador;

import wheels.Persistencia.DTO.ConductorDTO;

public interface IMediadorConductor {

    boolean evaluarExistencia(String correoInstitucional);
    boolean registrar(ConductorDTO pasDTO);
    Object evaluarNombre(Object llave);
    Object evaluarContrasena(Object llave);
    Object evaluaruniversidad(Object llave);
    Object evaluartelefono(Object llave);
    Object evaluarCedula(Object llave);
    Object evaluarMarca(Object llave);
    Object evaluarModelo(Object llave);
    Object evaluarPlaca(Object llave);
    Object evaluarPoliza(Object llave);
    Object evaluarChasis(Object llave);
}
