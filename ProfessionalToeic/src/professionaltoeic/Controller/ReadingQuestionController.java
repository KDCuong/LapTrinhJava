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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class ReadingQuestionController implements Initializable {

    @FXML
    private TextArea txtContent;
    @FXML
    private TextField txtExplain;
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
    @FXML
    private TextField txtPID;
    @FXML
    private Label lblPID;

    private QuestionDAO qDAO;
    SceneMovement sm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

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

    @FXML
    public void addQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if (completeCheck()) {
            qDAO = new QuestionDAO();
            String rightAnswer;
            RadioButton selectedRB = (RadioButton) GroupAnswer.getSelectedToggle();
            String selectedValue = selectedRB.getText();
            switch (selectedValue) {
                case "A .":
                    rightAnswer = txtAnwser1.getText();
                    break;
                case "B .":
                    rightAnswer = txtAnwser2.getText();
                    break;
                case "C .":
                    rightAnswer = txtAnwser3.getText();
                    break;
                default:
                    rightAnswer = txtAnwser4.getText();
                    break;
            }
            int p_id = Integer.parseInt(txtPID.getText());
            Question question = new Question(QuestionDAO.getTypeQuestionFlag(), txtContent.getText(), txtAnwser1.getText(), txtAnwser2.getText(),
                    txtAnwser3.getText(), txtAnwser4.getText(), rightAnswer, txtExplain.getText(), p_id);

            if (qDAO.insertQuestion(question)) {
                sm = new SceneMovement();
                sm.callConfirmAlert("Adding question successfull");
                sm.callNewScene(event, "AddQuestionManagement");
            } else {
                sm = new SceneMovement();
                sm.callErrorAlert("Something wrong happened. Please retry it later");
            }
        }
    }

    @FXML
    public void updateQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
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
                String rightAnswer;
                RadioButton selectedRB = (RadioButton) GroupAnswer.getSelectedToggle();
                String selectedValue = selectedRB.getText();
                switch (selectedValue) {
                    case "A .":
                        rightAnswer = txtAnwser1.getText();
                        break;
                    case "B .":
                        rightAnswer = txtAnwser2.getText();
                        break;
                    case "C .":
                        rightAnswer = txtAnwser3.getText();
                        break;
                    default:
                        rightAnswer = txtAnwser4.getText();
                        break;
                }
                int p_id = Integer.parseInt(txtPID.getText());
                Question question = new Question(QuestionDAO.getQuestion().getId(), QuestionDAO.getTypeQuestionFlag(), txtContent.getText(),
                        "", "", QuestionDAO.getQuestion().getFlag(), txtAnwser1.getText(), txtAnwser2.getText(),
                        txtAnwser3.getText(), txtAnwser4.getText(), rightAnswer, txtExplain.getText(), p_id);

                if (qDAO.updateQuestion(question)) {
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

    private void LoadData() {
        txtContent.setText(QuestionDAO.getQuestion().getContent());
        txtAnwser1.setText(QuestionDAO.getQuestion().getAnswer1());
        txtAnwser2.setText(QuestionDAO.getQuestion().getAnswer2());
        txtAnwser3.setText(QuestionDAO.getQuestion().getAnswer3());
        txtAnwser4.setText(QuestionDAO.getQuestion().getAnswer4());
        txtExplain.setText(QuestionDAO.getQuestion().getExplain());
        txtPID.setText(String.valueOf(QuestionDAO.getQuestion().getParagraph_id()));
        if (QuestionDAO.getTypeQuestionFlag() == 3) {
            txtPID.setVisible(false);
            lblPID.setVisible(false);
        }
        if (QuestionDAO.getQuestion().getAnswer() == null) {
            btnUpdate.setVisible(false);
            btnDelete.setVisible(false);
        } else {
            if (QuestionDAO.getQuestion().getAnswer().equals(txtAnwser1.getText())) {
                rdAnswer1.setSelected(true);
            } else if (QuestionDAO.getQuestion().getAnswer().equals(txtAnwser2.getText())) {
                rdAnswer2.setSelected(true);
            } else if (QuestionDAO.getQuestion().getAnswer().equals(txtAnwser3.getText())) {
                rdAnswer3.setSelected(true);
            } else if (QuestionDAO.getQuestion().getAnswer().equals(txtAnwser4.getText())) {
                rdAnswer4.setSelected(true);
            }
            btnAdd.setVisible(false);

            if (QuestionDAO.getQuestion().getFlag().equals("Deleted")) {
                btnDelete.setVisible(false);
                txtContent.setEditable(false);
                txtPID.setEditable(false);
                txtAnwser1.setEditable(false);
                txtAnwser2.setEditable(false);
                txtAnwser3.setEditable(false);
                txtAnwser4.setEditable(false);
                txtExplain.setEditable(false);
            }
        }
    }

    public boolean completeCheck() {
        sm = new SceneMovement();
        if (QuestionDAO.getTypeQuestionFlag() == 2) {
            if (sm.dataTextFieldCheck(txtPID, "PARAGRAPH ID") == false) {
                return false;
            }
        }
        if (sm.dataTextAreaCheck(txtContent, "CONTENT") == false) {
            return false;
        } else if (sm.dataTextFieldCheck(txtAnwser1, "at least 3 ANSWER in order") == false) {
            return false;
        } else if (sm.dataTextFieldCheck(txtAnwser2, "at least 3 ANSWER in order") == false) {
            return false;
        } else if (sm.dataTextFieldCheck(txtAnwser3, "at least 3 ANSWER in order") == false) {
            return false;
        }
        return true;
    }
}
