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

/**
 * FXML Controller class
 *
 * @author curly
 */
public class LoginController  implements Initializable  {

    @FXML
    private Button btnR ;
     @FXML
    private TextField tfLogin ;
      @FXML
    private TextField tfPassword;    /**
     * Initializes the controller class.
     */
    private UserDAO uDAO;
    @FXML
     private void ButtonAction(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Register.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        System.out.println("You clicked me!");
    }
    @FXML
    private void ButtonLogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        uDAO = new UserDAO();
        String name=tfLogin.getText();
        String password = tfPassword.getText();
        if(uDAO.getUser(name , password ))
        {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Administrator.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Administrator");
        stage.setScene(scene);
        stage.show();
       }
       else
       {
           System.out.println("ngu học");
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Lỗi rồi");
           alert.setHeaderText("Đề nghị kiểm tra Id và Password");
           alert.setContentText(null);
           alert.getButtonTypes();
           alert.show();
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
}
