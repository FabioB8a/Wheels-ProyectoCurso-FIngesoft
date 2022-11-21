package wheels.Mediador;

import wheels.Persistencia.DAO.*;
import wheels.Persistencia.DTO.ConductorDTO;

public class MediadorConductor implements IMediadorConductor {

    private static MediadorConductor singleton;
    protected ConductorDAO conDAO;
    protected RutaDAO rutaDAO;

    private MediadorConductor()
    {
        conDAO = new ConductorDAO();
        rutaDAO = new RutaDAO();
    }

    public static MediadorConductor obtenerMediador()
    {
        if(singleton==null)
        {
            singleton = new MediadorConductor();
        }
        return singleton;
    }

    @Override
    public boolean evaluarExistencia(String correoInstitucional) {
        if(conDAO.obtenerCorreo(correoInstitucional) == null){
            return false;
        }
        return true;
    }

    public boolean evaluarRegistro(String correoInstitucional, String contrasenia)
    {
        if(contrasenia.equals(conDAO.obtenerContrasena(correoInstitucional))){
            return false;
        }
        return true;
    }

    @Override
    public boolean registrar(ConductorDTO conDTO) {
        conDAO.crear(conDTO);
        return true;
    }

    @Override
    public String evaluarNombre(Object llave) {
        return conDAO.obtenerConsultaNombre(llave);
    }

    @Override
    public String evaluarContrasena(Object llave) {
        return conDAO.obtenerContrasena(llave);
    }

    @Override
    public String evaluaruniversidad(Object llave) {
        return conDAO.obtenerConsultaUniversidad(llave);
    }

    @Override
    public String evaluartelefono(Object llave) {
        return conDAO.obtenerConsultaTelefono(llave);
    }

    @Override
    public String evaluarCedula(Object llave) {
        return conDAO.obtenerConsultaCedula(llave);
    }

    @Override
    public String evaluarMarca(Object llave) {
        return conDAO.obtenerConsultaMarca(llave);
    }

    @Override
    public String evaluarModelo(Object llave) {
        return conDAO.obtenerConsultaModelo(llave);
    }

    @Override
    public String evaluarPlaca(Object llave) {
        return conDAO.obtenerConsultaPlaca(llave);
    }

    @Override
    public String evaluarPoliza(Object llave) {
        return conDAO.obtenerConsultaPoliza(llave);
    }

    @Override
    public String evaluarChasis(Object llave) {
        return conDAO.obtenerConsultaChasis(llave);
    }
}
