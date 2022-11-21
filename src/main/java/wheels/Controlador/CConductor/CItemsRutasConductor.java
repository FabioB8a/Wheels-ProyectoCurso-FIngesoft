package wheels.Controlador.CConductor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import wheels.Persistencia.DTO.RutaPasajerosDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CItemsRutasConductor implements Initializable {
    @FXML
    private Label lblAuto;

    @FXML
    private Label lblCelular;

    @FXML
    private Label lblHLlegada;

    @FXML
    private Label lblHSalida;

    @FXML
    private Label lblPtoEncuentro;

    @FXML
    private Label lblPtoSalida;

    @FXML
    private Label lblUsuarioA;

    @FXML
    private Label lblUsuarioB;

    @FXML
    private Label lblUsuarioC;

    @FXML
    private Label lblZona;

    @FXML
    private Label lblidRuta;public void setDatos(RutaPasajerosDTO r, String nombreConductor, String autoConductor, String celularConductor)
    {
        lblAuto.setText(autoConductor);
        lblCelular.setText(celularConductor);
        lblidRuta.setText(r.getIdRuta());
        lblZona.setText(r.getZona());
        lblHLlegada.setText(r.getHoraLlegada());
        lblHSalida.setText(r.getHoraSalida());
        lblPtoEncuentro.setText(r.getPuntoOrigen());
        lblPtoSalida.setText(r.getPuntoLlegada());
        if(r.getNombrePasajeros() != null) {
            for (int i = 0; i < r.getNombrePasajeros().size(); i++) {
                if (i == 0) {
                    lblUsuarioA.setText(r.getNombrePasajeros().get(i));
                }
                if (i == 1) {
                    lblUsuarioB.setText(r.getNombrePasajeros().get(i));
                }
                if (i == 2) {
                    lblUsuarioC.setText(r.getNombrePasajeros().get(i));
                }
            }
        }
        else {
            lblUsuarioA.setText("No Usuarios :(");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
