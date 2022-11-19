package wheels.Persistencia.DAO;

import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.PasajeroDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import wheels.Persistencia.Mapper.MapperImpl;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PasajeroDAO implements IOperacionesCRUD<PasajeroDTO> {

    private static final Conexion conexion = Conexion.obtenerConexion();
    private static final MapperImpl mapper = MapperImpl.obtenerMapperImpl();
    private static MongoCollection<Document> pasajeros = (conexion.getDb()).getCollection("Pasajero");



    @Override
    public void crear(PasajeroDTO ref) {
        Document documento = mapper.DTOaDocumentoPasajero(ref);
        pasajeros.insertOne(documento);
    }

    @Override
    public void eliminar(Object llave) {
        pasajeros.deleteOne(Filters.eq("nombreUsuario",llave.toString()));
    }

    @Override
    public void actualizar(Object llave) {

    }

    @Override
    public String obtenerConsulta(Object llave) {
        return (String) pasajeros.find(eq("nombreUsuario",llave)).first().get("nombreCompleto");
    }

    @Override
    public List<PasajeroDTO> obtenerConsultas() {
        return null;
    }


    public String obtenerCorreo(Object llave) {
        try{
            return (String) pasajeros.find(eq("nombreUsuario",llave)).first().get("nombreUsuario");
        }catch (RuntimeException e){
            return null;
        }
    }
}
