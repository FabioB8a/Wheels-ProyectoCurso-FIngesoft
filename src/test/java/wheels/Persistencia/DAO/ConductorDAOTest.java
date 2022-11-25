package wheels.Persistencia.DAO;

import org.junit.jupiter.api.Test;
import wheels.Persistencia.DTO.ConductorDTO;
import wheels.Persistencia.DTO.PasajeroDTO;

import static org.junit.jupiter.api.Assertions.*;

class ConductorDAOTest {

    @Test
    void crear() {
        ConductorDAO conductorDAO = new ConductorDAO();
        ConductorDTO conductorDTO = new ConductorDTO("sandra@gmail.com",
                "Daadawn", "3f11d","Javeriana", "3405058308",
                "1018905988","Chevrolet","Antiguo","was123",
                "ER","PER");
        conductorDAO.crear(conductorDTO);
    }

    @Test
    void eliminar() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.eliminar("pedro@gmail.com");
    }

    @Test
    void actualizar() {
        ConductorDAO conductorDAO = new ConductorDAO();
        ConductorDTO  conductorDTO= new ConductorDTO("sandra@gmail.com",
                "rgfd", "123","Javeriana", "3405058308",
                "1018905518","Chevrolet","Antiguo","HCy980",
                "ER","PEROS");
        conductorDAO.actualizar(conductorDTO);
    }

    @Test
    void obtenerConsulta() {
        ConductorDAO conductorDAO = new ConductorDAO();
        assertEquals(conductorDAO.obtenerConsulta("pedro@gmail.com"), null);
    }

    @Test
    void obtenerConsultas() {
        ConductorDAO conductorDAO = new ConductorDAO();
        assertEquals(conductorDAO.obtenerConsultas(), null);
    }

    @Test
    void obtenerConsultaExistencia() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaExistencia("pedro@gmail.com");
    }

    @Test
    void obtenerCorreo() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerCorreo("pedro@gmail.com");
    }

    @Test
    void obtenerContrasena() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerContrasena("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaNombre() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaNombre("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaUniversidad() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaUniversidad("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaTelefono() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaTelefono("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaCedula() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaCedula("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaMarca() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaMarca("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaModelo() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaModelo("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaPlaca() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaPlaca("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaPoliza() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaPoliza("pedro@gmail.com");
    }

    @Test
    void obtenerConsultaChasis() {
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.obtenerConsultaChasis("pedro@gmail.com");
    }
}