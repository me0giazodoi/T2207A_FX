package controllers;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Statement;

public class CreateController {
    public TextField txtName;
    public TextField txtRoom;

    public void backToList(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/classes/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void submit(ActionEvent actionEvent) {
        try{
            String name = txtName.getText();
            String room = txtRoom.getText();
            if (name.isEmpty() || room.isEmpty()) {
                throw new Exception("Vui lòng điền đầy đủ thông tin");
            }
            Database db = new Database();
            Statement stt = db.getStatement();
            String sql = "insert into lophoc(name,room) values('"+name+"','"+room+"')";
            stt.executeUpdate(sql);
            backToList(null);
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
