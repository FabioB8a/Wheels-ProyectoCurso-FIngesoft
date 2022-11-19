package wheels.Persistencia.DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaPasajerosDTO;
import wheels.Persistencia.Mapper.MapperImpl;

import java.util.ArrayList;
import java.util.List;

public class RutaDAO implements  IOperacionesCRUD<RutaConductorDTO>{

    private static final Conexion conexion = Conexion.obtenerConexion();
    private static final MapperImpl mapper = MapperImpl.obtenerMapperImpl();
    private static MongoCollection<Document> rutas = (conexion.getDb()).getCollection("Ruta");

    // La única persona en crear una ruta es el conductor.
    @Override
    public void crear(RutaConductorDTO ref) {
        Document documento = mapper.DTOaDocumentoRuta(ref);
        rutas.insertOne(documento);
    }

    @Override
    public void eliminar(Object llave) {
        rutas.deleteOne(Filters.eq("idRuta",llave.toString()));
    }
    // Consultas necesarias a utilizar
    @Override
    public void actualizar(Object llave) {

    }

    @Override
    public String obtenerConsulta(Object llave) {
        return null;
    }

    @Override
    public List<RutaConductorDTO> obtenerConsultas() {
        return null;
    }

    // Consultas necesarias a utilizar

    public ArrayList<RutaConductorDTO> consultarRutasPasajero(String nombrePasajero)
    {
        BasicDBObject consultaNombre=new BasicDBObject("Usuarios",nombrePasajero);

        FindIterable<Document> rutasRef = rutas.find(consultaNombre);

        ArrayList<RutaConductorDTO> rutasRetorno=mapper.DRPasajeroDTO(rutasRef);

        return rutasRetorno;
    }

    public ArrayList<RutaPasajerosDTO> consultarRutasConductores(String nombreConductor)
    {
        BasicDBObject consultaNombre=new BasicDBObject("nombreConductor",nombreConductor);
        FindIterable<Document> rutasRef = rutas.find(consultaNombre);
        ArrayList<RutaPasajerosDTO> rutasRetorno = mapper.DRConductorDTO(rutasRef);
        return rutasRetorno;
    }
}
