package controllers;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;
import java.sql.Statement;

public class AddInfoController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtGender;
    public ComboBox txtClassId;
    public DatePicker txtDate;


    public void backToInfo(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/info.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String gender = txtGender.getText();
            if (name.isEmpty() || email.isEmpty() || gender.isEmpty()) {
                throw new Exception("Vui lòng điền đầy đủ thông tin");
            }
            Database db = new Database();
            Statement stt = db.getStatement();
            String sql = "insert into sinhvien(name,email,gender) values('"+name+"','"+email+"','"+gender+"')";
            stt.executeUpdate(sql);
            backToInfo(null);
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
