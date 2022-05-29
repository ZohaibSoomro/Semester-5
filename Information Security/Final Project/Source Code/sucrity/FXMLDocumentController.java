/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucrity;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author adeel
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextArea encrypt_text_area;
    @FXML
    private TextArea decrypt_text_area;
    @FXML
    private Button encrypt_button;
    @FXML
    private TextField key_caecier;
    @FXML
    private AnchorPane asd;
    @FXML
    private Text warn_text;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private TextField alphabitc_key;
    @FXML
    private Button clear_button;

    @FXML
    private void clear(ActionEvent event) {
        encrypt_text_area.setText("");
        decrypt_text_area.setText("");
        key_caecier.setText("");
        alphabitc_key.setText("");
    }

    @FXML
    private void encrypt(ActionEvent event) {
        caeser_cipher c = new caeser_cipher();

        switch (choice.getValue()) {

            case "Caeser Cipher":

                try {
                    warn_text.setText("");
                    int y = Integer.parseInt(key_caecier.getText());
                    String s = c.Encrypted(encrypt_text_area.getText(), y);

                    decrypt_text_area.setText("");
                    encrypt_text_area.setText("");

                    decrypt_text_area.setText(s);
                } catch (Exception e) {

                    warn_text.setText(" key must be number !");

                    System.out.println("err" + e);

                }
                break;
            //----------------- Vigenere Cipher---------------------------------------
            /*case "Playfair Cipher":
			
			
    PlayfairCipherEncryption x = new PlayfairCipherEncryption();

			
		   x.setKey(key_caecier.getText());
				
                   x.KeyGen();
	String s =x.encryptMessage(encrypt_text_area.getText());

		    
                    decrypt_text_area.setText("");
                    encrypt_text_area.setText("");

                    decrypt_text_area.setText(s);

           
               
                break;*/
            //--------------------Atbash-------------------------
            //-----------------------------------
           
        }

    }
	//---------------------------------------

    @FXML
    private void decrypt(ActionEvent event) {
        caeser_cipher c = new caeser_cipher();

        switch (choice.getValue()) {

            case "Caeser Cipher":

                try {

                    warn_text.setText("");
                    int y = Integer.parseInt(key_caecier.getText());
                    String s = c.decrypt(decrypt_text_area.getText(), y);
                    encrypt_text_area.setText("");
                    decrypt_text_area.setText("");
                    encrypt_text_area.setText(s);
                } catch (Exception e) {

                    warn_text.setText(" key must be number !");

                    System.out.println("err" + e);

                }

                break;
				
				 /*case "Playfair Cipher":
				 
  PlayfairCipherEncryption x = new PlayfairCipherEncryption();

			
		   x.setKey(key_caecier.getText());
				
                   x.KeyGen();
	String s =x.decryptMessage(decrypt_text_area.getText());

		                        encrypt_text_area.setText("");

                    decrypt_text_area.setText("");

                    encrypt_text_area.setText(s);
				 
				                 break;
*/
         
          
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alphabitc_key.setVisible(false);

        choice.getItems().addAll("Caeser Cipher", "Playfair Cipher");
        choice.setValue("Caeser Cipher");

        choice.getSelectionModel().selectedItemProperty().addListener((v, old, ne)
                -> {
            decrypt_text_area.setText("");
            encrypt_text_area.setText("");
            key_caecier.setText("");

           
            if (choice.getValue() == "Custom Cipher") {
                alphabitc_key.setVisible(true);
                key_caecier.setVisible(true);

            } else {
                alphabitc_key.setVisible(false);
                key_caecier.setVisible(true);

            }

        });
    }

}
