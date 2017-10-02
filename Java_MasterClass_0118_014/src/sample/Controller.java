package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
	// si no ponemos @FXML nos da error, por que no se crea una instancia cuando se llama al controlador
    @FXML
    private TextField nameField;

    @FXML
    public void onAction() {
        System.out.println("Hello, " + nameField.getText());
    }
}
