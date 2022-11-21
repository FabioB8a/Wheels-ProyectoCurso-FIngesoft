package wheels.Controlador.CConductor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import wheels.Controlador.CEscenarios;
import wheels.Mediador.MediadorConductor;
import wheels.Persistencia.DTO.ConductorDTO;

import java.io.File;
import java.io.IOException;

public class CRegistroConductor {

    private static final MediadorConductor mediador = MediadorConductor.obtenerMediador();
    @FXML
    private TextField nombreCompleto;

    @FXML
    private TextField cedula;

    @FXML
    private TextField correoInstitucional;

    @FXML
    private TextField contrasenia;

    @FXML
    private TextField universidad;

    @FXML
    private TextField numTelefono;

    @FXML
    private TextField marca;
    @FXML
    private TextField modelo;
    @FXML
    private TextField placa;
    @FXML
    private TextField numeroPoliza;
    @FXML
    private TextField numeroChasis;
    @FXML
    private Label lblAdvertencia;
    @FXML
    private ImageView imgRef;

    // IMPORTANTE - Excepciones

    @FXML
    void btnRegistro(ActionEvent event) throws IOException{
        if(mediador.evaluarExistencia(correoInstitucional.getText()))
        {
            lblAdvertencia.setText("Usuario repetido, verifique los datos");
        }
        else
        {
            mediador.registrar(new ConductorDTO(nombreCompleto.getText(),correoInstitucional.getText(),
                    contrasenia.getText(),universidad.getText(), numTelefono.getText(),cedula.getText(),marca.getText(),
                    modelo.getText(),placa.getText(),numeroPoliza.getText(),numeroChasis.getText()));
            //lblAdvertencia.setText("Usuario registrado correctamente");
            CEscenarios.cambiarVista(event,"InicioSesion.fxml");
        }
    }

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @FXML
    void btnImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        Image image = new Image(selectedFile.toURI().toString());
        imgRef.setImage(image);
    }
}
