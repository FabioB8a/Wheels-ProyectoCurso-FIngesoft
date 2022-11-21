package wheels.Controlador.CPasajero;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorConductor;
import wheels.Mediador.MediadorPasajero;
import wheels.Mediador.MediadorRuta;
import wheels.Mediador.VerificacionTexto;
import wheels.Persistencia.DTO.RutaConductorDTO;

import java.io.IOException;
import java.util.ArrayList;

public class CAniadirRutasPasajero implements ICInformacion {

    private static final MediadorRuta mediadorR = MediadorRuta.obtenerMediador();
    private static final MediadorConductor mediadorC = MediadorConductor.obtenerMediador();
    private static final VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
    String llave;
    ArrayList<RutaConductorDTO> rutas;

    @FXML
    private TextField idRutaAgregar;
    @FXML
    private Label lblAdvertencia;

    @FXML
    private VBox pantallaDiseño;

    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CInicioPasajero","InicioPasajero.fxml",llave);
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

    @FXML
    void btnRutasEscogidas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CPasajero.CConsultarRutasPasajero","RutasConsultarPasajero.fxml",llave);
    }

    @FXML
    // Verificacion campo registro Ruta
    void btnValidacion(ActionEvent event) {
        if(verificacionTexto.verificarTextoVacio(idRutaAgregar.getText()))
        {
            lblAdvertencia.setText("Recuerde digitar la ruta antes de validar");
            return;
        }
        if(!mediadorR.evaluarExistencia(idRutaAgregar.getText()))
        {
            lblAdvertencia.setText("La ruta a seleccionar no existe");
            return;
        }
        if(mediadorR.evaluarRepeticionPasajero(llave,idRutaAgregar.getText()))
        {
            lblAdvertencia.setText("La ruta ya ha sido seleccionada");
            return;
        }
        lblAdvertencia.setText("La ruta a seleccionar existe");
        mediadorR.aniadirPasajero(idRutaAgregar.getText(),llave);
    }
    @Override
    public void inicializarInformacion(Object llave) {
        this.llave = (String) llave;
        rutas = mediadorR.evaluarRutasNoPasajero(this.llave);
        for(RutaConductorDTO r: rutas)
        {
            FXMLLoader fxmlLoaderA = new FXMLLoader();
            fxmlLoaderA.setLocation(getClass().getResource("ItemsRuta.fxml"));
            try{
                HBox hBox = fxmlLoaderA.load();
                CItemRutasPasajero cIt = fxmlLoaderA.getController();
                cIt.setDatos(r,mediadorC.evaluarNombre(r.getNombreConductor()),mediadorC.evaluarPlaca(r.getNombreConductor()),mediadorC.evaluartelefono(r.getNombreConductor()));
                pantallaDiseño.getChildren().add(hBox);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
