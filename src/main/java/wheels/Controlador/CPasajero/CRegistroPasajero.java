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
import wheels.Mediador.VerificacionTexto;
import wheels.Persistencia.DTO.PasajeroDTO;

import java.io.File;
import java.io.IOException;

public class CRegistroPasajero {
    // Llamado de mediador para verificar existencia dentro de la base de datos
    private static final MediadorPasajero mediador = MediadorPasajero.obtenerMediador();
    // Llamado verificación de texto para verificar campos de texto
    private static final VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();

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

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @FXML
    // Verificación campos de registro
    void btnRegistro(ActionEvent event) throws IOException{
        // Verifica que ningún campo se encuentre vacío.
        if(verificacionTexto.verificarTextoVacio(nombreCompleto.getText(),correoInstitucional.getText(),contrasenia.getText(),universidad.getText(), numTelefono.getText(),codigoUniversidad.getText()))
        {
            lblAdvertencia.setText("Recuerda digitar TODOS los campos.");
            return;
        }
        // Verifica que el número de teléfono es un número válido.
        if(!verificacionTexto.verificarEsNumero(numTelefono.getText()))
        {
            lblAdvertencia.setText("Número de teléfono inválido.");
            return;
        }
        // Verifica que el correo posee una estructura válida.
        if(!verificacionTexto.verificarEsCorreo(correoInstitucional.getText()))
        {
            lblAdvertencia.setText("Correo electrónico inválido.");
            return;
        }
        // Evalúa que no se encuentre repetido dentro de la base de datos
        if(mediador.evaluarExistencia(correoInstitucional.getText()))
        {
            lblAdvertencia.setText("Usuario repetido, verifique los datos");
            return;
        }
        // Si cumple todas las condiciones se crea el pasajero, se informa en pantalla y se cambia de scene
        mediador.registrar(new PasajeroDTO(nombreCompleto.getText(),correoInstitucional.getText(),contrasenia.getText(),universidad.getText(), numTelefono.getText(),codigoUniversidad.getText()));
        lblAdvertencia.setText("Usuario registrado correctamente");
        CEscenarios.cambiarVista(event,"InicioSesion.fxml");
    }

    @FXML
    void btnImagen(ActionEvent event) {
        try{
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            Image image = new Image(selectedFile.toURI().toString());
            imgRef.setImage(image);
        }catch(NullPointerException e)
        {
            lblAdvertencia.setText("Seleccione una fotografía, por favor.");
        }
    }
}
