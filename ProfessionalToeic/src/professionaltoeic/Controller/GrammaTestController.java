/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.QuestionAnswer;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class GrammaTestController implements Initializable {

    @FXML
    private Text txtqt;
    @FXML
    private Text txt1;
    @FXML
    private Text txt2;
    @FXML
    private Text txt3;
    @FXML
    private Text txt4;
    @FXML
    private Label lbnumber;
    @FXML
    private Button btnnext;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;

    private QuestionDAO qDAO;
    private List<Question> question;
    private Question currentquestion;
    private int questionNumber = 1;
    private int countQuestion = 0;
    private int currentCount = 1;
    private int point = 0;
    private QuestionAnswer uAnswers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            qDAO = new QuestionDAO();
            question = qDAO.getAllQuestionsByComboBoxTest(3);
        } catch (SQLException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        countQuestion = 10;
        lbnumber.setText(String.valueOf(questionNumber));

        loadData();
        // TODO
    }

    private void loadData() {
        if (question.size() > 0) {
            currentquestion = question.get(new Random().nextInt(question.size()));
            txtqt.setText(currentquestion.getContent());
            txt1.setText(currentquestion.getAnswer1());
            txt2.setText(currentquestion.getAnswer2());
            txt3.setText(currentquestion.getAnswer3());
            txt4.setText(currentquestion.getAnswer4());
            QuestionDAO.setQuestionUse(currentquestion);
            lbnumber.setText(String.valueOf(questionNumber));
        } else {  
            Alert alert = new Alert(Alert.AlertType.ERROR, "Không có câu hỏi nào !!!", new ButtonType("OK"));
            alert.showAndWait();       
        }
        
    }

    @FXML
    public void ButtonNext(ActionEvent event) throws IOException {
        int correct =0;
        String uAnswer ="";
        if (rb1.isSelected()) {
            uAnswer=rb1.getText();
            if (txt1.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        if (rb2.isSelected()) {
             uAnswer=rb2.getText();
            if (txt2.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        if (rb3.isSelected()) {
             uAnswer=rb3.getText();
            if (txt3.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        if (rb4.isSelected()) {
             uAnswer=rb4.getText();
            if (txt4.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        uAnswers= new QuestionAnswer(questionNumber, uAnswer, correct);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct)+uAnswer);
        if (currentCount < countQuestion) {

            question.remove(currentquestion);
            currentCount++;
            questionNumber++;
            loadData();
        } else {
            QuestionDAO.setTypeQuestionFlag(3);
             List<QuestionAnswer> qAns =QuestionDAO.getQuestionAnswer();
//             System.out.println(qAns.get(1).getuAnswer());
             List<Question> qUse =QuestionDAO.getQuestionUse();
             SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "FormResult");
        }
    }

}
