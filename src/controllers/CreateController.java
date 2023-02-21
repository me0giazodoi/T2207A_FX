package controllers;

import daopattern.ClassesDAO;
import database.Database;
import entities.Classes;
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
            Classes c = new Classes(null, name, room);
            ClassesDAO cd = ClassesDAO.getInstance();
            if (cd.create(c))
                backToList(null);
            else
                throw new Exception("Không thể tạo lớp học");
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
