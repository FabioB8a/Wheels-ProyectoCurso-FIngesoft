package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import wheels.Controlador.CEscenarios;
import wheels.Modelo.*;

import java.io.IOException;

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
        if (campotexto.verificarInicio(correoElectronico.getText(), contrasena.getText())) {
            CEscenarios.cambiarVista(event, "RutasPasajero.fxml");
        } else {
            System.out.println("usuario y contraseña incorrectos");
        }
    }
}
