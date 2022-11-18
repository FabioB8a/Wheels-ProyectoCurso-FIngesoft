module wheels.wheels {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;
    requires org.mongodb.bson;


    opens wheels.Controlador to javafx.fxml;
    exports wheels.Controlador;
    exports wheels.Controlador.CInicio;
    exports wheels.Controlador.CPasajero;
    exports wheels.Controlador.CConductor;
    opens wheels.Controlador.CInicio to javafx.fxml;
    opens wheels.Controlador.CPasajero to javafx.fxml;
    opens wheels.Controlador.CConductor to javafx.fxml;
}