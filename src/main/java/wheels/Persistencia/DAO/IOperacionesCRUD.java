package wheels.Persistencia.DAO;

import java.util.List;

public interface IOperacionesCRUD <Plantilla>{
    public void crear(Plantilla ref);
    public void eliminar(Object llave);
    public void actualizar(Plantilla ref);
    public String obtenerConsulta(Object llave);
    public List<Plantilla> obtenerConsultas();

}
