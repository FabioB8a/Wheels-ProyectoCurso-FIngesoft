package wheels.Controlador.CInicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import wheels.Controlador.CEscenarios;
import wheels.Mediador.MediadorConductor;
import wheels.Mediador.MediadorPasajero;
import wheels.Mediador.VerificacionTexto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CInicioSesion implements Initializable {

    // Llamado de dos mediadores: Verificación de existencia
    private static final MediadorPasajero mediadorPasajero = MediadorPasajero.obtenerMediador();
    private static final MediadorConductor mediadorConductor = MediadorConductor.obtenerMediador();
    //Llamado de la verifiación: Verificación String (Campos vacíos - Caracteres inválidos - etc)
    private static final VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();

    @FXML
    private PasswordField contrasenia;

    @FXML
    private TextField correoElectronico;

    @FXML
    private RadioButton bConductor;

    @FXML
    private RadioButton bPasajero;

    @FXML
    private Label lblAdvertencia;

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @FXML
    // Verificación campos de inicio de sesión
    void btnInicioSesion(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String rutaP = "wheels.Controlador.CPasajero.";
        String rutaC = "wheels.Controlador.CConductor.";

        // Primero, verificación de campos vacíos
        if (verificacionTexto.verificarTextoVacio(correoElectronico.getText(),contrasenia.getText()))
        {
            lblAdvertencia.setText("Recuerda digitar ambos campos.");
            return;
        }
        // En caso de que no se encuentren vacíos, verifica el botón que presionó el usuario
        // En caso de seleccionar pasajero, evalúa su existencia en base de datos
        if (bPasajero.isSelected())
        {
            if(!mediadorPasajero.evaluarRegistro(correoElectronico.getText(),contrasenia.getText()))
            {
                CEscenarios.cambiarVistaInfo(event,rutaP+"CInicioPasajero","InicioPasajero.fxml",correoElectronico.getText());
                return;
            }
        }
        // En caso de seleccionar conductor, evalúa su existencia en base de datos
        if (bConductor.isSelected())
        {
            if(!mediadorConductor.evaluarRegistro(correoElectronico.getText(),contrasenia.getText()))
            {
                CEscenarios.cambiarVistaInfo(event,rutaC+"CInicioConductor","InicioConductor.fxml",correoElectronico.getText());
                return;
            }
        }
        // En caso de no encontrarlo, arroja un mensaje de error al usuario
        lblAdvertencia.setText("Lo sentimos, no logramos encontrar tu cuenta.");
    }

    @Override
    // Inicialización selección de un RadioButton
    // OBJETIVO: Evitar selección de no error de RadioButton en ToggleGroup
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bPasajero.setSelected(true);
    }
}
