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

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.eq;

public class RutaDAO implements IOperacionesCRUD<RutaConductorDTO> {

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
        rutas.deleteOne(Filters.eq("idRuta", llave.toString()));
    }

    @Override
    public void actualizar(RutaConductorDTO ref) {

    }

    // Consultas necesarias a utilizar


    @Override
    public String obtenerConsulta(Object llave) {
        return null;
    }

    @Override
    public List<RutaConductorDTO> obtenerConsultas() {
        return null;
    }

    // Consultas necesarias a utilizar

    public ArrayList<RutaConductorDTO> consultarRutasPasajero(String nombrePasajero) {
        BasicDBObject consultaNombre = new BasicDBObject("Usuarios", nombrePasajero);

        FindIterable<Document> rutasRef = rutas.find(consultaNombre);

        ArrayList<RutaConductorDTO> rutasRetorno = mapper.DRPasajeroDTO(rutasRef);

        return rutasRetorno;
    }

    public ArrayList<RutaConductorDTO> consultarRutasNoPasajero(String nombrePasajero) {
        BasicDBObject consultaBusqueda = new BasicDBObject("Usuarios", new BasicDBObject("$ne", nombrePasajero));

        FindIterable<Document> rutasRef = rutas.find(consultaBusqueda);

        ArrayList<RutaConductorDTO> rutasRetorno = mapper.DRPasajeroDTO(rutasRef);

        return rutasRetorno;
    }

    public ArrayList<RutaPasajerosDTO> consultarRutasConductores(String nombreConductor) {
        BasicDBObject consultaNombre = new BasicDBObject("nombreConductor", nombreConductor);
        FindIterable<Document> rutasRef = rutas.find(consultaNombre);
        ArrayList<RutaPasajerosDTO> rutasRetorno = mapper.DRConductorDTO(rutasRef);
        return rutasRetorno;
    }

    public void aniadirPasajero(String idRuta, String nombrePasajero) {
        BasicDBObject consultaBusqueda = new BasicDBObject();
        consultaBusqueda.append("idRuta", idRuta);

        BasicDBObject consultaActualizacion = new BasicDBObject();
        consultaActualizacion.append("$push",
                new BasicDBObject().append("Usuarios", nombrePasajero));

        rutas.findOneAndUpdate(consultaBusqueda, consultaActualizacion);
    }

    public String obteneridRuta(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("idRuta");
        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerRutaPasajero(Object nombrePasajero, Object idRuta) {
        try {
            BasicDBObject consultaBusqueda = new BasicDBObject();
            consultaBusqueda.append("Usuarios", nombrePasajero);
            consultaBusqueda.append("idRuta", idRuta);
            return (String) rutas.find(consultaBusqueda).first().get("idRuta");
        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaNombreUsuario(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("Usuarios");
        } catch (RuntimeException e) {
            return null;
        }

    }

    public String obtenerConsultaNombreConductor(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("nombreConductor");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaPuntoOrigen(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("puntoOrigen");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaPuntoLlegada(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("puntoLlegada");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaCantPasajeros(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("cantPasajeros");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaHoraLlegada(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("horaLlegada");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaHoraSalida(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("horaSalida");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public String obtenerConsultaZona(Object llave) {
        try {
            return (String) rutas.find(eq("idRuta", llave)).first().get("zona");

        } catch (RuntimeException e) {
            return null;
        }
    }

    public int obtenerTamanioRutas() {

        return (int) rutas.countDocuments();


    }


}




























