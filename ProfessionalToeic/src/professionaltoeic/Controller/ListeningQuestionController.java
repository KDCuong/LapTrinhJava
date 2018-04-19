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

    private QuestionDAO qDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

    public void callAddQuestionManagerment(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "AddQuestionManagement");
    }

    @FXML
    public void addListeningQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
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

        Question question = new Question(1, txtAudio.getText(), txtImage.getText(), txtAnwser1.getText(), txtAnwser2.getText(),
                txtAnwser3.getText(), txtAnwser4.getText(), rightAnswer, txtExplain.getText());

        if (qDAO.insertListeningQuestion(question)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Adding question successfull");
            alert.setContentText(null);
            alert.getButtonTypes();
            alert.showAndWait();

            SceneMovement sm = new SceneMovement();
            sm.callNewScene(event, "AddQuestionManagement");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please recheck your question");
            alert.setContentText(null);
            alert.getButtonTypes();
            alert.show();
        }
    }

    @FXML
    public void updateListeningQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        qDAO = new QuestionDAO();
        if (QuestionDAO.getQuestion().getFlag().equals("Deleted")) {
            if (qDAO.reverseQuestion(QuestionDAO.getQuestion().getId())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Your question now up to date");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.showAndWait();

                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "QuestionManagement");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please retry in a minute later");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.show();
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

            Question question = new Question(QuestionDAO.getQuestion().getId(), 1, "",
                    txtAudio.getText(), txtImage.getText(), QuestionDAO.getQuestion().getFlag(), txtAnwser1.getText(), txtAnwser2.getText(),
                    txtAnwser3.getText(), txtAnwser4.getText(), rightAnswer, txtExplain.getText(), 0);

            if (qDAO.updateListeningQuestion(question)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update question successfull");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.showAndWait();

                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "QuestionManagement");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please recheck your question");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.show();
            }
        }
    }

    @FXML
    public void deleteQuestion(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        qDAO = new QuestionDAO();

        if (QuestionDAO.getQuestion().getId() != 0) {
            if (qDAO.deleteQuestion(QuestionDAO.getQuestion().getId())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete question successfull");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.showAndWait();

                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "QuestionManagement");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Retry in a mininute later");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.show();
            }
        }
    }

    private void LoadData() {
        txtAudio.setText(QuestionDAO.getQuestion().getAudio());
        txtImage.setText(QuestionDAO.getQuestion().getImage());
        txtAnwser1.setText(QuestionDAO.getQuestion().getAnswer1());
        txtAnwser2.setText(QuestionDAO.getQuestion().getAnswer2());
        txtAnwser3.setText(QuestionDAO.getQuestion().getAnswer3());
        txtAnwser4.setText(QuestionDAO.getQuestion().getAnswer4());
        txtExplain.setText(QuestionDAO.getQuestion().getExplain());

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
                txtImage.setEditable(false);
                txtAudio.setEditable(false);
                txtAnwser1.setEditable(false);
                txtAnwser2.setEditable(false);
                txtAnwser3.setEditable(false);
                txtAnwser4.setEditable(false);
                txtExplain.setEditable(false);
            }
        }

    }
}
