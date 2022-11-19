package wheels.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CPrincipal {

    @FXML
    void btnIniciarSesion(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.PruebaInformacion","PruebaInformacion.fxml","Se logró");
        CEscenarios.cambiarVista(event,"InicioSesion.fxml");
    }

    @FXML
    void btnRegistro(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"Registro.fxml");
    }

}