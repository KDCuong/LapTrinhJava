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
    private Text txtQuestion1;
    @FXML
    private Text txtAnswer11;
    @FXML
    private Text txtAnswer12;
    @FXML
    private Text txtAnswer13;
    @FXML
    private RadioButton rbAnswer11;
    @FXML
    private RadioButton rbAnswer12;
    @FXML
    private RadioButton rbAnswer13;

    @FXML
    private Text txtQuestion2;
    @FXML
    private Text txtAnswer21;
    @FXML
    private Text txtAnswer22;
    @FXML
    private Text txtAnswer23;
    @FXML
    private RadioButton rbAnswer21;
    @FXML
    private RadioButton rbAnswer22;
    @FXML
    private RadioButton rbAnswer23;

    @FXML
    private Text txtQuestion3;
    @FXML
    private Text txtAnswer31;
    @FXML
    private Text txtAnswer32;
    @FXML
    private Text txtAnswer33;
    @FXML
    private RadioButton rbAnswer31;
    @FXML
    private RadioButton rbAnswer32;
    @FXML
    private RadioButton rbAnswer33;

    private QuestionDAO qDAO;
    private List<Question> listQuestion;
    private List<Question> questionParagraph;
    private int countQuestion = 0;
    private int questionNumber = 1;
    private Question currentQuestion;
    private Question question;

    private QuestionAnswer uAnswers;
    private int currentCount = 0;
    private int type = 0;
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
        type = QuestionDAO.getTypeQuestionFlag();
        try {
            qDAO = new QuestionDAO();
            listQuestion = qDAO.getAllQuestionsByComboBoxTest(2);
        } catch (SQLException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (type == 4) {
            countQuestion = 8;
            questionNumber = 37;
        } else {
            countQuestion = 14;
        }
        loadData();
    }

    //Load 3 Reading Question in same Paragraph ID
    private void loadData() {
        if (listQuestion.size() > 0) {
            System.out.println(String.valueOf(currentCount));
            currentQuestion = listQuestion.get(new Random().nextInt(listQuestion.size()));

            try {
                qDAO = new QuestionDAO();
                questionParagraph = qDAO.getAllReadingQuestionsByIdParagraph(2, currentQuestion.getParagraph_id());
            } catch (SQLException ex) {
                Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtQuestion1.setText(questionParagraph.get(0).getContent());
            txtAnswer11.setText(questionParagraph.get(0).getAnswer1());
            txtAnswer12.setText(questionParagraph.get(0).getAnswer2());
            txtAnswer13.setText(questionParagraph.get(0).getAnswer3());

            txtQuestion2.setText(questionParagraph.get(1).getContent());
            txtAnswer21.setText(questionParagraph.get(1).getAnswer1());
            txtAnswer22.setText(questionParagraph.get(1).getAnswer2());
            txtAnswer23.setText(questionParagraph.get(1).getAnswer3());

            txtQuestion3.setText(questionParagraph.get(2).getContent());
            txtAnswer31.setText(questionParagraph.get(2).getAnswer1());
            txtAnswer32.setText(questionParagraph.get(2).getAnswer2());
            txtAnswer33.setText(questionParagraph.get(2).getAnswer3());

            QuestionDAO.setQuestionUse(questionParagraph.get(0));
            QuestionDAO.setQuestionUse(questionParagraph.get(1));
            QuestionDAO.setQuestionUse(questionParagraph.get(2));
        } else {
            sm = new SceneMovement();
            sm.callErrorAlert("No Question Found !!!");
        }
    }

    //Go to Next Question
    @FXML
    public void callNextQuestion(ActionEvent event) throws IOException {
        //Cau 1
        int correct = 0;
        String uAnswer = "";
        if (rbAnswer11.isSelected()) {
            uAnswer = rbAnswer11.getText();
            if (txtAnswer11.getText().equals(questionParagraph.get(0).getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer12.isSelected()) {
            uAnswer = rbAnswer12.getText();
            if (txtAnswer12.getText().equals(questionParagraph.get(0).getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer13.isSelected()) {
            uAnswer = rbAnswer13.getText();
            if (txtAnswer13.getText().equals(questionParagraph.get(0).getAnswer())) {
                correct = 1;
            }
        }
        uAnswers = new QuestionAnswer(questionNumber, uAnswer, correct);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct) + uAnswer);
        questionNumber++;
        currentCount++;

        //Cau 2
        int correct1 = 0;
        String uAnswer1 = "";
        if (rbAnswer21.isSelected()) {
            uAnswer1 = rbAnswer21.getText();
            if (txtAnswer21.getText().equals(questionParagraph.get(1).getAnswer())) {
                correct1 = 1;
            }
        }
        if (rbAnswer22.isSelected()) {
            uAnswer1 = rbAnswer22.getText();
            if (txtAnswer22.getText().equals(questionParagraph.get(1).getAnswer())) {
                correct1 = 1;
            }
        }
        if (rbAnswer23.isSelected()) {
            uAnswer1 = rbAnswer23.getText();
            if (txtAnswer23.getText().equals(questionParagraph.get(1).getAnswer())) {
                correct1 = 1;
            }
        }
        uAnswers = new QuestionAnswer(questionNumber, uAnswer1, correct1);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct1) + uAnswer1);
        questionNumber++;
        currentCount++;

        //Cau 3
        int correct2 = 0;
        String uAnswer2 = "";
        if (rbAnswer31.isSelected()) {
            uAnswer2 = rbAnswer31.getText();
            if (txtAnswer31.getText().equals(questionParagraph.get(2).getAnswer())) {
                correct2 = 1;
            }
        }
        if (rbAnswer32.isSelected()) {
            uAnswer2 = rbAnswer32.getText();
            if (txtAnswer32.getText().equals(questionParagraph.get(2).getAnswer())) {
                correct2 = 1;
            }
        }
        if (rbAnswer33.isSelected()) {
            uAnswer2 = rbAnswer33.getText();
            if (txtAnswer33.getText().equals(questionParagraph.get(2).getAnswer())) {
                correct2 = 1;
            }
        }
        uAnswers = new QuestionAnswer(questionNumber, uAnswer, correct);
        QuestionDAO.setQuestionAnswer(uAnswers);
        System.out.println(String.valueOf(correct) + uAnswer);

        if (currentCount < countQuestion) {
            for (int i = 0; i < listQuestion.size(); i++) {
                if (listQuestion.get(i).getParagraph_id() == questionParagraph.get(0).getParagraph_id()) {
                    question = new Question();
                    question = listQuestion.get(i);
                    listQuestion.remove(question);
                    i = -1;
                }
            }
            currentCount++;
            questionNumber++;
            loadData();
        } else {
            sm = new SceneMovement();
            sm.callNewScene(event, "FormResult");
        }
    }
}
