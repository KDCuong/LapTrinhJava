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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class AdministratorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void callQuestionManagerment(ActionEvent event) throws IOException {
         Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("FXML/QuestionManagement.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
    
    public void callUserManagerment(ActionEvent event) throws IOException {
         Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("FXML/UserManagement.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
}
