package wheels.Mediador;

import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DAO.RutaDAO;
import wheels.Persistencia.DTO.PasajeroDTO;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaDTO;

import java.util.ArrayList;

public class MediadorRuta implements IMediadorRuta {

    private static MediadorRuta singleton;
    protected RutaDAO rutaDAO;

    private MediadorRuta() {
        rutaDAO = new RutaDAO();
    }

    public static MediadorRuta obtenerMediador() {
        if (singleton == null) {
            singleton = new MediadorRuta();
        }
        return singleton;
    }


    @Override
    public boolean evaluarExistencia(String ruta) {
        if(rutaDAO.obteneridRuta(ruta) == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean crear(RutaConductorDTO rutaConductorDTO) {
        rutaDAO.crear(rutaConductorDTO);
        return true;
    }

    public boolean evaluarRepeticionPasajero(String correoPasajero, String idRuta)
    {
        if(rutaDAO.obtenerRutaPasajero(correoPasajero,idRuta)==null){
            return false;
        }
        return true;
    }

    public void aniadirPasajero(String idRuta, String correoPasajero)
    {
        rutaDAO.aniadirPasajero(idRuta,correoPasajero);
    }

    @Override
    public Object evaluarNombreUsuario(Object llave) {
        return rutaDAO.obtenerConsultaNombreUsuario(llave);
    }

    @Override
    public Object evaluarNombreConductor(Object llave) {
        return rutaDAO.obtenerConsultaNombreConductor(llave);
    }

    @Override
    public Object evaluarPuntoOrigen(Object llave) {
        return rutaDAO.obtenerConsultaPuntoOrigen(llave);
    }

    @Override
    public Object evaluarPuntoLlegada(Object llave) {
        return rutaDAO.obtenerConsultaPuntoLlegada(llave);
    }

    @Override
    public Object evaluarCantPasajeros(Object llave) {
        return rutaDAO.obtenerConsultaCantPasajeros(llave);
    }

    @Override
    public Object evaluarHoraLlegada(Object llave) {
        return rutaDAO.obtenerConsultaHoraLlegada(llave);
    }

    @Override
    public Object evaluarHoraSalida(Object llave) {
        return rutaDAO.obtenerConsultaHoraSalida(llave);
    }

    @Override
    public Object evaluarZona(Object llave) {
        return rutaDAO.obtenerConsultaZona(llave);
    }

    public ArrayList<RutaConductorDTO> evaluarRutasNoPasajero(String nombrePasajero)
    {
        return rutaDAO.consultarRutasNoPasajero(nombrePasajero);
    }
    public ArrayList<RutaConductorDTO> evaluarRutasPasajero(String nombrePasajero)
    {
        return rutaDAO.consultarRutasPasajero(nombrePasajero);
    }
}
