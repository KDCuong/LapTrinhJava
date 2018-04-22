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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Move to QuestionManagerment Scene
    public void callQuestionManagerment(ActionEvent event) throws IOException {        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "QuestionManagement");
     }
    
    //Move to add ListeningQuestion Scene
    public void callListeningQuestion(ActionEvent event) throws IOException {
        Question question = new Question();
        QuestionDAO.setQuestion(question);
        QuestionDAO.setTypePageFlag("Add");
        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ListeningQuestion");
     }
    
    //Move to add ReadingQuestion Scene
     public void callReadingQuestion(ActionEvent event) throws IOException {
        Question question = new Question();
        QuestionDAO.setQuestion(question);
        QuestionDAO.setTypeQuestionFlag(2);
        QuestionDAO.setTypePageFlag("Add");
         
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ReadingQuestion");
     }
     
     //Move to add GrammarQuestion Scene
     public void callGrammarQuestion(ActionEvent event) throws IOException {
        Question question = new Question();
        QuestionDAO.setQuestion(question);
        QuestionDAO.setTypeQuestionFlag(3);
        QuestionDAO.setTypePageFlag("Add");
        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "ReadingQuestion");
     }
}
