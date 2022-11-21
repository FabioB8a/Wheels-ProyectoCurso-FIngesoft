package wheels.Controlador.CConductor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorConductor;

import java.io.IOException;

public class CInicioConductor implements ICInformacion {

    private static final MediadorConductor mediador = MediadorConductor.obtenerMediador();

    @FXML
    private Label lblChasis;

    @FXML
    private Label lblCorreoElectronico;

    @FXML
    private Label lblModelo;

    @FXML
    private Label lblNombreCompleto;

    @FXML
    private Label lblPlaca;

    @FXML
    private Label lblPoliza;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblUniversidad;

    @Override
    public void inicializarInformacion(Object llave) {
        this.lblNombreCompleto.setText(String.valueOf(mediador.evaluarNombre(llave)));
        this.lblCorreoElectronico.setText(String.valueOf(llave));
        this.lblUniversidad.setText(String.valueOf(mediador.evaluaruniversidad(llave)));
        this.lblTelefono.setText(String.valueOf(mediador.evaluartelefono(llave)));
        this.lblModelo.setText(String.valueOf(mediador.evaluarModelo(llave)));
        this.lblPlaca.setText(String.valueOf(mediador.evaluarPlaca(llave)));
        this.lblPoliza.setText(String.valueOf(mediador.evaluarPoliza(llave)));
        this.lblChasis.setText(String.valueOf(mediador.evaluarChasis(llave)));
    }

    @FXML
    void btnAniadirRuta(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CAniadirRutasConductor","RutasAniadirConductor.fxml",lblCorreoElectronico.getText());
    }

    @FXML
    void btnRutasEscogidas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CConsultarRutasConductor","RutasConsultarConductor.fxml",lblCorreoElectronico.getText());
    }

    @FXML
    void btnSalir(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnVolver(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }
}
