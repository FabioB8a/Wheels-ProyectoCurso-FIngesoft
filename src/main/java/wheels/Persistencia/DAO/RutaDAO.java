package wheels.Persistencia.DAO;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.RutaDTO;

import java.util.List;

public class RutaDAO implements  IOperacionesCRUD<RutaDTO>{

    private static final Conexion conexion = Conexion.obtenerConexion();

    private static MongoCollection<Document> rutas = (conexion.getDb()).getCollection("Ruta");
    @Override
    public void crear(RutaDTO ref) {
        Document documento = new Document();
        documento.append("idRuta", ref.getIdRuta());
        documento.append("puntoOrigen", ref.getPuntoOrigen());
        documento.append("puntoLlegada", ref.getPuntoLlegada());
        documento.append("cantPasajeros", ref.getCantPasajeros());
        documento.append("horaLlegada", ref.getHoraLlegada());
        documento.append("horaSalida", ref.getHoraSalida());

        rutas.insertOne(documento);
    }

    @Override
    public void eliminar(Object llave) {

    }

    @Override
    public void actualizar(RutaDTO ref) {

    }

    @Override
    public String obtenerConsulta(Object llave) {
        return null;
    }

    @Override
    public List<RutaDTO> obtenerConsultas() {
        return null;
    }
}
