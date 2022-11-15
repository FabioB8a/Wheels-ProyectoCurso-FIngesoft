package wheels.Persistencia.DAO;

import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.ConductorDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

public class ConductorDAO implements  IOperacionesCRUD<ConductorDTO>{
    private static final Conexion conexion = Conexion.obtenerConexion();

    private static MongoCollection<Document> conductores = (conexion.getDb()).getCollection("Conductor");

    @Override
    public void crear(ConductorDTO ref) {

        Document documento = new Document();
        documento.append("nombreCompleto", ref.getNombreCompleto());
        documento.append("nombreUsuario", ref.getNombreUsuario());
        documento.append("contraseña", ref.getContraseña());
        documento.append("universidad", ref.getUniversidad());
        documento.append("telefono", ref.getTelefono());
        documento.append("cedulaConductor", ref.getCedulaConductor());
        documento.append("marcaAuto", ref.getMarcaAuto());
        documento.append("modeloAuto", ref.getModeloAuto());
        documento.append("placaAuto", ref.getPlacaAuto());
        documento.append("polizaAuto", ref.getPolizaAuto());
        documento.append("chasisAuto", ref.getChasisAuto());

        conductores.insertOne(documento);
    }

    @Override
    public void eliminar(Object llave) {
        conductores.deleteOne(Filters.eq("nombreUsuario",llave.toString()));
    }

    @Override
    public void actualizar(ConductorDTO ref) {

    }

    @Override
    public ConductorDTO obtenerConsulta(Object llave) {
        return null;
    }

    @Override
    public List<ConductorDTO> obtenerConsultas() {
        return null;
    }
}
