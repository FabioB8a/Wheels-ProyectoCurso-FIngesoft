package wheels.Controlador.CConductor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import wheels.Controlador.CEscenarios;
import wheels.Modelo.CampoTexto;
import wheels.Persistencia.DAO.IOperacionesCRUD;
import wheels.Persistencia.DAO.PasajeroDAO;
import wheels.Persistencia.DTO.ConductorDTO;

import java.io.IOException;

public class CRegistroConductor {

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

    // IMPORTANTE - Excepciones
    @FXML
    void btnRegistro (ActionEvent event) throws IOException {

        IOperacionesCRUD c = new PasajeroDAO();
        CampoTexto campotexto = new CampoTexto();

        if (campotexto.verificarRegistroConductor(nombreCompleto.getText(), correoInstitucional.getText(), contrasenia.getText(), universidad.getText(), numTelefono.getText(), cedula.getText(),marca.getText(), modelo.getText(), placa.getText(), numeroPoliza.getText(), numeroChasis.getText())) {
            c.crear(new ConductorDTO(nombreCompleto.getText(), correoInstitucional.getText(), contrasenia.getText(), universidad.getText(), numTelefono.getText(), cedula.getText(),marca.getText(), modelo.getText(), placa.getText(), numeroPoliza.getText(), numeroChasis.getText()));
            System.out.println("Conductor registrado");
            CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
        }
        else {
            System.out.println("No se puede registrar, verificar campos");
        }
    }

    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }
}
