package wheels.Mediador;

import wheels.Persistencia.DAO.*;
import wheels.Persistencia.DTO.PasajeroDTO;

public class MediadorPasajero implements IMediadorPasajero {

    private static MediadorPasajero singleton;

    protected PasajeroDAO pasDAO;
    protected RutaDAO rutaDAO;

    private MediadorPasajero()
    {
        pasDAO = new PasajeroDAO();
        rutaDAO = new RutaDAO();
    }

    public static MediadorPasajero obtenerMediador()
    {
        if(singleton==null)
        {
            singleton = new MediadorPasajero();
        }
        return singleton;
    }

    @Override
    public boolean evaluarExistencia(String correoInstitucional) {
        if(pasDAO.obtenerCorreo(correoInstitucional) == null){
            return false;
        }
        return true;
    }

    public boolean evaluarRegistro(String correoInstitucional, String contrasenia)
    {
        if(contrasenia.equals(pasDAO.obtenerContrasena(correoInstitucional))){
            return false;
        }
        return true;
    }

    @Override
    public boolean registrar(PasajeroDTO pasDTO) {
        pasDAO.crear(pasDTO);
        return true;
    }

    @Override
    public Object evaluarNombre(Object llave) {
        return pasDAO.obtenerConsultaNombre(llave);
    }

    @Override
    public Object evaluarContrasena(Object llave) {
        return pasDAO.obtenerContrasena(llave);
    }


    @Override
    public Object evaluaruniversidad(Object llave){
        return pasDAO.obtenerConsultaUniversidad(llave);
    }

    @Override
    public Object evaluartelefono(Object llave){
        return pasDAO.obtenerConsultaTelefono(llave);
    }

    @Override
    public Object evaluarCodigo(Object llave){
        return pasDAO.obtenerConsultaCodigo(llave);
    }
}


