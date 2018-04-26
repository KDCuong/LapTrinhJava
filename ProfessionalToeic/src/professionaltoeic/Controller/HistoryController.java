/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professionaltoeic.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import professionaltoeic.DAO.UserDAO;
import professionaltoeic.Model.History;
import professionaltoeic.Model.User;

/**
 * FXML Controller class
 *
 * @author curly
 */
public class HistoryController implements Initializable {

    public TableView<History> tbHistory;
    public TableColumn<History, String> colDate;
    public TableColumn<History, Integer> colPoint;
    
    private ObservableList<History> list =getHistoryList()  ;
    private UserDAO uDAO;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadHistoryData();
        // TODO
        // TODO
    }    
    
    //Load list data
    private ObservableList<History> getHistoryList() {
        User user = UserDAO.getLoginUser();
        try {
            uDAO = new UserDAO();
        List<History> historyList;
        historyList=(List<History>) uDAO.getHistory(user.getName());
        list =FXCollections.observableList(historyList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType("OK"));
            alert.showAndWait();
        }
        return list;
    }
    
    //Load data tabel view
    public void loadHistoryData() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPoint.setCellValueFactory(new PropertyValueFactory<>("point"));
        tbHistory.setItems(list);
    }
    
    //Go to Main User scene
    public void callMainUser(ActionEvent event) throws IOException {
        SceneMovement sm = new SceneMovement();
        sm.callNewScene(event, "MainUser");
    }
}
