package wheels.Mediador;

import org.junit.jupiter.api.Test;
import wheels.Persistencia.DAO.ConductorDAO;
import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DAO.RutaDAO;
import wheels.Persistencia.DTO.ConductorDTO;
import wheels.Persistencia.DTO.PasajeroDTO;

import static org.junit.jupiter.api.Assertions.*;

class MediadorPasajeroTest {

    @Test
    void obtenerMediador() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();

        PasajeroDAO pasajeroDAO = mediadorPasajero.pasDAO;
        RutaDAO rutaDAO = mediadorPasajero.rutaDAO;

        assertEquals(mediadorPasajero.pasDAO,pasajeroDAO);
        assertEquals(mediadorPasajero.rutaDAO,rutaDAO);
    }

    @Test
    void evaluarExistencia() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        PasajeroDTO pasajeroDTO = new PasajeroDTO("daniel","Dan", "123",
                "Javeriana", "3405058308", "1018905518");
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.crear(pasajeroDTO);
        String correo = "123";
        assertFalse(mediadorPasajero.evaluarExistencia(correo));
    }
    @Test
    void evaluarExistenciaT() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        assertTrue(mediadorPasajero.evaluarExistencia("marioHernan@javeriana.edu.co"));
    }
    @Test
    void evaluarRegistro() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        PasajeroDTO pasajeroDTO = new PasajeroDTO("daniel","Dan", "123",
                "Javeriana", "3405058308", "1018905518");
        assertTrue(mediadorPasajero.evaluarRegistro("123",pasajeroDTO.getContraseña()));
    }
    @Test
    void evaluarRegistroF() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        assertFalse(mediadorPasajero.evaluarRegistro("marioHernan@javeriana.edu.co","MarioJave"));
    }
    @Test
    void registrar() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        PasajeroDTO pasajeroDTO = new PasajeroDTO("daniel","Dan", "123",
                "Javeriana", "3405058308", "1018905518");
        assertTrue(mediadorPasajero.registrar(pasajeroDTO));
    }

    @Test
    void evaluarNombre() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        assertEquals(mediadorPasajero.evaluarNombre(mediadorPasajero), null);
    }

    @Test
    void evaluarContrasena() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        Object label = "123";
        assertEquals(null, mediadorPasajero.evaluarContrasena(label));
    }

    @Test
    void evaluaruniversidad() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        Object label = "123";
        assertEquals(null, mediadorPasajero.evaluaruniversidad(label));
    }

    @Test
    void evaluartelefono() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        Object label = "123";
        assertEquals(null, mediadorPasajero.evaluartelefono(label));
    }

    @Test
    void evaluarCodigo() {
        MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
        Object label = "123";
        assertEquals(null, mediadorPasajero.evaluarCodigo(label));
    }
}