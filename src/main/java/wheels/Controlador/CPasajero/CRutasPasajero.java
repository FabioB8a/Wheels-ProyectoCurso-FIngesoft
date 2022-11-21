package wheels.Controlador.CPasajero;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import wheels.Controlador.CEscenarios;
import wheels.Controlador.ICInformacion;
import wheels.Mediador.MediadorRuta;
import wheels.Persistencia.Mapper.MapperImpl;

import java.io.IOException;


public class CRutasPasajero implements ICInformacion {

    private static final MediadorRuta mediador = MediadorRuta.obtenerMediador();
    @FXML
    private GridPane gridPane;

    private String llave;

    @Override
    public void inicializarInformacion(Object llave) {

        this.llave = (String) llave;
        for (int i = 0; i < mediador.evaluarRutasNoPasajero((String) llave).size(); i++) {

            Button boton = new Button("Punto de origen: " + mediador.evaluarRutasNoPasajero((String) llave).get(i).getPuntoOrigen() +
                    "\nPunto de llegada: " + mediador.evaluarRutasNoPasajero((String) llave).get(i).getPuntoLlegada() +
                    "\nHora de llegada: " + mediador.evaluarRutasNoPasajero((String) llave).get(i).getHoraLlegada() +
                    "\nHora de Salida: " + mediador.evaluarRutasNoPasajero((String) llave).get(i).getHoraSalida() +
                    "\nZona: " + mediador.evaluarRutasNoPasajero((String) llave).get(i).getZona());
            boton.setMaxWidth(371);
            boton.setPrefHeight(200);
            boton.setStyle("-fx-background-color: #74b4d6");

            gridPane.add(boton, 0, i + 1);
        }
    }


    @FXML
    void btnSalida(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnInicio(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event, "wheels.Controlador.CPasajero.CInicioPasajero", "InicioPasajero.fxml", llave);
    }

    @FXML
    void btnRutas(ActionEvent event) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CEscenarios.cambiarVistaInfo(event, "wheels.Controlador.CPasajero.CRutasPasajero", "RutasPasajero.fxml", llave);
    }

    @FXML
    void btnVolver(ActionEvent event) throws IOException {
        CEscenarios.cambiarVista(event, "VistaPrincipal.fxml");
    }
}
