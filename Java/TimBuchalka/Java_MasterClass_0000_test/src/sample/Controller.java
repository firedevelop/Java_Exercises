package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller{
	@FXML
	private TextField name;
	
	@FXML
	public void onAction() {
		System.out.println(name.getText());
	}
}