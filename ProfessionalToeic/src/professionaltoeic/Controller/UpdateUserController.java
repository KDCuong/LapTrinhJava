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
import javafx.scene.control.TextField;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author cuong1312
 */
public class UpdateUserController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtFullname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnDelete;

    private UserDAO uDAO;
    SceneMovement sm;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }

    //Update User
    @FXML
    public void updateUser(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        uDAO = new UserDAO();
        sm = new SceneMovement();
        if (UserDAO.getLoginUser().getFlag().equals("Deleted")) {
            if (uDAO.reverseUser(UserDAO.getLoginUser().getId())) {
                sm.callConfirmAlert("Your user now up to date");
                sm.callNewScene(event, "UserManagement");
            } else {
                sm.callErrorAlert("Something has happened! Please retry after few minute");
            }
        } else {
            User user = new User(UserDAO.getLoginUser().getId(), txtUsername.getText(), txtFullname.getText(),
                    txtPassword.getText(), UserDAO.getLoginUser().getType(), txtEmail.getText(), UserDAO.getLoginUser().getFlag(), 0);

            if (uDAO.updateUser(user)) {
                sm.callConfirmAlert("Update user successfull");
                sm.callNewScene(event, "UserManagement");
            } else {
                sm.callErrorAlert("Something has happened! Please retry after few minute");
            }
        }
    }

    //Delete User
    @FXML
    public void deleteUser(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if (UserDAO.getLoginUser().getId() != 0) {
            uDAO = new UserDAO();
            if (uDAO.deleteUser(UserDAO.getLoginUser().getId())) {
                sm.callConfirmAlert("Delete user successfull");
                sm.callNewScene(event, "UserManagement");
            } else {
                sm.callErrorAlert("Something has happened! Please retry after few minute");
            }
        }
    }

    //Load data to scene when init it
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

    //Move to UserManagement scene
    public void callUserManagerment(ActionEvent event) throws IOException {
        sm = new SceneMovement();
        sm.callNewScene(event, "UserManagement");
    }
}
