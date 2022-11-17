package wheels.Modelo;


import wheels.Persistencia.DAO.*;

import java.util.Objects;

public class CampoTexto {

    public boolean verificarInicio(String correo, String contrasena) { // verifican que los text field no esten en null y redirige a metodo de consultas

        PasajeroDAO p = new PasajeroDAO();
        ConductorDAO c = new ConductorDAO();

        if (!Objects.equals(p.obtenerConsultaExistencia(correo), "null")) {
            return Objects.equals(p.obtenerConsulContrasena(correo), contrasena);
        } else if (!Objects.equals(c.obtenerConsultaExistencia(correo), "null")) {
            return Objects.equals(c.obtenerConsulContrasena(correo), contrasena);
        }
        return false;
    }

    public boolean verificarRegistroPasajero(String nombreCompleto, String correoInstitucional, String contrasenia, String universidad, String numTelefono, String codigoUniversidad) {

        PasajeroDAO p = new PasajeroDAO();
        if (!Objects.equals(nombreCompleto, "null") && !Objects.equals(correoInstitucional, "null") && !Objects.equals(contrasenia, "null") && !Objects.equals(universidad, "null") && !Objects.equals(numTelefono, "null") && !Objects.equals(codigoUniversidad, "null")) {
            return Objects.equals(p.obtenerConsultaExistencia(correoInstitucional), "null"); // si es igual a null quiere decir que no existe y se puede registrar
        }
        return false;
    }

    public boolean verificarRegistroConductor(String nombreCompleto, String correoInstitucional, String contrasenia, String universidad, String numTelefono, String codigoUniversidad) {

        ConductorDAO c = new ConductorDAO();
        if (!Objects.equals(nombreCompleto, "null") && !Objects.equals(correoInstitucional, "null") && !Objects.equals(contrasenia, "null") && !Objects.equals(universidad, "null") && !Objects.equals(numTelefono, "null") && !Objects.equals(codigoUniversidad, "null")) {
            return Objects.equals(c.obtenerConsultaExistencia(correoInstitucional), "null"); // si es igual a null quiere decir que no existe y se puede registrar
        }
        return false;
    }

}
