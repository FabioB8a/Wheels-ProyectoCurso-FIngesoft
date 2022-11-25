package wheels.Mediador;

import org.junit.jupiter.api.Test;
import wheels.Persistencia.DAO.ConductorDAO;
import wheels.Persistencia.DAO.RutaDAO;
import wheels.Persistencia.DTO.ConductorDTO;

import static org.junit.jupiter.api.Assertions.*;

class MediadorConductorTest {

    @Test
    void obtenerMediador() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = mediadorConductor.conDAO;
        RutaDAO rutaDAO = mediadorConductor.rutaDAO;
        assertEquals(mediadorConductor.conDAO,conductorDAO);
        assertEquals(mediadorConductor.rutaDAO,rutaDAO);

    }

    @Test
    void evaluarExistencia() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDTO conductorDTO = new ConductorDTO("daniel",
                "Dan", "123","Javeriana", "3405058308",
                "1018905518","Chevrolet","Antiguo","HCU980",
                "ER","PER");
        ConductorDAO conductorDAO = new ConductorDAO();
        conductorDAO.crear(conductorDTO);
         String correo = "123";
       assertFalse(mediadorConductor.evaluarExistencia(correo));
    }
    @Test
    void evaluarExistenciaT(){
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        assertTrue(mediadorConductor.evaluarExistencia("Aurelio@uniandes.edu.co"));
    }

    @Test
    void evaluarRegistro() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDTO conductorDTO = new ConductorDTO("daniel",
                "Dan", "123","Javeriana", "3405058308",
                "1018905518","Chevrolet","Antiguo","HCU980",
                "ER","PER");
        assertTrue(mediadorConductor.evaluarRegistro("123",conductorDTO.getContraseña()));
    }
    @Test
    void evaluarRegistroF(){
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        assertFalse(mediadorConductor.evaluarRegistro("Aurelio@uniandes.edu.co","au64bet"));


    }
    @Test
    void registrar() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDTO conductorDTO = new ConductorDTO("daniel",
                "Dan", "123","Javeriana", "3405058308",
                "1018905518","Chevrolet","Antiguo","HCU980",
                "ER","PER");
        assertTrue(mediadorConductor.registrar(conductorDTO));

    }

    @Test
    void evaluarNombre() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaNombre(label), mediadorConductor.evaluarNombre(label));
    }

    @Test
    void evaluarContrasena() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerContrasena(label), mediadorConductor.evaluarContrasena(label));
    }

    @Test
    void evaluaruniversidad() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaUniversidad(label), mediadorConductor.evaluaruniversidad(label));
    }

    @Test
    void evaluartelefono() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaTelefono(label), mediadorConductor.evaluartelefono(label));
    }

    @Test
    void evaluarCedula() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaCedula(label), mediadorConductor.evaluarCedula(label));
    }

    @Test
    void evaluarMarca() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaMarca(label), mediadorConductor.evaluarMarca(label));
    }

    @Test
    void evaluarModelo() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaModelo(label), mediadorConductor.evaluarModelo(label));
    }

    @Test
    void evaluarPlaca() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaPlaca(label), mediadorConductor.evaluarPlaca(label));
    }

    @Test
    void evaluarPoliza() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaPoliza(label), mediadorConductor.evaluarPoliza(label));
    }

    @Test
    void evaluarChasis() {
        MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
        ConductorDAO conductorDAO = new ConductorDAO();
        Object label = "123";
        assertEquals(conductorDAO.obtenerConsultaChasis(label), mediadorConductor.evaluarChasis(label));
    }
}