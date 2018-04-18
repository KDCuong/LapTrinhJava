/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author cuong1312
 */
public class SceneMovement {
    public void callNewScene(ActionEvent event, String sceneName) throws IOException {        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("FXML/" + sceneName + ".fxml"));
        Scene scene = new Scene(root);
        stage.setTitle(sceneName);
        stage.setScene(scene);
        stage.show();
     }
}