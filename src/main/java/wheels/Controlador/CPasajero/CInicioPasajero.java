package wheels.Controlador.CPasajero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import wheels.Controlador.CEscenarios;
import wheels.Modelo.CampoTexto;
import wheels.Persistencia.DAO.IOperacionesCRUD;
import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DTO.PasajeroDTO;

import java.io.IOException;

public class CInicioPasajero {

    @FXML
    private Label nombre;

    @FXML
    private Label correo;

    @FXML
    private Label contrasena;

    @FXML
    private Label universidad;

    @FXML
    private Label telefono;

    @FXML
    private Label codigo;


    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }

    public void mostrarInformacion(String nombreCompleto, String correoInstitucional, String contrasenia, String Universidad, String numtelefono, String codigoU) {

        this.nombre.setText("nombreCompleto");
        this.correo.setText("correoInstitucional");
        this.contrasena.setText("contrasenia");
        this.universidad.setText("Universidad");
        this.telefono.setText("numtelefono");
        this.codigo.setText("codigoU");

    }
}
