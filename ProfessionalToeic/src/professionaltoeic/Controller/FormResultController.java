/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import com.sun.javafx.css.Style;
import com.sun.webkit.dom.CSSRuleImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import professionaltoeic.DAO.QuestionDAO;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.Question;
import professionaltoeic.Model.QuestionAnswer;
import professionaltoeic.Model.User;

public class FormResultController implements Initializable {

    @FXML
    private HBox hbox1;
    @FXML
    private HBox hbox2;
    @FXML
    private HBox hbox3;
    @FXML
    private VBox vba;
    @FXML
    private Label lbpoint;

    private int point = 0;
    private int type = 0;
    private int numberQuestion = 0;
    private UserDAO us;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type = QuestionDAO.getTypeQuestionFlag();
        List<QuestionAnswer> qAns = QuestionDAO.getQuestionAnswer();
        List<Question> listQuestion = QuestionDAO.getQuestionUse();
        System.out.println(qAns.get(1).getuAnswer());
        for (int i = 0; i < listQuestion.size(); i++) {
            if (qAns.get(i).getCorrect() == 1) {
                Button btn = new Button(String.valueOf(qAns.get(i).getqNumber()));
                btn.setStyle("-fx-background-color:Green;-fx-border-color:Black;");
                btn.setOnAction((event) -> {
                    showAnswer(btn, listQuestion);
                });
                if (numberQuestion < 15) {
                    hbox1.getChildren().addAll(btn);
                } else if (numberQuestion >= 15 && numberQuestion < 30) {
                    hbox2.getChildren().addAll(btn);
                } else {
                    hbox3.getChildren().addAll(btn);
                }
                point++;
                numberQuestion++;
            } else {
                Button btn = new Button(String.valueOf(qAns.get(i).getqNumber()));
                btn.setStyle("-fx-background-color:red;-fx-border-color:Black;");
                btn.setOnAction((event) -> {
                    showAnswer(btn, listQuestion);
                });
                if (numberQuestion < 15) {
                    hbox1.getChildren().addAll(btn);
                } else if (numberQuestion >= 15 && numberQuestion < 30) {
                    hbox2.getChildren().addAll(btn);
                } else {
                    hbox3.getChildren().addAll(btn);
                }
                numberQuestion++;
            }
        }
        lbpoint.setText(String.valueOf(point) + "/" + qAns.size());
        if (type == 4) {
            User user = UserDAO.getLoginUser();
            int currentpoint = point * 20;
            String name = user.getName();
            String date = LocalDate.now().toString();
            if (currentpoint > user.getPoint()) {
                user.setPoint(currentpoint);
                try {
                    us = new UserDAO();
                    us.updatePoint(user);
                } catch (SQLException ex) {
                    Logger.getLogger(FormResultController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormResultController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            lbpoint.setText(String.valueOf(point * 20) + "/" + qAns.size() * 20);
            try {
                us = new UserDAO();
                us.insertHistory(name, currentpoint, date);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormResultController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FormResultController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Go to Main User scene
    public void callMainUser(ActionEvent event) throws IOException {
        QuestionDAO.setQuestionUseNull();
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "MainUser");
    }

    //Button Click get Answer
    public void showAnswer(Button btn, List<Question> listQuestion) {
        int quest = Integer.parseInt(btn.getText()) - 1;

        vba.getChildren().clear();
        Label lb = new Label("Câu Đúng : " + listQuestion.get(quest).getAnswer());
        lb.setFont(Font.font(18));
        lb.setStyle("-fx-font-weight: bold;-fx-font-size: 30;");
        if (type == 1) {
            StackPane sp = new StackPane();
            String urlimage = "Image/" + listQuestion.get(quest).getImage();
            Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(urlimage).toString());
            ImageView img = new ImageView();
            img.setImage(image);
            img.setFitWidth(600);
            img.setFitHeight(400);
            sp.getChildren().add(img);
            Label lbExplain = new Label(listQuestion.get(quest).getExplain());
            lbExplain.setFont(Font.font(18));
            lbExplain.setStyle("-fx-font-weight: bold;-fx-font-size: 30;");
            vba.getChildren().addAll(sp, lb, lbExplain);
        }
        if (type == 2) {
            vba.getChildren().addAll(lb);
        }
        if (type == 3) {
            StackPane sp = new StackPane();
            String urlimage = "Explain/" + listQuestion.get(quest).getExplain();
            Image image = new Image(professionaltoeic.ProfessionalToeic.class.getResource(urlimage).toString());
            ImageView img = new ImageView();
            img.setImage(image);
            img.setFitWidth(600);
            img.setFitHeight(400);
            sp.getChildren().add(img);
            vba.getChildren().addAll(sp, lb);
        }
        if (type == 4) {
            vba.getChildren().addAll(lb);
        }
    }
}
