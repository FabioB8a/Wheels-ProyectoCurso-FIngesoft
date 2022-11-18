package wheels.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PruebaInformacion  implements ICInformacion{
    @FXML
    private Label textoPrueba;

    public void setTextoPrueba(String textoPrueba) {

    }

    @Override
    public void inicializarInformacion(Object llave) {
        this.textoPrueba.setText(String.valueOf(llave));
    }


}
