package wheels.Controlador.CPasajero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorConductor;
import wheels.Mediador.MediadorPasajero;
import wheels.Mediador.MediadorRuta;
import wheels.Persistencia.DTO.RutaConductorDTO;

import java.io.IOException;
import java.util.ArrayList;

public class CAniadirRutasPasajero implements ICInformacion {

    private static final MediadorRuta mediadorR = MediadorRuta.obtenerMediador();
    private static final MediadorConductor mediadorC = MediadorConductor.obtenerMediador();
    String llave;
    ArrayList<RutaConductorDTO> rutas;

    @FXML
    private VBox pantallaDiseño;
    @Override
    public void inicializarInformacion(Object llave) {
        this.llave = (String) llave;
        rutas = mediadorR.evaluarRutasNoPasajero(this.llave);
        for(RutaConductorDTO r: rutas)
        {
            FXMLLoader fxmlLoaderA = new FXMLLoader();
            fxmlLoaderA.setLocation(getClass().getResource("ItemsRuta.fxml"));
            System.out.println(fxmlLoaderA);
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
