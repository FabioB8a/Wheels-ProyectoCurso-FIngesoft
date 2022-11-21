package wheels.Controlador.CConductor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorConductor;
import wheels.Mediador.MediadorRuta;
import wheels.Mediador.VerificacionTexto;
import wheels.Persistencia.DTO.RutaPasajerosDTO;

import java.io.IOException;
import java.util.ArrayList;

public class CConsultarRutasConductor implements ICInformacion {
    private static final MediadorRuta mediadorR = MediadorRuta.obtenerMediador();
    private static final MediadorConductor mediadorC = MediadorConductor.obtenerMediador();
    private static final VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
    String llave;
    ArrayList<RutaPasajerosDTO> rutas;
    @FXML
    private VBox pantallaDiseño;

    @Override
    public void inicializarInformacion(Object llave) {
        this.llave = (String) llave;
        rutas = mediadorR.evaluarRutasConductor(this.llave);
        for(RutaPasajerosDTO r: rutas)
        {
            FXMLLoader fxmlLoaderA = new FXMLLoader();
            fxmlLoaderA.setLocation(getClass().getResource("ItemsRuta.fxml"));
            try{
                HBox hBox = fxmlLoaderA.load();
                CItemsRutasConductor cIt = fxmlLoaderA.getController();
                cIt.setDatos(r,mediadorC.evaluarNombre(llave),mediadorC.evaluarPlaca(llave),mediadorC.evaluartelefono(llave));
                pantallaDiseño.getChildren().add(hBox);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    void btnAniadirRuta(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CAniadirRutasConductor","RutasAniadirConductor.fxml",llave);
    }
    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event,"wheels.Controlador.CConductor.CInicioConductor","InicioConductor.fxml",llave);
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
