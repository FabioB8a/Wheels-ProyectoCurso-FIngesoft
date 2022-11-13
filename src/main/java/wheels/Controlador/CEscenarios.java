package wheels.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CEscenarios {

    // Cambio de vistas dado el evento y el nombre de la vista
    // Viaje de controladores
    public static void cambiarVista(ActionEvent event, String nombreVista) throws IOException {
        Parent raiz = FXMLLoader.load(CEscenarios.class.getResource(nombreVista));
        Stage escenario = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene escena = new Scene(raiz);
        escenario.getIcons().add(new Image(InicializacionApp.class.getResourceAsStream("/wheels/imgRef/Iconos/iconoLogo.jpeg")));
        escenario.setScene(escena);
        escenario.show();
    }
}
