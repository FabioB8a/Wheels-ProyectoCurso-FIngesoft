package wheels.Modelo;


import wheels.Persistencia.DAO.*;

import java.util.Objects;

public class CampoTexto {

    public String verificarInicio(String correo, String contrasena) { // verifican que los text field no esten en null y redirige a metodo de consultas

        PasajeroDAO p = new PasajeroDAO();
        ConductorDAO c = new ConductorDAO();

        if (!Objects.equals(p.obtenerConsultaExistencia(correo), "null")) {
            if(Objects.equals(p.obtenerConsultaContrasena(correo), contrasena)){
                return "pasajero";
            }
        } else if (!Objects.equals(c.obtenerConsultaExistencia(correo), "null")) {
            if(Objects.equals(c.obtenerConsultaContrasena(correo), contrasena)){
                return "conductor";
            }
        }
        return null;
    }

    public boolean verificarRegistroPasajero(String nombreCompleto, String correoInstitucional, String contrasenia, String universidad, String numTelefono, String codigoUniversidad) {

        PasajeroDAO p = new PasajeroDAO();
        if (!Objects.equals(nombreCompleto, "null") || !Objects.equals(correoInstitucional, "null") || !Objects.equals(contrasenia, "null") || !Objects.equals(universidad, "null") || !Objects.equals(numTelefono, "null") || !Objects.equals(codigoUniversidad, "null")) {
            return Objects.equals(p.obtenerConsultaExistencia(correoInstitucional), "null"); // si es igual a null quiere decir que no existe y se puede registrar
        }
        System.out.println("Hay campos vacios");
        return false;
    }

    public boolean verificarRegistroConductor(String nombreCompleto, String nombreUsuario, String contrasena, String universidad, String telefono, String cedulaConductor, String marcaAuto, String modeloAuto, String placaAuto, String polizaAuto, String chasisAuto) {

        ConductorDAO c = new ConductorDAO();
        if (!Objects.equals(nombreCompleto, "null") && !Objects.equals(nombreUsuario, "null") && !Objects.equals(contrasena, "null") && !Objects.equals(universidad, "null")
                && !Objects.equals(telefono, "null") && !Objects.equals(cedulaConductor, "null") && !Objects.equals(marcaAuto, "null") && !Objects.equals(modeloAuto, "null")
                && !Objects.equals(placaAuto, "null") && !Objects.equals(polizaAuto, "null") && !Objects.equals(chasisAuto, "null")) {
            return Objects.equals(c.obtenerConsultaExistencia(nombreUsuario), "null"); // si es igual a null quiere decir que no existe y se puede registrar
        }
        return false;
    }

}
