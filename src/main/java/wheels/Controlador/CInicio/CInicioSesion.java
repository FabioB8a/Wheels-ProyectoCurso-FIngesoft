package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.CPasajero.*;
import wheels.Modelo.*;

import java.io.IOException;
import java.util.Objects;

public class CInicioSesion {
    @FXML
    private TextField contrasena;

    @FXML
    private TextField correoElectronico;

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @FXML
    void btnInicioSesion(ActionEvent event) throws IOException {

        CampoTexto campotexto = new CampoTexto();
        Pasajero pasajero = new Pasajero();
        Conductor conductor = new Conductor();

        if (campotexto.verificarInicio(correoElectronico.getText(), contrasena.getText()) != null) {
            if (Objects.equals(campotexto.verificarInicio(correoElectronico.getText(), contrasena.getText()), "pasajero")) {
                String correo = correoElectronico.getText();
                /*FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioPasajero.fxml"));
                Parent root = loader.load();
                CInicioPasajero cinicioPasajero = loader.getController();
                cinicioPasajero.mostrarInformacion("hola","hp;a","hola","hpad","holsf","gdfg");
                */
                pasajero.informacion(correo);


                CEscenarios.cambiarVista(event, "InicioPasajero.fxml");
            } else {
                //conductor.informacion(correoElectronico.getText());
                CEscenarios.cambiarVista(event, "InicioConductor.fxml");
            }

        } else {
            System.out.println("usuario y contraseña incorrectos");
        }
    }
}
