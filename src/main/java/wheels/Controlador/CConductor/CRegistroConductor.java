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
import wheels.Mediador.VerificacionTexto;
import wheels.Persistencia.DTO.ConductorDTO;

import java.io.File;
import java.io.IOException;

public class CRegistroConductor {

    private static final MediadorConductor mediador = MediadorConductor.obtenerMediador();
    private static final VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
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

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    @FXML
    // Verificación campos de registro
    void btnRegistro(ActionEvent event) throws IOException{
        // Verifica que ningún campo se encuentre vacío.
        if(verificacionTexto.verificarTextoVacio(nombreCompleto.getText(),correoInstitucional.getText(),
                contrasenia.getText(),universidad.getText(), numTelefono.getText(),cedula.getText(),
                marca.getText(), modelo.getText(),placa.getText(),numeroPoliza.getText(),numeroChasis.getText()))
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
        if(mediador.evaluarExistencia(correoInstitucional.getText()))
        {
            lblAdvertencia.setText("Usuario repetido, verifique los datos");
        }
        else
        {
            mediador.registrar(new ConductorDTO(nombreCompleto.getText(),correoInstitucional.getText(),
                    contrasenia.getText(),universidad.getText(), numTelefono.getText(),cedula.getText(),
                    marca.getText(), modelo.getText(),placa.getText(),numeroPoliza.getText(),numeroChasis.getText()));
            lblAdvertencia.setText("Usuario registrado correctamente");
            CEscenarios.cambiarVista(event,"InicioSesion.fxml");
        }
    }

    @FXML
    void btnImagen(ActionEvent event) throws NullPointerException{
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
