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

	private AlienDictionary dizionario = new AlienDictionary();

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtFind"
	private TextField txtFind; // Value injected by FXMLLoader

	@FXML // fx:id="txtTranslate"
	private TextField txtTranslate; // Value injected by FXMLLoader

	@FXML // fx:id="btnFind"
	private Button btnFind; // Value injected by FXMLLoader

	@FXML // fx:id="txtResults"
	private TextArea txtResults; // Value injected by FXMLLoader

	@FXML // fx:id="btnClear"
	private Button btnClear; // Value injected by FXMLLoader

	@FXML
	void doClear(ActionEvent event) {
		txtResults.clear();
	}

	@FXML
	void doTranslate(ActionEvent event) {
		txtResults.setText("");
		if (!txtFind.getText().isEmpty())
			if (txtTranslate.getText().isEmpty())
				txtResults.appendText(dizionario.translateWord(txtFind.getText()));
			else
				txtResults.appendText(dizionario.addWord(txtFind.getText(), txtTranslate.getText()));
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtFind != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert txtTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert btnFind != null : "fx:id=\"btnFind\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert txtResults != null : "fx:id=\"txtResults\" was not injected: check your FXML file 'AlienView.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'AlienView.fxml'.";

		txtFind.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCharacter().hashCode() == 13)
					txtTranslate.requestFocus();
			}
		});
		txtTranslate.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCharacter().hashCode() == 13)
					doTranslate(new ActionEvent());
			}
		});
	}

	public void setDizionario(AlienDictionary dizionario) {
		this.dizionario = dizionario;
	}
}
