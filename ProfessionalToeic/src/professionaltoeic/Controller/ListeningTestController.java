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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.QuestionAnswer;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class ListeningTestController implements Initializable {

    @FXML
    private Label lbnumber;
    @FXML
    private ImageView img;
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
    private QuestionAnswer uAnswers;
    private String imageURL;
    private String audioURL;
    private AudioClip audioClip;
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
        type = QuestionDAO.getTypeQuestionFlag();
        try {
            qDAO = new QuestionDAO();
            listQuestion = qDAO.getAllQuestionsByComboBoxTest(1);
        } catch (SQLException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (type == 4) {
            //countQuestion = 16;
            countQuestion = 3;
            questionNumber = 21;
        } else {
            //countQuestion = 10;
            countQuestion = 3;
        }
        loadData();
    }

    //Load 1 Listening question
    private void loadData() {
        if (listQuestion.size() > 0) {
            lbnumber.setText(String.valueOf(questionNumber));
            currentQuestion = listQuestion.get(new Random().nextInt(listQuestion.size()));
            imageURL = "Image/" + currentQuestion.getImage();
            Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(imageURL).toString());
            img.setImage(image);
            audioURL = "Audio/" + currentQuestion.getAudio();
            playAudio(audioURL);
            QuestionDAO.setQuestionUse(currentQuestion);
        } else {
            sm = new SceneMovement();
            sm.callErrorAlert("No Question Found !!!");
        }
    }

    //Next Question
    @FXML
    public void callNextQuestion(ActionEvent event) throws IOException {
        audioClip.stop();
        int correct = 0;
        String uAnswer = "";
        if (rbAnswer1.isSelected()) {
            uAnswer = rbAnswer1.getText();
            if (rbAnswer1.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer2.isSelected()) {
            uAnswer = rbAnswer2.getText();
            if (rbAnswer2.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer3.isSelected()) {
            uAnswer = rbAnswer3.getText();
            if (rbAnswer3.getText().equals(currentQuestion.getAnswer())) {
                correct = 1;
            }
        }
        if (rbAnswer4.isSelected()) {
            uAnswer = rbAnswer4.getText();
            if (rbAnswer4.getText().equals(currentQuestion.getAnswer())) {
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
                sm.callNewScene(event, "ReadingTest");
            } else {
                sm = new SceneMovement();
                sm.callNewScene(event, "FormResult");
            }
        }
    }

    //Play Audio
    private void playAudio(String url) {
        if (!url.equals("")) {
            audioClip = new AudioClip(professionaltoeic.ProfessionalToeic.class.getResource(url).toString());
            audioClip.play();
        } else {
            sm = new SceneMovement();
            sm.callErrorAlert("No audio path found!");
        }
    }
}
