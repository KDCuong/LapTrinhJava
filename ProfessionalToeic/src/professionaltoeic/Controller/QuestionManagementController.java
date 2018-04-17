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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Button btnUser;
    
    @FXML
    private ComboBox cbType;
    
    public TableView<Question> tbQuestion;
    public TableColumn<Question,String> colId;
    public TableColumn<Question,String> colType;
    public TableColumn<Question,String> colContent;
    public TableColumn<Question,String> colStatus;
    private ObservableList<Question> list = getQuestionList();
    private QuestionDAO qDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbType.getItems().addAll(
                "Gramma",
                "Reading",
                "Listening" 
        );
        cbType.setValue("Gramma");
        loadQuestionData();
    }
    
    public void callAdministratorManagerment(ActionEvent event) throws IOException {        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Administrator.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Administrator");
        stage.setScene(scene);
        stage.show();
     }
      
    private ObservableList<Question> getQuestionList(){
        try {
            qDAO = new QuestionDAO();
            List<Question> questionList = qDAO.getAllQuestions();
            list = FXCollections.observableList(questionList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),new ButtonType("OK"));
            alert.showAndWait();
        }
        return list;
    }
    
    public void loadQuestionData(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("flag"));
        tbQuestion.setItems(list);
    }
}
