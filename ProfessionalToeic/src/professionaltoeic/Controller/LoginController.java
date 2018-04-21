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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnR;
    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfPassword;
    /**
     * Initializes the controller class.
     */
    private UserDAO uDAO;

    @FXML
    private void ButtonAction(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Register");
    }

    @FXML
    private void ButtonLogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        uDAO = new UserDAO();
        String name = tfLogin.getText();
        String password = tfPassword.getText();
        User user = uDAO.getUser(name);
        if (user != null) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                if (user.getType() == 1) {
                    SceneMovement sm = new SceneMovement();
                    sm.callNewScene(event, "Administrator");
                }
                UserDAO.setLoginUser(user);
                SceneMovement sm = new SceneMovement();
                sm.callNewScene(event, "MainUser");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please recheck your Id and Password");
                alert.setContentText(null);
                alert.getButtonTypes();
                alert.show();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
