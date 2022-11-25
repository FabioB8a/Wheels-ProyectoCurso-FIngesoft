package wheels.Persistencia.DAO;

import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.PasajeroDTO;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PasajeroDAO implements IOperacionesCRUD<PasajeroDTO> {

    private static final Conexion conexion = Conexion.obtenerConexion();
    private static MongoCollection<Document> pasajeros = (conexion.getDb()).getCollection("Pasajero");

    @Override
    public void crear(PasajeroDTO ref) {

        Document documento = new Document();
        documento.append("nombreCompleto", ref.getNombreCompleto());
        documento.append("nombreUsuario", ref.getNombreUsuario());
        documento.append("contraseña", ref.getContraseña());
        documento.append("universidad", ref.getUniversidad());
        documento.append("telefono", ref.getTelefono());
        documento.append("codigo", ref.getCodigo());

        pasajeros.insertOne(documento);
    }

    @Override
    public void eliminar(Object llave) {
        pasajeros.deleteOne(eq("nombreUsuario", llave.toString()));
    }

    @Override
    public void actualizar(PasajeroDTO ref) {

    }

    @Override
    public String obtenerConsulta(Object llave) {
        return null;
    }
    @Override
    public List<PasajeroDTO> obtenerConsultas() {
        return null;
    }
    public String obtenerConsultaExistencia(Object llave) {
        try {
            return String.valueOf(pasajeros.find(eq("nombreUsuario", llave)).first());
        } catch (RuntimeException e) {
            return null;
        }
    }
    public String obtenerCorreo(Object llave) {
        try {
            return (String) pasajeros.find(eq("nombreUsuario", llave)).first().get("nombreUsuario");
        } catch (RuntimeException e) {
            return null;
        }
    }
    public String obtenerContrasena(Object llave) {
        try {
            return (String) pasajeros.find(eq("nombreUsuario", llave)).first().get("contraseña");
        } catch (RuntimeException e) {
            return null;
        }
    }
    public String obtenerConsultaNombre(Object llave) {
        try {
            return (String) pasajeros.find(eq("nombreUsuario", llave)).first().get("nombreCompleto");
        } catch (RuntimeException e) {
            return null;
        }
    }
    public String obtenerConsultaUniversidad(Object llave) {
        try {
            return (String) pasajeros.find(eq("nombreUsuario", llave)).first().get("universidad");
        } catch (RuntimeException e) {
            return null;
        }
    }
    public String obtenerConsultaTelefono(Object llave) {
        try {
            return (String) pasajeros.find(eq("nombreUsuario", llave)).first().get("telefono");
        } catch (RuntimeException e) {
            return null;
        }
    }
    public String obtenerConsultaCodigo(Object llave) {
        try {
            return (String) pasajeros.find(eq("nombreUsuario", llave)).first().get("codigo");
        } catch (RuntimeException e) {
            return null;
        }
    }
}





















