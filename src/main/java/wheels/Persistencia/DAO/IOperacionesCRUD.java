package wheels.Persistencia.DAO;

import wheels.Persistencia.DTO.PasajeroDTO;

import java.util.List;

public interface IOperacionesCRUD <Plantilla>{

    public void crear(Plantilla ref);
    public void eliminar(Object llave);
    public void actualizar(Object llave);
    public Object obtenerConsulta(Object llave);
    public List<Plantilla> obtenerConsultas();

}
