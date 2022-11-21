package wheels.Persistencia.Mapper;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import wheels.Persistencia.DTO.ConductorDTO;
import wheels.Persistencia.DTO.PasajeroDTO;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaPasajerosDTO;

import java.util.ArrayList;

public class MapperImpl implements IMapper {
    private static MapperImpl singleton;

    private MapperImpl()
    {

    }
    public static MapperImpl obtenerMapperImpl()
    {
        if (singleton==null)
        {
            singleton = new MapperImpl();
        }
        return singleton;
    }


    @Override
    public Document DTOaDocumentoRuta(RutaConductorDTO pas) {
        Document documento = new Document();
        documento.append("idRuta",pas.getIdRuta());
        documento.append("nombreConductor",pas.getNombreConductor());
        documento.append("puntoOrigen",pas.getPuntoOrigen());
        documento.append("puntoLlegada",pas.getPuntoLlegada());
        documento.append("cantPasajeros",pas.getCantPasajeros());
        documento.append("horaLlegada",pas.getHoraLlegada());
        documento.append("horaSalida",pas.getHoraSalida());
        documento.append("zona",pas.getZona());
        return documento;
    }

    @Override
    public Document DTOaDocumentoConductor(ConductorDTO con) {
        Document documento = new Document();
        documento.append("nombreCompleto", con.getNombreCompleto());
        documento.append("nombreUsuario", con.getNombreUsuario());
        documento.append("contraseña", con.getContraseña());
        documento.append("universidad", con.getUniversidad());
        documento.append("telefono", con.getTelefono());
        documento.append("cedulaConductor", con.getCedulaConductor());
        documento.append("marcaAuto", con.getMarcaAuto());
        documento.append("modeloAuto", con.getModeloAuto());
        documento.append("placaAuto", con.getPlacaAuto());
        documento.append("polizaAuto", con.getPolizaAuto());
        documento.append("chasisAuto", con.getChasisAuto());
        return documento;
    }

    @Override
    public Document DTOaDocumentoPasajero(PasajeroDTO pas) {
        Document documento = new Document();
        documento.append("nombreCompleto", pas.getNombreCompleto());
        documento.append("nombreUsuario", pas.getNombreUsuario());
        documento.append("contraseña", pas.getContraseña());
        documento.append("universidad", pas.getUniversidad());
        documento.append("telefono", pas.getTelefono());
        documento.append("codigo", pas.getCodigo());
        return documento;
    }
    @Override
    public ArrayList<RutaConductorDTO> DRPasajeroDTO(FindIterable<Document> rutasRef){
        ArrayList<RutaConductorDTO> rutasPasajero = new ArrayList<RutaConductorDTO>();
        // Recorre FindIterable
        for (Document doc: rutasRef)
        {
            rutasPasajero.add(new RutaConductorDTO(doc.get("idRuta").toString(),doc.get("puntoOrigen").toString(),doc.get("puntoLlegada").toString(),(Integer)doc.get("cantPasajeros"),doc.get("horaLlegada").toString(),doc.get("horaSalida").toString(),doc.get("zona").toString(),doc.get("nombreConductor").toString()));
        }
        return rutasPasajero;
    }

    @Override
    public ArrayList<RutaPasajerosDTO> DRConductorDTO(FindIterable<Document> rutasRef){
        ArrayList<RutaPasajerosDTO> rutasConductor = new ArrayList<RutaPasajerosDTO>();
        // Recorre FindIterable
        for (Document doc: rutasRef)
        {
            rutasConductor.add(new RutaPasajerosDTO(doc.get("idRuta").toString(),doc.get("puntoOrigen").toString(),doc.get("puntoLlegada").toString(),(Integer)doc.get("cantPasajeros"),doc.get("horaLlegada").toString(),doc.get("horaSalida").toString(),doc.get("zona").toString(),(ArrayList<String>) doc.get("Usuarios")));
        }
        return rutasConductor;
    }
}