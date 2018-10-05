/**
 * Sample Skeleton for 'AlienView.fxml' Controller Class
 */

package Alien;

import java.net.URL;
import java.util.ResourceBundle;

import Alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AlienController {
	
	private String pattern1 = "(^([a-zA-Z]+)$)";
	private String pattern2 = "(^([a-zA-Z]+)([ ]{1})([a-zA-Z]+)$)";

	private AlienDictionary dizionario;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtInsert"
	private TextField txtInsert; // Value injected by FXMLLoader

	@FXML // fx:id="btnTranslate"
	private Button btnTranslate; // Value injected by FXMLLoader

	@FXML // fx:id="txtresults"
	private TextArea txtResults; // Value injected by FXMLLoader

	@FXML // fx:id="btnClear"
	private Button btnClear; // Value injected by FXMLLoader+*

	@FXML
	void doClear(ActionEvent event) {
		txtResults.setText("");
	}

	@FXML
	void doTranslate(ActionEvent event) {
		txtResults.setText("");
		String testo = txtInsert.getText();
		if (testo.matches(pattern1 + "||" + pattern2) && !testo.isEmpty())
			if (testo.matches(pattern1))
				txtResults.appendText(dizionario.translateWord(testo));
			else {
				String[] parolaTraduzione = testo.split(" ");
				txtResults.appendText(dizionario.addWord(parolaTraduzione[0], parolaTraduzione[1]));
			}
		else {
			txtInsert.setStyle("-fx-border-color:red;-fx-text-inner-color:red;-fx-background-insets: 0,0,0,0;");
			txtResults.appendText(
					"Il testo inserito non rispetta nessuna dei seguenti pattern:\n- <parola> \n- <parola> <traduzione>");
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert txtResults != null : "fx:id=\"txtresults\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'AlienView.fxml'.";
		txtInsert.setStyle("-fx-border-color:black;-fx-text-inner-color:black;-fx-background-insets: 1,1,1,1;");
		txtInsert.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				txtResults.setText("");
				String testo = txtInsert.getText();
				if (testo.matches(pattern1 + "||" + pattern2) || testo.isEmpty()) {
					txtInsert.setStyle(
							"-fx-border-color:black;-fx-text-inner-color:black;-fx-background-insets: 1,1,1,1;");
					btnTranslate.setDisable(false);
					if (arg0.getCharacter().hashCode() == 13)
						doTranslate(new ActionEvent());
				} else {
					txtInsert.setStyle("-fx-border-color:red;-fx-text-inner-color:red;-fx-background-insets: 0,0,0,0;");
					btnTranslate.setDisable(true);
					txtResults.appendText(
							"Il testo inserito non rispetta nessuna dei seguenti pattern:\n- <parola> \n- <parola> <traduzione>");
				}
			}
		});
	}

	public void setDizionario(AlienDictionary dizionario) {
		this.dizionario = dizionario;
	}

}
