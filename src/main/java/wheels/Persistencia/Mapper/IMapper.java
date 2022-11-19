package wheels.Persistencia.Mapper;

import com.mongodb.client.FindIterable;
import org.bson.Document;

import wheels.Persistencia.DTO.ConductorDTO;
import wheels.Persistencia.DTO.PasajeroDTO;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaPasajerosDTO;

import java.util.ArrayList;

public interface IMapper {
    Document DTOaDocumentoRuta(RutaConductorDTO ref);
    Document DTOaDocumentoConductor(ConductorDTO con);
    Document DTOaDocumentoPasajero(PasajeroDTO pas);
    ArrayList<RutaConductorDTO> DRPasajeroDTO(FindIterable<Document> rutasRef);
    ArrayList<RutaPasajerosDTO> DRConductorDTO(FindIterable<Document> rutasRef);
}
