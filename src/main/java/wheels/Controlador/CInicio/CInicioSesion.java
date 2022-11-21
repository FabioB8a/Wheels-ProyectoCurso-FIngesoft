package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import wheels.Controlador.CEscenarios;
import wheels.Modelo.*;

import java.io.IOException;
import java.util.Objects;

public class CInicioSesion {

    @FXML
    private TextField correoElectronico;
    @FXML
    private PasswordField contrasena;

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @FXML
    void btnInicioSesion(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Verificacion verificacion = new Verificacion();
        Pasajero pasajero = new Pasajero();
        Conductor conductor = new Conductor();

        if (verificacion.verificarInicio(correoElectronico.getText(), contrasena.getText()) != null) {
            if (Objects.equals(verificacion.verificarInicio(correoElectronico.getText(), contrasena.getText()), "pasajero")) {
                CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CInicioPasajero","InicioPasajero.fxml",correoElectronico.getText());
                System.out.println("pasajero");
            } else if (Objects.equals(verificacion.verificarInicio(correoElectronico.getText(), contrasena.getText()), "conductor")){
                System.out.println("conductor1");
                CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CInicioConductor","InicioConductor.fxml",correoElectronico.getText());
                System.out.println("conductor2");
            }

        } else {
            System.out.println("usuario y contraseña incorrectos");
        }
    }
}
