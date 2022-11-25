package wheels.Mediador;

import org.junit.jupiter.api.Test;
import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DAO.RutaDAO;
import wheels.Persistencia.DTO.ConductorDTO;
import wheels.Persistencia.DTO.PasajeroDTO;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MediadorRutaTest {

    @Test
    void obtenerMediador() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        RutaDAO rutaDAO = mediadorRuta.rutaDAO;
        assertEquals(mediadorRuta.rutaDAO,rutaDAO);
    }
    @Test
    void evaluarExistencia() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        RutaDAO rutaDAO = new RutaDAO();
        RutaConductorDTO rutaConductorDTO = new RutaConductorDTO("123",
                "Mosquera", "Javeriana", 4,
                "6","4", "Cundinamarca", "daniel");
        rutaDAO.crear(rutaConductorDTO);
        String s = rutaDAO.obteneridRuta("123");
        assertTrue(mediadorRuta.evaluarExistencia(s));
    }
    @Test
    void evaluarExistenciaF(){
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        assertFalse(mediadorRuta.evaluarExistencia(null));
    }
    @Test
    void crear() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        RutaConductorDTO rutaConductorDTO = new RutaConductorDTO("123",
                "Mosquera", "Javeriana", 4,
                "6","4", "Cundinamarca", "daniel");
        assertTrue(mediadorRuta.crear(rutaConductorDTO));
    }

    @Test
    void evaluarRepeticionPasajero() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        RutaDAO rutaDAO = new RutaDAO();

        PasajeroDTO pasajeroDTO = new PasajeroDTO("daniel@gmail.com","Dan", "123",
                "Javeriana", "3405058308", "1018905518");

        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.crear(pasajeroDTO);
        rutaDAO.aniadirPasajero("123","daniel@gmail.com");
        assertTrue(mediadorRuta.evaluarRepeticionPasajero("daniel@gmail.com","123"));
    }
    @Test
    void evaluarRepeticionPasajeroF(){
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        assertFalse(mediadorRuta.evaluarRepeticionPasajero("123","dani"));
    }

    @Test
    void aniadirPasajero() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.aniadirPasajero("123", "marioHernan@javeriana.edu.co");
    }

    @Test
    void evaluarNombreUsuario() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
         mediadorRuta.evaluarNombreUsuario("001");
    }

    @Test
    void evaluarNombreConductor() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarNombreConductor("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarPuntoOrigen() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarPuntoOrigen("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarPuntoLlegada() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarPuntoLlegada("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarCantPasajeros() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarCantPasajeros("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarHoraLlegada() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarHoraLlegada("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarHoraSalida() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarHoraSalida("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarZona() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarZona("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarRutasNoPasajero() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarRutasNoPasajero("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarRutasPasajero() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarRutasPasajero("Aurelio@uniandes.edu.co");
    }

    @Test
    void evaluarRutasConductor() {
        MediadorRuta mediadorRuta = MediadorRuta.obtenerMediador();
        mediadorRuta.evaluarRutasConductor("Aurelio@uniandes.edu.co");
    }
}