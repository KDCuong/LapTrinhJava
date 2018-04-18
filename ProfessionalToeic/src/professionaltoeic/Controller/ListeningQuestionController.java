/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class ListeningQuestionController implements Initializable {
    
    @FXML
    private TextArea txtContent;
    @FXML
    private TextField txtAudio;
    @FXML
    private TextField txtImage;
    @FXML
    private TextField txtAnwser1;
    @FXML
    private TextField txtAnwser2;
    @FXML
    private TextField txtAnwser3;
    @FXML
    private TextField txtAnwser4;
    @FXML
    private ToggleGroup GroupAnswer;
    
    private QuestionDAO qDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void callAddQuestionManagerment(ActionEvent event) throws IOException {        
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "AddQuestionManagement");
     }
    
    @FXML
    public void addListeningQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
        qDAO = new QuestionDAO();
        String rightAnswer;
        RadioButton selectedRB = (RadioButton) GroupAnswer.getSelectedToggle();
        String selectedValue = selectedRB.getText();
        if (selectedValue.equals("A ."))
            rightAnswer = txtAnwser1.getText();
        else if (selectedValue.equals("B ."))
            rightAnswer = txtAnwser2.getText();
        else if (selectedValue.equals("C ."))
            rightAnswer = txtAnwser3.getText();
        else
            rightAnswer = txtAnwser4.getText();
            
        Question question = new Question(1, txtAudio.getText(), txtImage.getText(), txtAnwser1.getText(), txtAnwser2.getText(), 
                                                                txtAnwser3.getText(), txtAnwser4.getText(), rightAnswer);
        
        if (qDAO.insertListeningQuestion(question)){
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Success");
           alert.setHeaderText("Adding question successfull");
           alert.setContentText(null);
           alert.getButtonTypes();
           alert.showAndWait();
           
           SceneMovement sm = new SceneMovement();
           sm.callNewScene(event, "AddQuestionManagement");
        }
        else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Please recheck your question");
           alert.setContentText(null);
           alert.getButtonTypes();
           alert.show();
        }
    }
    
}
