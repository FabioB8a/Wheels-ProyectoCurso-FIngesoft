package wheels.Persistencia.DAO;

import org.junit.jupiter.api.Test;
import wheels.Persistencia.DTO.RutaConductorDTO;

import static org.junit.jupiter.api.Assertions.*;

class RutaDAOTest {

    @Test
    void crear() {
        RutaDAO rutaDAO = new RutaDAO();
        RutaConductorDTO rutaConductorDTO = new RutaConductorDTO("345",
                "Mosquera", "Javeriana", 4,
                "6","4", "Cundinamarca", "pedrito@gmail.com");
        rutaDAO.crear(rutaConductorDTO);
    }

    @Test
    void eliminar() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.eliminar("pedrito@gmail.com");
    }

    @Test
    void actualizar() {
        RutaDAO rutaDAO = new RutaDAO();
        RutaConductorDTO rutaConductorDTO = new RutaConductorDTO("345",
                "Mosquera", "Javeriana", 4,
                "6","4", "Cundinamarca", "pedrito@gmail.com");
        rutaDAO.actualizar(rutaConductorDTO);
    }

    @Test
    void obtenerConsulta() {
        RutaDAO rutaDAO = new RutaDAO();
        assertEquals(rutaDAO.obtenerConsulta("pedro@gmail.com"), null);
    }

    @Test
    void obtenerConsultas() {
        RutaDAO rutaDAO = new RutaDAO();
        assertEquals(rutaDAO.obtenerConsultas(), null);
    }

    @Test
    void consultarRutasPasajero() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.consultarRutasPasajero("pedrito@gmail.com");
    }


    @Test
    void consultarRutasNoPasajero() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.consultarRutasNoPasajero("pedrito@gmail.com");
    }

    @Test
    void consultarRutasConductores() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.consultarRutasConductores("pedrito@gmail.com");
    }

    @Test
    void aniadirPasajero() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.aniadirPasajero("345","pedrito@gmail.com" );
    }

    @Test
    void obteneridRuta() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obteneridRuta("pedrito@gmail.com" );
    }

    @Test
    void obtenerRutaPasajero() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerRutaPasajero("pedrito@gmail.com","345" );
    }
    @Test
    void consultarRutasPasajeroN() {
        RutaDAO rutaDAO = new RutaDAO();
        assertEquals(rutaDAO.obtenerRutaPasajero(null, null), null);

    }

    @Test
    void obtenerConsultaNombreUsuario() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaNombreUsuario("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaNombreConductor() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaNombreConductor("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaPuntoOrigen() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaPuntoOrigen("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaPuntoLlegada() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaPuntoLlegada("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaCantPasajeros() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaCantPasajeros("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaHoraLlegada() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaHoraLlegada("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaHoraSalida() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaHoraSalida("pedrito@gmail.com" );
    }

    @Test
    void obtenerConsultaZona() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerConsultaZona("pedrito@gmail.com" );
    }

    @Test
    void obtenerTamanioRutas() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.obtenerTamanioRutas( );
    }
}