package wheels.Controlador.CPasajero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import wheels.Controlador.CEscenarios;
import wheels.Persistencia.DAO.IOperacionesCRUD;
import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DTO.PasajeroDTO;

import java.io.IOException;

public class CRegistroPasajero {

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
    // IMPORTANTE - Excepciones
    void btnRegistro(ActionEvent event) throws IOException {
        IOperacionesCRUD p = new PasajeroDAO();
        p.crear(new PasajeroDTO(nombreCompleto.getText(),correoInstitucional.getText(),contrasenia.getText(),universidad.getText(), numTelefono.getText(),codigoUniversidad.getText()));
        CEscenarios.cambiarVista(event,"VistaPrincipal.fxml");
    }

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event,"VistaPrincipal.fxml");
    }
}
