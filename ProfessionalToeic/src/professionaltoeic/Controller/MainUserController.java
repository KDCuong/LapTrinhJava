/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import professionaltoeic.DAO.UserDAO;


/**
 * FXML Controller class
 *
 * @author curly
 */
public class MainUserController implements Initializable {

    @FXML
    private Button btnListen;
    @FXML
    private Button btnGramma;
    @FXML
    private Button btnRead;
    @FXML
    private Label lbname;
    @FXML
    private Label lbpoint;
    @FXML
    private Button btnSetting;
    
    private LoginController lc;
    
    @FXML
    private void ButtonListening(ActionEvent event) throws IOException{
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setResizable(false);
                    Parent root = FXMLLoader.load(getClass().getResource("FXML/ListeningTest.fxml"));
                    Scene scene = new Scene(root);
                    stage.setTitle("Listening");
                    stage.setScene(scene);
                    stage.show();
    }
    @FXML
    private void ButtonGramma(ActionEvent event) throws IOException{
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setResizable(false);
                    Parent root = FXMLLoader.load(getClass().getResource("FXML/GrammaTest.fxml"));
                    Scene scene = new Scene(root);
                    stage.setTitle("Gramma");
                    stage.setScene(scene);
                    stage.show();
    }
    @FXML
    private void ButtonReading(ActionEvent event) throws IOException{
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setResizable(false);
                    Parent root = FXMLLoader.load(getClass().getResource("FXML/ReadingTest.fxml"));
                    Scene scene = new Scene(root);
                    stage.setTitle("Reading");
                    stage.setScene(scene);
                    stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbname.setText(UserDAO.getLoginUser().getFullname());
        lbpoint.setText(String.valueOf(UserDAO.getLoginUser().getPoint()));
        btnSetting.setVisible(false);
    }    
    
    public void callLogIn(ActionEvent event) throws IOException {        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Login");
     }
}
