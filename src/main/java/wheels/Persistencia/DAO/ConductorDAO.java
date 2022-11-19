package wheels.Persistencia.DAO;

import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.ConductorDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import wheels.Persistencia.Mapper.MapperImpl;

import java.util.List;

public class ConductorDAO implements  IOperacionesCRUD<ConductorDTO>{
    private static final Conexion conexion = Conexion.obtenerConexion();
    private static final MapperImpl mapper = MapperImpl.obtenerMapperImpl();
    private static MongoCollection<Document> conductores = (conexion.getDb()).getCollection("Conductor");

    @Override
    public void crear(ConductorDTO ref) {
        Document documento = mapper.DTOaDocumentoConductor(ref);
        conductores.insertOne(documento);
    }

    @Override
    public void eliminar(Object llave) {
        conductores.deleteOne(Filters.eq("nombreUsuario",llave.toString()));
    }

    @Override
    public void actualizar(Object llave) {

    }

    @Override
    public String obtenerConsulta(Object llave) {return null;}

    @Override
    public List<ConductorDTO> obtenerConsultas() {
        return null;
    }
}
