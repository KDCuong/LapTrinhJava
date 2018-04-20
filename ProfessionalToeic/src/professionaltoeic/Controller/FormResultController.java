/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;


import java.awt.Color;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;

import javafx.scene.layout.HBox;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.QuestionAnswer;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class FormResultController implements Initializable {

    @FXML
    private HBox hbox1;
    @FXML
    private Label lbpoint;
    
    private int point=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<QuestionAnswer> qAns =QuestionDAO.getQuestionAnswer();
        System.out.println(qAns.get(1).getuAnswer());
        for (int i = 0; i < qAns.size(); i++) {
            if(qAns.get(i).getCorrect()==1){
            Button btn =new Button(String.valueOf(qAns.get(i).getqNumber()));
            btn.setStyle("-fx-background-color:Green;-fx-border-color:Black;");
            hbox1.getChildren().addAll(btn);
            point++;
        }
            else{
                Button btn =new Button(String.valueOf(qAns.get(i).getqNumber()));
            btn.setStyle("-fx-background-color:red;-fx-border-color:Black;");
            hbox1.getChildren().addAll(btn);
            }
        }
        lbpoint.setText(String.valueOf(point)+"/20");
        
        // TODO
    }    
    
}
