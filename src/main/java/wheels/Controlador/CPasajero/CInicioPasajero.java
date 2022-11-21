package wheels.Controlador.CPasajero;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorPasajero;

import java.io.IOException;

public class CInicioPasajero implements ICInformacion {

    private static final MediadorPasajero mediador = MediadorPasajero.obtenerMediador();
    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblCorreoElectronico;

    @FXML
    private Label lblNombreCompleto;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblUniversidad;
    @FXML
    void btnSalir(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnRutasEscogidas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CConsultarRutasPasajero","RutasConsultarPasajero.fxml",lblCorreoElectronico.getText());
    }
    @FXML
    void btnAniadirRuta(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CAniadirRutasPasajero","RutasAniadirPasajero.fxml",lblCorreoElectronico.getText());

    }
    @FXML
    void btnVolver(ActionEvent event) throws IOException {

        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @Override
    public void inicializarInformacion(Object llave) {
        this.lblNombreCompleto.setText(String.valueOf(mediador.evaluarNombre(llave)));
        this.lblCorreoElectronico.setText(String.valueOf(llave));
        this.lblUniversidad.setText(String.valueOf(mediador.evaluaruniversidad(llave)));
        this.lblTelefono.setText(String.valueOf(mediador.evaluartelefono(llave)));
        this.lblCodigo.setText(String.valueOf(mediador.evaluarCodigo(llave)));
    }
}
