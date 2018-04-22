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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
    private int type = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type = QuestionDAO.getTypeQuestionFlag();
        List<QuestionAnswer> qAns = QuestionDAO.getQuestionAnswer();
        List<Question> qt = QuestionDAO.getQuestionUse();
        System.out.println(qAns.get(1).getuAnswer());
        for (int i = 0; i < qt.size(); i++) {
            if (qAns.get(i).getCorrect() == 1) {
                Button btn = new Button(String.valueOf(qAns.get(i).getqNumber()));
                btn.setStyle("-fx-background-color:Green;-fx-border-color:Black;");
                btn.setOnAction((event) -> {
                    int quest = Integer.parseInt(btn.getText()) - 1;

                    vba.getChildren().clear();
                    Label lb = new Label("Câu Đúng :" + qt.get(quest).getAnswer());
                    lb.setFont(Font.font(18));

                    if (type == 1) {
                        StackPane sp = new StackPane();
                        String urlimage = "Explain/" + qt.get(quest).getExplain();
                        Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(urlimage).toString());
                        ImageView img = new ImageView();
                        img.setImage(image);
                        img.setFitWidth(300);
                        img.setFitHeight(300);
                        sp.getChildren().add(img);
                        sp.setMaxSize(300, 300);
                        Label lbq1 = new Label("Câu A." + qt.get(quest).getAnswer1());
                        Label lbq2 = new Label("Câu B." + qt.get(quest).getAnswer2());
                        Label lbq3 = new Label("Câu C." + qt.get(quest).getAnswer3());
                        Label lbq4 = new Label("Câu D." + qt.get(quest).getAnswer4());
                        lbq1.setFont(Font.font(18));
                        lbq2.setFont(Font.font(18));
                        lbq3.setFont(Font.font(18));
                        lbq4.setFont(Font.font(18));
                        vba.getChildren().addAll(sp, lbq1, lbq2, lbq3, lbq4, lb);
                    }
                    if (type == 2) {
                        vba.getChildren().addAll(lb);
                    }
                    if (type == 3) {
                        StackPane sp = new StackPane();
                        String urlimage = "Explain/" + qt.get(quest).getExplain();
                        Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(urlimage).toString());
                        ImageView img = new ImageView();
                        img.setImage(image);
                        img.setFitWidth(300);
                        img.setFitHeight(300);
                        sp.getChildren().add(img);
                        sp.setMaxSize(300, 300);
                        vba.getChildren().addAll(sp, lb);
                    }

                });
                hbox1.getChildren().addAll(btn);
                point++;
            } else {
                Button btn = new Button(String.valueOf(qAns.get(i).getqNumber()));
                btn.setStyle("-fx-background-color:red;-fx-border-color:Black;");
                btn.setOnAction((event) -> {
                    int quest = Integer.parseInt(btn.getText()) - 1;

                    vba.getChildren().clear();
                    Label lb = new Label("Câu Đúng :" + qt.get(quest).getAnswer());
                    lb.setFont(Font.font(18));

                    if (type == 1) {
                        StackPane sp = new StackPane();
                        String urlimage = "Explain/" + qt.get(quest).getExplain();
                        Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(urlimage).toString());
                        ImageView img = new ImageView();
                        img.setImage(image);
                        img.setFitWidth(300);
                        img.setFitHeight(300);
                        sp.getChildren().add(img);
                        sp.setMaxSize(300, 300);
                        Label lbq1 = new Label("Câu A." + qt.get(quest).getAnswer1());
                        Label lbq2 = new Label("Câu B." + qt.get(quest).getAnswer2());
                        Label lbq3 = new Label("Câu C." + qt.get(quest).getAnswer3());
                        Label lbq4 = new Label("Câu D." + qt.get(quest).getAnswer4());
                        lbq1.setFont(Font.font(18));
                        lbq2.setFont(Font.font(18));
                        lbq3.setFont(Font.font(18));
                        lbq4.setFont(Font.font(18));
                        vba.getChildren().addAll(sp, lbq1, lbq2, lbq3, lbq4, lb);
                    }
                    if (type == 2) {
                        vba.getChildren().addAll(lb);
                    }
                    if (type == 3) {
                        StackPane sp = new StackPane();
                        String urlimage = "Explain/" + qt.get(quest).getExplain();
                        Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(urlimage).toString());
                        ImageView img = new ImageView();
                        img.setImage(image);
                        img.setFitWidth(300);
                        img.setFitHeight(300);
                        sp.getChildren().add(img);
                        sp.setMaxSize(300, 300);
                        vba.getChildren().addAll(sp, lb);
                    }

                });
                hbox1.getChildren().addAll(btn);
            }

//            HBox hb = new HBox();
//            Label lbq = new Label("Câu" + qAns.get(i).getqNumber() + ": ");
//            lbq.setFont(Font.font(24));
//            Label lba = new Label(qt.get(i).getAnswer());
//            lba.setFont(Font.font(24));
//            hb.getChildren().addAll(lbq, lba);
//            vba.getChildren().add(hb);
        }
        lbpoint.setText(String.valueOf(point) + "/" + qAns.size());
    }

    public void callMainUser(ActionEvent event) throws IOException {
        QuestionDAO.setQuestionUseNull();
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "MainUser");
    }

}
