package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import wheels.Controlador.CEscenarios;

import java.io.IOException;

public class CInicioSesion {
    @FXML
    private TextField contrasenia;

    @FXML
    private TextField correoElectronico;

    @FXML
    void btnInicioSesion(ActionEvent event) {

    }

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"VistaPrincipal.fxml");
    }

}
