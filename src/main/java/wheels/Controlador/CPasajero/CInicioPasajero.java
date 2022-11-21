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
    private Label nombre;
    @FXML
    private Label correo;
    @FXML
    private Label contrasena;
    @FXML
    private Label universidad;
    @FXML
    private Label telefono;
    @FXML
    private Label codigo;

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CInicioPasajero","InicioPasajero.fxml",correo.getText());

    }
    @FXML
    void btnRutas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CAniadirRutasPasajero","RutasAniadirPasajero.fxml",correo.getText());

    }
    @FXML
    void btnVolver(ActionEvent event) throws IOException {

        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @Override
    public void inicializarInformacion(Object llave) {
        this.nombre.setText(String.valueOf(mediador.evaluarNombre(llave)));
        this.correo.setText(String.valueOf(llave));
        this.contrasena.setText(String.valueOf(mediador.evaluarContrasena(llave)));
        this.universidad.setText(String.valueOf(mediador.evaluaruniversidad(llave)));
        this.telefono.setText(String.valueOf(mediador.evaluartelefono(llave)));
        this.codigo.setText(String.valueOf(mediador.evaluarCodigo(llave)));
    }
}
