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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import professionaltoeic.DAO.QuestionDAO;
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

    SceneMovement sm;

    /**
     * Initializes the controller class.
     *
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
    private void callListeningTest(ActionEvent event) throws IOException {
        QuestionDAO.setTypeQuestionFlag(1);
        sm = new SceneMovement();
        sm.callNewScene(event, "ListeningTest");
    }

    //Go to Grammar practice
    @FXML
    private void callGrammarTest(ActionEvent event) throws IOException {
        QuestionDAO.setTypeQuestionFlag(3);
        sm = new SceneMovement();
        sm.callNewScene(event, "GrammaTest");
    }

    //Go to Reading practice
    @FXML
    private void callReadingTest(ActionEvent event) throws IOException {
        QuestionDAO.setTypeQuestionFlag(2);
        sm = new SceneMovement();
        sm.callNewScene(event, "ReadingTest");
    }

    //Go back to Log in scene
    public void callLogIn(ActionEvent event) throws IOException {
        sm = new SceneMovement();
        sm.callNewScene(event, "Login");
    }

    //Move to Information Scene
    @FXML
    private void callUserSetting(ActionEvent event) throws IOException {
        sm = new SceneMovement();
        sm.callNewScene(event, "UpdateInformation");
    }

    //Move to test
    @FXML
    private void callToeicTest(ActionEvent event) throws IOException {
        QuestionDAO.setTypeQuestionFlag(4);
        sm = new SceneMovement();
        sm.callNewScene(event, "GrammaTest");
    }
    
    //Move to History Scene
    @FXML
    private void callHistory(ActionEvent event) throws IOException {
        sm = new SceneMovement();
        sm.callNewScene(event, "History");
    }
}
