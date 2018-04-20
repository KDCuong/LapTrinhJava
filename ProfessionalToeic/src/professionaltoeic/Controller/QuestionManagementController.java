/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class QuestionManagementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox cbType;

    public TableView<Question> tbQuestion;
    public TableColumn<Question, String> colId;
    public TableColumn<Question, String> colType;
    public TableColumn<Question, String> colContent;
    public TableColumn<Question, String> colStatus;
    private ObservableList<Question> list = getQuestionList();
    private QuestionDAO qDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadQuestionData();
    }

    public void callAdministratorManagerment(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Administrator");
    }

    private ObservableList<Question> getQuestionList() {

        try {
            qDAO = new QuestionDAO();
            List<Question> questionList;
            questionList = qDAO.getAllQuestions();
            list = FXCollections.observableList(questionList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        }
        return list;
    }

    public void loadQuestionData() {
        cbType.getItems().addAll(
                "Listening",
                "Reading",
                "Grammar",
                "All"
        );
        cbType.setPromptText("Input Type");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("flag"));
        tbQuestion.setItems(list);
    }

    @FXML
    private void getQuestionListByComboBox() {

        try {
            qDAO = new QuestionDAO();
            List<Question> questionList;
            String type = cbType.getSelectionModel().getSelectedItem().toString();
            if (type.equals("Listening")) {
                questionList = qDAO.getAllQuestionsByComboBox(1);
            } else if (type.equals("Reading")) {
                questionList = qDAO.getAllQuestionsByComboBox(2);
            } else if (type.equals("Grammar")) {
                questionList = qDAO.getAllQuestionsByComboBox(3);
            } else {
                questionList = qDAO.getAllQuestions();
            }
            list = FXCollections.observableList(questionList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        }
        loadQuestionData();
    }

    public void callAddQuestionManagerment(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "AddQuestionManagement");
    }

    @FXML
    public void callUpdateQuestion(MouseEvent event) throws IOException {
            Question row = tbQuestion.getSelectionModel().getSelectedItem();
            Question question = new Question();
            try {
                qDAO = new QuestionDAO();
                question = qDAO.getQuestionsByID(row.getId());
                QuestionDAO.setQuestion(question);
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
                alert.showAndWait();
            } catch (ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
                alert.showAndWait();
            }
        switch (question.getType()) {
            case 1:
                {
                    SceneMovement sm = new SceneMovement();
                    sm.callNewScene(event, "ListeningQuestion");
                    break;
                }
            case 2:
                {
                    SceneMovement sm = new SceneMovement();
                    sm.callNewScene(event, "ReadingQuestion");
                    QuestionDAO.setFlag(2);
                    break;
                }
            default:
                {
                    SceneMovement sm = new SceneMovement();
                    sm.callNewScene(event, "ReadingQuestion");
                    QuestionDAO.setFlag(3);
                    break;
                }
        }
        }
}
