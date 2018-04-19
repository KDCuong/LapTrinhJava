/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import professionaltoeic.DAO.UserDAO;


/**
 * FXML Controller class
 *
 * @author curly
 */
public class MainUserController implements Initializable {

    @FXML
    private Button btnT;
    @FXML
    private Label lbname;
    @FXML
    private Label lbpoint;
    
    private LoginController lc;
    
    @FXML
    private void ButtonT(ActionEvent event){
        btnT.setText("lala");
        System.out.println(UserDAO.getLoginUser().getName());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbname.setText(UserDAO.getLoginUser().getFullname());
        lbpoint.setText(String.valueOf(UserDAO.getLoginUser().getPoint()));
    }    
    
}
