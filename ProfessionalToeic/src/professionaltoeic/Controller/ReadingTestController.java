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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
public class ReadingTestController implements Initializable {

    @FXML
    private Label lbnumber;
    @FXML
    private Text txtqt;
    @FXML
    private Text txt1;
    @FXML
    private Text txt2;
    @FXML
    private Text txt3;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;

    @FXML
    private Text txtqt1;
    @FXML
    private Text txt11;
    @FXML
    private Text txt22;
    @FXML
    private Text txt33;
    @FXML
    private RadioButton rb11;
    @FXML
    private RadioButton rb22;
    @FXML
    private RadioButton rb33;
    
    @FXML
    private Text txtqt11;
    @FXML
    private Text txt111;
    @FXML
    private Text txt222;
    @FXML
    private Text txt333;
    @FXML
    private RadioButton rb111;
    @FXML
    private RadioButton rb222;
    @FXML
    private RadioButton rb333;
    
    private QuestionDAO qDAO;
    private List<Question> question;
    private List<Question> questionparagraph;
    private int countQuestion = 0;
    private int questionNumber = 1;
    private Question currentquestion;
    private QuestionAnswer uAnswers;
    private int currentCount = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            qDAO = new QuestionDAO();
            question = qDAO.getAllQuestionsByComboBox(2);
        } catch (SQLException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        countQuestion = question.size();
//        lbnumber.setText(String.valueOf(questionNumber));

        loadData();
    }

    private void loadData() {
        
        if (question.size() > 0) {
            System.out.println(String.valueOf(currentCount));
            currentquestion = question.get(new Random().nextInt(question.size()));

            try {
                qDAO = new QuestionDAO();
                questionparagraph = qDAO.getAllQuestionsByComboBoxIdParagraph(2,currentquestion.getParagraph_id());
            } catch (SQLException ex) {
                Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtqt.setText(questionparagraph.get(0).getContent());
            txt1.setText(questionparagraph.get(0).getAnswer1());
            txt2.setText(questionparagraph.get(0).getAnswer2());
            txt3.setText(questionparagraph.get(0).getAnswer3());
            
             txtqt1.setText(questionparagraph.get(1).getContent());
            txt11.setText(questionparagraph.get(1).getAnswer1());
            txt22.setText(questionparagraph.get(1).getAnswer2());
            txt33.setText(questionparagraph.get(1).getAnswer3());
            
             txtqt11.setText(questionparagraph.get(2).getContent());
            txt111.setText(questionparagraph.get(2).getAnswer1());
            txt222.setText(questionparagraph.get(2).getAnswer2());
            txt333.setText(questionparagraph.get(2).getAnswer3());

            QuestionDAO.setQuestionUse(questionparagraph.get(0));
            QuestionDAO.setQuestionUse(questionparagraph.get(1));
            QuestionDAO.setQuestionUse(questionparagraph.get(2));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Không có câu hỏi nào !!!", new ButtonType("OK"));
            alert.showAndWait();
        }

    }

    @FXML
    public void ButtonNext(ActionEvent event) throws IOException {
        //Cau 1
        int correct = 0;
        String uAnswer = "";
        if (rb1.isSelected()) {
            uAnswer = rb1.getText();
            if (txt1.getText().equals(questionparagraph.get(0).getAnswer())) {
                correct = 1;
            }
        }
        if (rb2.isSelected()) {
            uAnswer = rb2.getText();
            if (txt2.getText().equals(questionparagraph.get(0).getAnswer())) {
                correct = 1;
            }
        }
        if (rb3.isSelected()) {
            uAnswer = rb3.getText();
            if (txt3.getText().equals(questionparagraph.get(0).getAnswer())) {
                correct = 1;
            }
        }
        
        uAnswers = new QuestionAnswer(questionNumber, uAnswer, correct);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct) + uAnswer);
        questionNumber++;
        currentCount++;
//        
        //Cau 2
        int correct1 = 0;
        String uAnswer1 = "";
        if (rb11.isSelected()) {
            uAnswer1 = rb11.getText();
            if (txt11.getText().equals(questionparagraph.get(1).getAnswer())) {
                correct1 = 1;
            }
        }
        if (rb22.isSelected()) {
            uAnswer1 = rb22.getText();
            if (txt22.getText().equals(questionparagraph.get(1).getAnswer())) {
                correct1 = 1;
            }
        }
        if (rb33.isSelected()) {
            uAnswer1 = rb33.getText();
            if (txt33.getText().equals(questionparagraph.get(1).getAnswer())) {
                correct1 = 1;
            }
        }
        uAnswers = new QuestionAnswer(questionNumber, uAnswer1, correct1);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct1) + uAnswer1);
        questionNumber++;
        currentCount++;
        
        //Cau 3
        correct = 0;
        uAnswer = "";
        if (rb111.isSelected()) {
            uAnswer = rb111.getText();
            if (txt111.getText().equals(questionparagraph.get(2).getAnswer())) {
                correct = 1;
            }
        }
        if (rb222.isSelected()) {
            uAnswer = rb222.getText();
            if (txt222.getText().equals(questionparagraph.get(2).getAnswer())) {
                correct = 1;
            }
        }
        if (rb333.isSelected()) {
            uAnswer = rb333.getText();
            if (txt333.getText().equals(questionparagraph.get(2).getAnswer())) {
                correct = 1;
            }
        }
        uAnswers = new QuestionAnswer(questionNumber, uAnswer, correct);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct) + uAnswer);
        
        if (currentCount < countQuestion) {

            question.remove(questionparagraph.get(0));
            question.remove(questionparagraph.get(1));
            question.remove(questionparagraph.get(2));
            currentCount++;
            questionNumber++;
            loadData();
        } else {
            List<QuestionAnswer> qAns = QuestionDAO.getQuestionAnswer();
             System.out.println(qAns.get(1).getuAnswer());
            List<Question> qUse = QuestionDAO.getQuestionUse();
            SceneMovement sm = new SceneMovement();
            sm.callNewScene(event, "FormResult");
        }
    }

}
