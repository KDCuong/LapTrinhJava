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
    private Label lbname;
    @FXML
    private Label lbpoint;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbname.setText(UserDAO.getLoginUser().getFullname());
        lbpoint.setText(String.valueOf(UserDAO.getLoginUser().getPoint()));
    }    
    
    //Go to listening practice
    @FXML
    private void callListeningTest(ActionEvent event) throws IOException{
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ListeningTest");
    }
    
    //Go to Grammar practice
    @FXML
    private void callGrammarTest(ActionEvent event) throws IOException{
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "GrammaTest");
    }
    
    //Go to Reading practice
    @FXML
    private void callReadingTest(ActionEvent event) throws IOException{
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ReadingTest");
    }
    
    //Go back to Log in scene
    public void callLogIn(ActionEvent event) throws IOException {        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Login");
     }
    
    
}
