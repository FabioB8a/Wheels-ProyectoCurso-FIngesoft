package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import wheels.Controlador.CEscenarios;

import java.io.IOException;

public class CRegistro {

    @FXML
    void btnConductor(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"RegistroConductor.fxml");
    }

    @FXML
    void btnPasajero(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"RegistroPasajero.fxml");
    }

    @FXML
    void btnSalir(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"VistaPrincipal.fxml");
    }
}
