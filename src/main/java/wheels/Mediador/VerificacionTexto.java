package wheels.Mediador;

import wheels.Persistencia.DAO.ConductorDAO;
import wheels.Persistencia.DAO.RutaDAO;

import java.util.Arrays;

public class VerificacionTexto implements IVerificacionTexto{

    private static VerificacionTexto singleton;

    private VerificacionTexto()
    {

    }

    public static VerificacionTexto obtenerVerificacion()
    {
        if(singleton==null)
        {
            singleton = new VerificacionTexto();
        }
        return singleton;
    }

    public boolean verificarTextoVacio(String...campos)
    {
        return Arrays.stream(campos).anyMatch(n->n.equals(""));
    }
}
