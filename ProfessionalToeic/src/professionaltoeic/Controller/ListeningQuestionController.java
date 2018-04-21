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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class ListeningQuestionController implements Initializable {

    @FXML
    private TextField txtAudio;
    @FXML
    private TextField txtImage;
    @FXML
    private TextField txtExplain;
    @FXML
    private ToggleGroup GroupAnswer;
    @FXML
    private RadioButton rdAnswer1;
    @FXML
    private RadioButton rdAnswer2;
    @FXML
    private RadioButton rdAnswer3;
    @FXML
    private RadioButton rdAnswer4;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    private QuestionDAO qDAO;
    SceneMovement sm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

    //Button cancel move to scene by Flag
     public void callSceneManagerment(ActionEvent event) throws IOException {
        if (QuestionDAO.getTypePageFlag().equals("Add")){
            sm = new SceneMovement();
            sm.callNewScene(event, "AddQuestionManagement");
        }
        else{
            sm = new SceneMovement();
            sm.callNewScene(event, "QuestionManagement");
        }
    }

     //Insert ListeningQuestion
    @FXML
    public void addListeningQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if (completeCheck()) {
            qDAO = new QuestionDAO();
            RadioButton selectedRB = (RadioButton) GroupAnswer.getSelectedToggle();
            String rightAnswer = selectedRB.getText();

            Question question = new Question(1, txtAudio.getText(), txtImage.getText(), rdAnswer1.getText(), rdAnswer2.getText(),
                    rdAnswer3.getText(), rdAnswer4.getText(), rightAnswer, txtExplain.getText());

            if (qDAO.insertListeningQuestion(question)) {
                sm = new SceneMovement();
                sm.callConfirmAlert("Adding question successfull");
                sm.callNewScene(event, "AddQuestionManagement");
            } else {
                sm = new SceneMovement();
                sm.callErrorAlert("Something wrong happened. Please retry it later");
            }
        }
    }

     //Update ListeningQuestion
    @FXML
    public void updateListeningQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if (completeCheck()) {
            qDAO = new QuestionDAO();
            if (QuestionDAO.getQuestion().getFlag().equals("Deleted")) {
                if (qDAO.reverseQuestion(QuestionDAO.getQuestion().getId())) {
                    sm = new SceneMovement();
                    sm.callConfirmAlert("Your question now up to date");
                    sm.callNewScene(event, "QuestionManagement");
                } else {
                    sm = new SceneMovement();
                    sm.callErrorAlert("Something wrong happened. Please retry it later");
                }
            } else {

                RadioButton selectedRB = (RadioButton) GroupAnswer.getSelectedToggle();
                String rightAnswer = selectedRB.getText();
                Question question = new Question(QuestionDAO.getQuestion().getId(), 1, "",
                        txtAudio.getText(), txtImage.getText(), QuestionDAO.getQuestion().getFlag(), rdAnswer1.getText(), rdAnswer2.getText(),
                        rdAnswer3.getText(), rdAnswer4.getText(), rightAnswer, txtExplain.getText(), 0);

                if (qDAO.updateListeningQuestion(question)) {
                    sm = new SceneMovement();
                    sm.callConfirmAlert("Update question successfull");
                    sm.callNewScene(event, "QuestionManagement");
                } else {
                    sm = new SceneMovement();
                    sm.callErrorAlert("Something wrong happened. Please retry it later");
                }
            }
        }
    }

     //Delete ListeningQuestion
    @FXML
    public void deleteQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        qDAO = new QuestionDAO();

        if (QuestionDAO.getQuestion().getId() != 0) {
            if (qDAO.deleteQuestion(QuestionDAO.getQuestion().getId())) {
                sm = new SceneMovement();
                sm.callConfirmAlert("Delete question successfull");
                sm.callNewScene(event, "QuestionManagement");
            } else {
                sm = new SceneMovement();
                sm.callErrorAlert("Something wrong happened. Please retry it later");
            }
        }
    }

     //Load database when init scene
    private void LoadData() {
        txtAudio.setText(QuestionDAO.getQuestion().getAudio());
        txtImage.setText(QuestionDAO.getQuestion().getImage());
        txtExplain.setText(QuestionDAO.getQuestion().getExplain());

        if (QuestionDAO.getQuestion().getAnswer() == null) {
            btnUpdate.setVisible(false);
            btnDelete.setVisible(false);
        } else {
            if (QuestionDAO.getQuestion().getAnswer().equals(rdAnswer1.getText())) {
                rdAnswer1.setSelected(true);
            } else if (QuestionDAO.getQuestion().getAnswer().equals(rdAnswer2.getText())) {
                rdAnswer2.setSelected(true);
            } else if (QuestionDAO.getQuestion().getAnswer().equals(rdAnswer3.getText())) {
                rdAnswer3.setSelected(true);
            } else if (QuestionDAO.getQuestion().getAnswer().equals(rdAnswer4.getText())) {
                rdAnswer4.setSelected(true);
            }
            btnAdd.setVisible(false);

            if (QuestionDAO.getQuestion().getFlag().equals("Deleted")) {
                btnDelete.setVisible(false);
                txtImage.setEditable(false);
                txtAudio.setEditable(false);
                txtExplain.setEditable(false);
            }
        }
    }

    //Check before update or insert
    public boolean completeCheck() {
        sm = new SceneMovement();
        if (sm.dataTextFieldCheck(txtAudio, "AUDIO PATH") == false
                || sm.dataTextFieldCheck(txtImage, "IMAGE PATH") == false) {
            return false;
        }
        return true;
    }
}
