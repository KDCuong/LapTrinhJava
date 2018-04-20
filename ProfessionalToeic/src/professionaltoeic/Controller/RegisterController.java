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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class RegisterController implements Initializable {

    @FXML
    private Label lbId;
    @FXML
    private Label lbPw;
    @FXML
    private Button btnDk;
    @FXML
    private Button btnB;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPw;
    private int i, tid, tpw;
    private UserDAO uDAO;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void ButtonAction(ActionEvent event) throws IOException {
       
         SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "Login");
    }

    @FXML
    private void TfId(KeyEvent event) throws ClassNotFoundException, SQLException {
        uDAO = new UserDAO();
        String id = tfId.getText();
        User user = uDAO.getUser(id);
        if (user != null) {
            lbId.setText("Id đã có người sử dụng");
            tid = 0;
        } else {
            lbId.setText("Bạn có thể sử dụng ID này");
            tid = 1;
        }
    }

    @FXML
    private void TfPw(KeyEvent event) {
        i = tfPw.getText().length();
        if (i <= 8 && i >= 6) {
            lbPw.setText("Bạn có thể sử dụng password này");
            tpw = 1;

        } else {
            lbPw.setText("Đặt pass từ 6-8 kí tự ");
            tpw = 0;
        }
    }

    @FXML
    private void ButtonRegister(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (tid == 1 && tpw == 1) {
            System.out.println("chuẩn");
            uDAO = new UserDAO();
            uDAO.insertUser(tfId.getText(), tfPw.getText(), tfName.getText(), tfEmail.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thành công");
            alert.setHeaderText("Đăng Ký Thành công");
            alert.setContentText(null);
            alert.getButtonTypes();
            alert.show();
        } else {
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
