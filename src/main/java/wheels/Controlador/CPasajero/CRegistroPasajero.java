package wheels.Controlador.CPasajero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import wheels.Controlador.CEscenarios;

import wheels.Mediador.MediadorPasajero;
import wheels.Persistencia.DTO.PasajeroDTO;

import java.io.File;
import java.io.IOException;

public class CRegistroPasajero {
    private static final MediadorPasajero mediador = MediadorPasajero.obtenerMediador();

    @FXML
    private TextField codigoUniversidad;
    @FXML
    private TextField contrasenia;
    @FXML
    private TextField correoInstitucional;
    @FXML
    private TextField nombreCompleto;
    @FXML
    private TextField numTelefono;
    @FXML
    private TextField universidad;
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
            mediador.registrar(new PasajeroDTO(nombreCompleto.getText(),correoInstitucional.getText(),contrasenia.getText(),universidad.getText(), numTelefono.getText(),codigoUniversidad.getText()));
            lblAdvertencia.setText("Usuario registrado correctamente");
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
