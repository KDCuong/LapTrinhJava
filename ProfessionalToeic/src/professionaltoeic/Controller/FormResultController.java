/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.QuestionAnswer;

public class FormResultController implements Initializable {

    @FXML
    private HBox hbox1;
    @FXML
    private VBox vba;
    @FXML
    private Label lbpoint;

    private int point = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<QuestionAnswer> qAns = QuestionDAO.getQuestionAnswer();
        List<Question> qt = QuestionDAO.getQuestionUse();
        System.out.println(qAns.get(1).getuAnswer());
        for (int i = 0; i < qt.size(); i++) {
            if (qAns.get(i).getCorrect() == 1) {
                Button btn = new Button(String.valueOf(qAns.get(i).getqNumber()));
                btn.setStyle("-fx-background-color:Green;-fx-border-color:Black;");
                             btn.setOnAction((event) -> {
                   Label lb =new Label(qt.get(Integer.parseInt(btn.getText())-1).getAnswer());
                    vba.getChildren().add(lb);
             });
                hbox1.getChildren().addAll(btn);
                point++;
            } else {
                Button btn = new Button(String.valueOf(qAns.get(i).getqNumber()));
                btn.setStyle("-fx-background-color:red;-fx-border-color:Black;");
                             btn.setOnAction((event) -> {
                Label lb =new Label(qt.get(Integer.parseInt(btn.getText())-1).getAnswer());
                vba.getChildren().add(lb);
             });
                hbox1.getChildren().addAll(btn);
            }
            
            
            
            HBox hb = new HBox();
            Label lbq = new Label("Câu" + qAns.get(i).getqNumber() + ": ");
            lbq.setFont(Font.font(24));
            Label lba = new Label(qt.get(i).getAnswer());
            lba.setFont(Font.font(24));
            hb.getChildren().addAll(lbq, lba);
            vba.getChildren().add(hb);
        }
        lbpoint.setText(String.valueOf(point) + "/" + qAns.size());
    }

    
    public void callMainUser(ActionEvent event) throws IOException {
        QuestionDAO.setQuestionUseNull();
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "MainUser");
    }

}
