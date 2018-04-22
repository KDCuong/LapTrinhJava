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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    private Button btnnext;
    @FXML
    private ImageView img;
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
    private String audioURL;
    private AudioClip audioClip;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            qDAO = new QuestionDAO();
            question = qDAO.getAllQuestionsByComboBoxTest(1);
        } catch (SQLException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrammaTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        countQuestion = question.size();
        

        loadData();
        // TODO
    }    
    private void loadData() {
        
        if (question.size() > 0) {
            lbnumber.setText(String.valueOf(questionNumber));
            currentquestion = question.get(new Random().nextInt(question.size()));
            String url=currentquestion.getImage();
            Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(url).toString());
            img.setImage(image);
            audioURL=currentquestion.getAudio();
            playAudio(audioURL);
            QuestionDAO.setQuestionUse(currentquestion);
        } else {  
            Alert alert = new Alert(Alert.AlertType.ERROR, "Không có câu hỏi nào !!!", new ButtonType("OK"));
            alert.showAndWait();       
        }
        
    }
    @FXML
    public void ButtonNext(ActionEvent event) throws IOException {
        audioClip.stop();
        int correct =0;
        String uAnswer ="";
        if (rb1.isSelected()) {
            uAnswer=rb1.getText();
            if (rb1.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        if (rb2.isSelected()) {
             uAnswer=rb2.getText();
            if (rb1.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        if (rb3.isSelected()) {
             uAnswer=rb3.getText();
            if (rb1.getText().equals(currentquestion.getAnswer())) {
                correct =1;
            }
        }
        if (rb4.isSelected()) {
             uAnswer=rb4.getText();
            if (rb1.getText().equals(currentquestion.getAnswer())) {
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
             List<QuestionAnswer> qAns =QuestionDAO.getQuestionAnswer();
//             System.out.println(qAns.get(1).getuAnswer());
             List<Question> qUse =QuestionDAO.getQuestionUse();
             SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "FormResult");
        }
    }

    private void playAudio(String url){
            if(!url.equals("")){
                audioClip = new AudioClip(professionaltoeic.ProfessionalToeic.class.getResource(url).toString());
                audioClip.play();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"No audio path found!",new ButtonType("OK"));
                alert.showAndWait();
                System.out.println("No audio found!");
            }
    }
    
}
