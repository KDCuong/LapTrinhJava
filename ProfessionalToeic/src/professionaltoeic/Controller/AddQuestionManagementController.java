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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class AddQuestionManagementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void callQuestionManagerment(ActionEvent event) throws IOException {        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("FXML/QuestionManagement.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("QuestionManagement");
        stage.setScene(scene);
        stage.show();
     }
    
    public void callListeningQuestion(ActionEvent event) throws IOException {
        Question question = new Question();
        QuestionDAO.setQuestion(question);
        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ListeningQuestion");
     }
    
     public void callReadingQuestion(ActionEvent event) throws IOException {
        Question question = new Question();
        QuestionDAO.setQuestion(question);
        QuestionDAO.setFlag(2);
         
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ReadingQuestion");
     }
     
     public void callGrammarQuestion(ActionEvent event) throws IOException {
        Question question = new Question();
        QuestionDAO.setQuestion(question);
        QuestionDAO.setFlag(3);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("FXML/ReadingQuestion.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("GrammarQuestion");
        stage.setScene(scene);
        stage.show();
     }
}
