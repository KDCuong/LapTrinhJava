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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import javafx.scene.input.KeyEvent;

import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtPassword;

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
        // TODO
    }

    //Move back to Login Scene
    @FXML
    private void callLoginScene(ActionEvent event) throws IOException {
        sm = new SceneMovement();
        sm.callNewScene(event, "Login");
    }

    //Add User
    @FXML
    private void addUser(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if (checkUserName() && checkPassword()) {
            uDAO = new UserDAO();
            uDAO.insertUser(txtUserName.getText(), txtPassword.getText(), txtFullName.getText(), txtEmail.getText());
            sm = new SceneMovement();
            sm.callConfirmAlert("Sign Up Successfull!! Let's Log in");
            sm.callNewScene(event, "Login");
        }
    }

    //Check User Name
    private boolean checkUserName() throws ClassNotFoundException, SQLException {
        sm = new SceneMovement();
        if (sm.dataTextFieldCheck(txtUserName, "USER NAME") == false) {
            return false;
        }
        uDAO = new UserDAO();
        String uName = txtUserName.getText();
        User user = uDAO.getUserByUserName(uName);
        if (user != null) {
            sm.callErrorAlert("User name already used");
            return false;
        }
        return true;
    }

    //Check Password
    private boolean checkPassword() {
        sm = new SceneMovement();
        if (sm.dataTextFieldCheck(txtPassword, "PASSWORD") == false) {
            return false;
        }
        int i = txtPassword.getText().length();
        if (i > 8 || i < 6) {
            sm.callErrorAlert("Password length must be 6 to 8 character");
            return false;
        }
        return true;
    }

    //Check Space
    @FXML
    private void checkSpace(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.SPACE)) {
            sm = new SceneMovement();
            sm.callErrorAlert("User Name cannot have SPACE character!!");
        }
    }
}
