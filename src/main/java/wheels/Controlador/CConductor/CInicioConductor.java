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
    private Label nombreCompleto;
    @FXML
    private Label correoInstitucional ;
    @FXML
    private Label contrasenia;
    @FXML
    private Label universidad;
    @FXML
    private Label numTelefono;
    @FXML
    private Label cedula;
    @FXML
    private Label marca;
    @FXML
    private Label modelo;
    @FXML
    private Label placa;
    @FXML
    private Label numeroPoliza;
    @FXML
    private Label numeroChasis;


    @Override
    public void inicializarInformacion(Object llave) {
        this.nombreCompleto.setText(String.valueOf(mediador.evaluarNombre(llave)));
        this.correoInstitucional.setText(String.valueOf(llave));
        this.contrasenia.setText(String.valueOf(mediador.evaluarContrasena(llave)));
        this.universidad.setText(String.valueOf(mediador.evaluaruniversidad(llave)));
        this.numTelefono.setText(String.valueOf(mediador.evaluartelefono(llave)));
        this.cedula.setText(String.valueOf(mediador.evaluarCedula(llave)));
        this.marca.setText(String.valueOf(mediador.evaluarMarca(llave)));
        this.modelo.setText(String.valueOf(mediador.evaluarNombre(llave)));
        this.placa.setText(String.valueOf(mediador.evaluarPlaca(llave)));
        this.numeroPoliza.setText(String.valueOf(mediador.evaluarPoliza(llave)));
        this.numeroChasis.setText(String.valueOf(mediador.evaluarChasis(llave)));
    }

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CInicioConductor","InicioConductor.fxml",correoInstitucional.getText());
    }
    @FXML
    void btnRutas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CAniadirRutasConductor","RutasAniadirConductor.fxml",correoInstitucional.getText());
    }
    @FXML
    void btnVolver(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }
}
