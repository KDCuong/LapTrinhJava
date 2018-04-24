/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.QuestionAnswer;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class GrammaTestController implements Initializable {

    @FXML
    private Text txtQuestion;
    @FXML
    private Text txtAnswer1;
    @FXML
    private Text txtAnswer2;
    @FXML
    private Text txtAnswer3;
    @FXML
    private Text txtAnswer4;
    @FXML
    private Label lbnumber;
    @FXML
    private RadioButton rbAnswer1;
    @FXML
    private RadioButton rbAnswer2;
    @FXML
    private RadioButton rbAnswer3;
    @FXML
    private RadioButton rbAnswer4;

    private QuestionDAO qDAO;
    private List<Question> listQuestion;
    private Question currentQuestion;
    private int questionNumber = 1;
    private int countQuestion = 0;
    private int currentCount = 1;
    private int type = 0;
    private QuestionAnswer uAnswers;
    SceneMovement sm;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type = QuestionDAO.getTypeQuestionFlag();
        try {
            qDAO = new QuestionDAO();
            listQuestion = qDAO.getAllQuestionsByComboBoxTest(3);
        } catch (SQLException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (type == 4) {
            countQuestion = 20;
        } else {
            countQuestion = 10;
        }
        lbnumber.setText(String.valueOf(questionNumber));
        loadData();
    }

    //Load 1 question in list question
    private void loadData() {
        if (listQuestion.size() > 0) {
            currentQuestion = listQuestion.get(new Random().nextInt(listQuestion.size()));
            txtQuestion.setText(currentQuestion.getContent());
            txtAnswer1.setText(currentQuestion.getAnswer1());
            txtAnswer2.setText(currentQuestion.getAnswer2());
            txtAnswer3.setText(currentQuestion.getAnswer3());
            txtAnswer4.setText(currentQuestion.getAnswer4());
            QuestionDAO.setQuestionUse(currentQuestion);
            lbnumber.setText(String.valueOf(questionNumber));
        } else {
            sm = new SceneMovement();
            sm.callErrorAlert("No Question Found !!!");
        }
    }

    //Next Question
    @FXML
    public void callNextQuestion(ActionEvent event) throws IOException {
        int correct = 0;
        String uAnswer = "";
        if (rbAnswer1.isSelected()) {
            uAnswer = rbAnswer1.getText();
            if (txtAnswer1.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer2.isSelected()) {
            uAnswer = rbAnswer2.getText();
            if (txtAnswer2.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer3.isSelected()) {
            uAnswer = rbAnswer3.getText();
            if (txtAnswer3.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer4.isSelected()) {
            uAnswer = rbAnswer4.getText();
            if (txtAnswer4.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        uAnswers = new QuestionAnswer(questionNumber, uAnswer, correct);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct) + uAnswer);
        if (currentCount < countQuestion) {
            listQuestion.remove(currentQuestion);
            currentCount++;
            questionNumber++;
            loadData();
        } else {
            if (type == 4) {
                sm = new SceneMovement();
                sm.callNewScene(event, "ListeningTest");
            } else {
                sm = new SceneMovement();
                sm.callNewScene(event, "FormResult");
            }
        }
    }
}
