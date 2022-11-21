package wheels.Controlador.CConductor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorConductor;
import wheels.Mediador.MediadorPasajero;
import wheels.Mediador.MediadorRuta;
import wheels.Persistencia.DTO.PasajeroDTO;
import wheels.Persistencia.DTO.RutaConductorDTO;
import wheels.Persistencia.DTO.RutaDTO;

import java.io.IOException;

public class CRutasConductor implements ICInformacion {

    private static final MediadorRuta mediador = MediadorRuta.obtenerMediador();

    @FXML
    private TextField idRuta;
    @FXML
    private TextField puntoOrigen;
    @FXML
    private TextField puntoLlegada;
    @FXML
    private TextField cantPasajeros;
    @FXML
    private TextField horaLlegada;
    @FXML
    private TextField horaSalida;
    @FXML
    private TextField zona;
    @FXML
    private Label lblAdvertencia;
    private  String llave;

    @FXML
    void btnCreacion(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(mediador.evaluarExistencia(idRuta.getText()))
        {
            lblAdvertencia.setText("Identifiacion de ruta repetido, intente con otro ID");
        }
        else
        {
            System.out.println(llave);
            mediador.crear(new RutaConductorDTO(idRuta.getText(),puntoOrigen.getText(),puntoLlegada.getText(), Integer. parseInt(cantPasajeros.getText()),horaLlegada.getText(),horaSalida.getText(),zona.getText(),llave));
            lblAdvertencia.setText("Ruta creada correctamente");
            CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CInicioConductor","InicioConductor.fxml",llave);
        }
    }
    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CInicioConductor","InicioConductor.fxml",llave);
    }
    @FXML
    void btnRutas(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "RutasConductor.fxml");
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
