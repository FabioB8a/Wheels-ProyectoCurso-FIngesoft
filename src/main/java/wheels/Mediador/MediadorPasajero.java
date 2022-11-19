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
        if(pasDAO.obtenerCorreo(correoInstitucional) == null)
            return false;
        return true;
    }

    @Override
    public boolean registrar(PasajeroDTO pasDTO) {
        pasDAO.crear(pasDTO);
        return true;
    }

}
