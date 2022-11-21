package wheels.Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import wheels.Persistencia.DAO.ConductorDAO;
import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DTO.PasajeroDTO;

import java.io.IOException;

public class InicializacionApp extends Application {
    // Página principal - Inicialización del programa
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicializacionApp.class.getResource("VistaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wheels");
        stage.setScene(scene);
        stage.getIcons().add(new Image(InicializacionApp.class.getResourceAsStream("/wheels/imgRef/Iconos/iconoLogo.jpeg")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        PasajeroDAO pasajero = new PasajeroDAO();
        ConductorDAO conductor = new ConductorDAO();
        //conductor.crear(new ConductorDAO("Fabio Luis","Fabs8a@gmail.com","123","Nacional", "3212152768","KJ5fs56f46", "dasd", "fsdfdf" , "sdfsdfsdf", "sdfdf"));


        String dato = pasajero.obtenerConsultaExistencia("Fabio8A");
        System.out.println("la clave es: " + dato);
    }
}