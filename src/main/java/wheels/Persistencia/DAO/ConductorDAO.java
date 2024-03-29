package wheels.Persistencia.DAO;

import wheels.Persistencia.Conexion.Conexion;
import wheels.Persistencia.DTO.ConductorDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

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
    public String obtenerConsulta(Object llave) {
        return null;
    }

    @Override
    public List<ConductorDTO> obtenerConsultas() {
        return null;
    }

    public String obtenerConsultaExistencia(Object llave) {

        return String.valueOf(conductores.find(eq("nombreUsuario", llave)).first());
    }

    public String obtenerCorreo(Object llave) {
        try{
            return (String) conductores.find(eq("nombreUsuario",llave)).first().get("nombreUsuario");
        }catch (RuntimeException e){
            return null;
        }
    }

    public String obtenerContrasena(Object llave) {
        try{
            return (String) conductores.find(eq("nombreUsuario",llave)).first().get("contraseña");
        }catch (RuntimeException e){
            return null;
        }
    }

    public String obtenerConsultaNombre (Object llave) {
        try{
            return (String) conductores.find(eq("nombreUsuario",llave)).first().get("nombreCompleto");
        }catch (RuntimeException e){
            return null;
        }
    }
    public String obtenerConsultaUniversidad (Object llave) {
        try {
            return (String) conductores.find(eq("nombreUsuario", llave)).first().get("universidad");
        }catch (RuntimeException e){
            return null;
        }
    }
    public String obtenerConsultaTelefono (Object llave) {
        try{
            return (String) conductores.find(eq("nombreUsuario",llave)).first().get("telefono");
        }catch (RuntimeException e){
            return null;
        }
    }
    public String obtenerConsultaCedula (Object llave) {
try {
    return (String) conductores.find(eq("nombreUsuario", llave)).first().get("cedulaConductor");

}catch (RuntimeException e){
    return null;
}
    }
    public String obtenerConsultaMarca (Object llave) {
try {
    return (String) conductores.find(eq("nombreUsuario", llave)).first().get("marcaAuto");

} catch (RuntimeException e){
            return null;
        }
    }
    public String obtenerConsultaModelo (Object llave) {
try {
    return (String) conductores.find(eq("nombreUsuario", llave)).first().get("modeloAuto");

}catch (RuntimeException e){
    return null;
}
    }
    public String obtenerConsultaPlaca (Object llave) {
        try{
            return (String) conductores.find(eq("nombreUsuario",llave)).first().get("placaAuto");
        }catch (RuntimeException e){
            return null;
        }
    }
    public String obtenerConsultaPoliza (Object llave) {
try {
    return (String) conductores.find(eq("nombreUsuario", llave)).first().get("polizaAuto");

}catch (RuntimeException e){
    return null;
}
    }
    public String obtenerConsultaChasis (Object llave) {
try {
    return (String) conductores.find(eq("nombreUsuario", llave)).first().get("chasisAuto");
}
    catch (RuntimeException e){
            return null;
        }
    }
}
