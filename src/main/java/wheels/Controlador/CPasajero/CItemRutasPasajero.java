package wheels.Controlador.CPasajero;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import wheels.Persistencia.DTO.RutaConductorDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CItemRutasPasajero implements Initializable {
    @FXML
    private Label lblAuto;

    @FXML
    private Label lblCelular;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblHLlegada;

    @FXML
    private Label lblHSalida;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblPtoEncuentro;

    @FXML
    private Label lblPtoSalida;

    public void setDatos(RutaConductorDTO r)
    {
        lblHLlegada.setText(r.getHoraLlegada());
        lblHSalida.setText(r.getHoraSalida());
        lblNombre.setText(r.getNombreConductor());
        lblPtoEncuentro.setText(r.getPuntoOrigen());
        lblPtoSalida.setText(r.getPuntoLlegada());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
