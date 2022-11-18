package wheels.Modelo;

import wheels.Controlador.CPasajero.CInicioPasajero;
import wheels.Persistencia.DAO.PasajeroDAO;

public class Pasajero {

    public void informacion (String correo){

        PasajeroDAO p = new PasajeroDAO();

        CInicioPasajero cInicioPasajero = new CInicioPasajero();
        //cInicioPasajero.mostrarInformacion(p.obtenerConsultaNombre(correo),p.obtenerConsultaCorreo(correo),p.obtenerConsultaContrasena(correo),p.obtenerConsultaUniversidad(correo),p.obtenerConsultaTelefono(correo),p.obtenerConsultaCodigo(correo) );
        cInicioPasajero.mostrarInformacion(correo,correo,correo,correo,correo,correo );

    }
}
