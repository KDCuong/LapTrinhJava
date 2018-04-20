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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class UpdateUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtFullname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    private UserDAO uDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

    @FXML
    public void updateUser(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        uDAO = new UserDAO();
        if (UserDAO.getLoginUser().getFlag().equals("Deleted")) {
            if (uDAO.reverseUser(UserDAO.getLoginUser().getId())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Your user now up to date");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.showAndWait();

                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "UserManagement");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please retry in a minute later");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.show();
            }
        } else {
            User user = new User(UserDAO.getLoginUser().getId(), txtUsername.getText(), txtFullname.getText(),
                    txtPassword.getText(), UserDAO.getLoginUser().getType(), txtEmail.getText(), UserDAO.getLoginUser().getFlag(), 0);

            if (uDAO.updateUser(user)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update user successfull");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.showAndWait();

                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "UserManagement");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please recheck your user");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.show();
            }
        }
    }

    @FXML
    public void deleteUser(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        uDAO = new UserDAO();

        if (UserDAO.getLoginUser().getId() != 0) {
            if (uDAO.deleteUser(UserDAO.getLoginUser().getId())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete user successfull");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.showAndWait();

                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "UserManagement");
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
        txtUsername.setText(UserDAO.getLoginUser().getName());
        txtFullname.setText(UserDAO.getLoginUser().getFullname());
        txtPassword.setText(UserDAO.getLoginUser().getPassword());
        txtEmail.setText(UserDAO.getLoginUser().getEmail());
        txtUsername.setEditable(false);

        if (UserDAO.getLoginUser().getFlag().equals("Deleted")) {
            btnDelete.setVisible(false);
            txtFullname.setEditable(false);
            txtPassword.setEditable(false);
            txtEmail.setEditable(false);
        }
    }

    public void callUserManagerment(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "UserManagement");
    }
}
