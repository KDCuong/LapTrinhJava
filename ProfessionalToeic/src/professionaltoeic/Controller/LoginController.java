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
public class LoginController implements Initializable {

    @FXML
    private TextField txtLogin;
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

    }

    //Move to Sign Up Scene
    @FXML
    private void callRegisterScene(ActionEvent event) throws IOException {
        sm = new SceneMovement();
        sm.callNewScene(event, "Register");
    }

    //Move to Admin scene or User scene
    @FXML
    private void callMainScene(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        uDAO = new UserDAO();
        String name = txtLogin.getText();
        String password = txtPassword.getText();
        User user = uDAO.getUserByUserName(name);
        if (user != null) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                if (user.getType() == 1) {
                    sm = new SceneMovement();
                    sm.callNewScene(event, "Administrator");
                }
                UserDAO.setLoginUser(user);
                sm = new SceneMovement();
                sm.callNewScene(event, "MainUser");
            } else {
                sm = new SceneMovement();
                sm.callErrorAlert("Please recheck your Id and Password");
            }
        }

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
