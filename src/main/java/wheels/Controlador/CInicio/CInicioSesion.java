package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import wheels.Controlador.CEscenarios;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CInicioSesion implements Initializable {
    @FXML
    private PasswordField contrasenia;

    @FXML
    private TextField correoElectronico;

    @FXML
    private RadioButton bConductor;

    @FXML
    private RadioButton bPasajero;

    @FXML
    void btnInicioSesion(ActionEvent event) {

    }

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"VistaPrincipal.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
