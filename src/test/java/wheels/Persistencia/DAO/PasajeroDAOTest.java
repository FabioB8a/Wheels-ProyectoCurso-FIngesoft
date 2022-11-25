package wheels.Persistencia.DAO;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.PasajeroDTO;

import static org.junit.jupiter.api.Assertions.*;

class PasajeroDAOTest {

    @Test
    void crear() {
        PasajeroDTO pasajeroDTO = new PasajeroDTO("pedro@gmail.com","Dan", "123",
                "Javeriana", "3405058308", "1018905518");
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.crear(pasajeroDTO);
    }

    @Test
    void eliminar() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.eliminar("pedro@gmail.com");
    }

    @Test
    void actualizar() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        PasajeroDTO pasajeroDTO = new PasajeroDTO("pparc@gmail.com","car", "1334",
                "Javeriana", "3405658308", "1234412");
        pasajeroDAO.actualizar(pasajeroDTO);
    }

    @Test
    void obtenerConsulta() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        assertEquals(pasajeroDAO.obtenerConsulta("pedro@gmail.com"), null);
    }

    @Test
    void obtenerConsultas() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        assertEquals(pasajeroDAO.obtenerConsultas(), null);
    }

    @Test
    void obtenerConsultaExistencia() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerConsultaExistencia("Dan");
    }
    @Test
    void obtenerConsultaExistenciaN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerConsultaExistencia(nombre));
    }

    @Test
    void obtenerCorreo() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerCorreo("pedro@gmail.com");
    }
    @Test
    void obtenerConsultaCorreoN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerCorreo(nombre));
    }

    @Test
    void obtenerContrasena() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerContrasena("pedro@gmail.com");
    }
    @Test
    void obtenerContrasenaN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerContrasena(nombre));
    }
    @Test
    void obtenerConsultaNombre() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerConsultaNombre("pedro@gmail.com");
    }
    @Test
    void obtenerConsultaNombreN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerConsultaNombre(nombre));
    }
    @Test
    void obtenerConsultaUniversidad() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerConsultaUniversidad("pedro@gmail.com");
    }
    @Test
    void obtenerConsultaUniversidadN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerConsultaUniversidad(nombre));
    }
    @Test
    void obtenerConsultaTelefono() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerConsultaTelefono("pedro@gmail.com");
    }
    @Test
    void obtenerConsultaTelefonoN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerConsultaTelefono(nombre));
    }
    @Test
    void obtenerConsultaCodigo() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        pasajeroDAO.obtenerConsultaCodigo("pedro@gmail.com");
    }
    @Test
    void obtenerConsultaCodigoN() {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        Object nombre = new int[]{1, 2, 3};
        assertNull(pasajeroDAO.obtenerConsultaCodigo(nombre));
    }
}