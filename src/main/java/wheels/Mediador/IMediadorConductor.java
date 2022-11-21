package wheels.Mediador;

import wheels.Persistencia.DTO.ConductorDTO;

public interface IMediadorConductor {

    boolean evaluarExistencia(String correoInstitucional);
    boolean registrar(ConductorDTO pasDTO);
    String evaluarNombre(Object llave);
    String evaluarContrasena(Object llave);
    String evaluaruniversidad(Object llave);
    String evaluartelefono(Object llave);
    String evaluarCedula(Object llave);
    String evaluarMarca(Object llave);
    String evaluarModelo(Object llave);
    String evaluarPlaca(Object llave);
    String evaluarPoliza(Object llave);
    String evaluarChasis(Object llave);
}
