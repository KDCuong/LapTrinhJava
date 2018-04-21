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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class UserManagementController implements Initializable {

    public TableView<User> tbUser;
    public TableColumn<User, String> colId;
    public TableColumn<User, String> colUserName;
    public TableColumn<User, String> colType;
    public TableColumn<User, String> colEmail;
    public TableColumn<User, String> colStatus;
    private ObservableList<User> list = getUserList();
    private UserDAO uDAO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadUserData();
    }

    public void callAdministratorManagerment(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Administrator");
    }

    private ObservableList<User> getUserList() {

        try {
            uDAO = new UserDAO();
            List<User> userList;
            userList = uDAO.getAllUser();
            list = FXCollections.observableList(userList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        }
        return list;
    }

    public void loadUserData() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("flag"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tbUser.setItems(list);
    }

    @FXML
    public void callUpdateUser(MouseEvent event) throws IOException {
        User row = tbUser.getSelectionModel().getSelectedItem();
        User user = new User();
        try {
            uDAO = new UserDAO();
            user = uDAO.getUserByUserName(row.getName());
            UserDAO.setLoginUser(user);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        }
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "UpdateUser");
    }
}
