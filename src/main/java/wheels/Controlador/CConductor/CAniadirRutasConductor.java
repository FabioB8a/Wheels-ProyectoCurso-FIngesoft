package wheels.Controlador.CConductor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorRuta;
import wheels.Mediador.VerificacionTexto;
import wheels.Persistencia.DTO.RutaConductorDTO;

import java.io.IOException;

public class CAniadirRutasConductor implements ICInformacion {

    String llave;

    private static final MediadorRuta mediador = MediadorRuta.obtenerMediador();

    private static final VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();

    @FXML
    private TextField cantPasajeros;

    @FXML
    private TextField horaLlegada;

    @FXML
    private TextField horaSalida;

    @FXML
    private TextField idRuta;

    @FXML
    private Label lblAdvertencia;

    @FXML
    private TextField puntoLlegada;

    @FXML
    private TextField puntoOrigen;

    @FXML
    private TextField zona;

    @FXML
    void btnCreacion(ActionEvent event) {
        if(verificacionTexto.verificarTextoVacio(idRuta.getText(),cantPasajeros.getText(),horaLlegada.getText(),
                horaSalida.getText(),puntoLlegada.getText(),puntoOrigen.getText(),zona.getText()))
        {
            lblAdvertencia.setText("Por favor, digita todos los campos correspondientes.");
            return;
        }
        if(!verificacionTexto.verificarEsNumero(cantPasajeros.getText()))
        {
            lblAdvertencia.setText("La cantidad de pasajeros debe ser un número.");
            return;
        }
        if(mediador.evaluarExistencia(idRuta.getText()))
        {
            lblAdvertencia.setText("Identifiacion de ruta repetido, intente con otro ID");
            return;
        }
        mediador.crear(new RutaConductorDTO(idRuta.getText(),puntoOrigen.getText(),puntoLlegada.getText(), Integer. parseInt(cantPasajeros.getText()),horaLlegada.getText(),horaSalida.getText(),zona.getText(),llave));
        lblAdvertencia.setText("Ruta creada correctamente");
    }

    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CInicioConductor","InicioConductor.fxml",llave);
    }

    @FXML
    void btnRutasEscogidas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CConsultarRutasConductor","RutasConsultarConductor.fxml",llave);
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

    @Override
    public void inicializarInformacion(Object llave) {
        this.llave = (String) llave;
    }

}
