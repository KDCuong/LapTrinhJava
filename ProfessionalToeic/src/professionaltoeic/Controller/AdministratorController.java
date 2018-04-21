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
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class AdministratorController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void callQuestionManagerment(ActionEvent event) throws IOException {  
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "QuestionManagement");
     }
    
    public void callUserManagerment(ActionEvent event) throws IOException {        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "UserManagement");
     }
    
    public void callLogIn(ActionEvent event) throws IOException {        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Login");
     }
}
