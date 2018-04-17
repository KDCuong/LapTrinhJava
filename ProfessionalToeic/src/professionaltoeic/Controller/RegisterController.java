/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
    private int i,tid,tpw;
    private String x;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void ButtonAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Login.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void TfId(KeyEvent event){
    if(tfId.getText().equals("concac"))
    {
        lbId.setText("Id đã có người sử dụng");
        tid=0;
    }
    else
    {
        lbId.setText("Hợp lý,triển");
        tid=1;
    }
    }
    @FXML
    private void TfPw(KeyEvent event){
        i=tfPw.getText().length();
       if(i<=8 && i>=6)
        {
            lbPw.setText("Đm thằng này giỏi");
            tpw=1;
            
        }
        else
       {
            lbPw.setText("đặt pass từ 6-8 kí tự hộ thằng lz");
            tpw=0;
       }
    }
    @FXML
    private void ButtonRegister(ActionEvent event){
       if(tid==1 && tpw==1)
       {
           System.out.println("chuẩn");
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Thành công");
           alert.setHeaderText("Thành công cmnr");
           alert.setContentText(null);
           alert.getButtonTypes();
           alert.show();
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
