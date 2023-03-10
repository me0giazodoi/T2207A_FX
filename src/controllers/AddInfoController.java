package controllers;

import daopattern.ClassesDAO;
import daopattern.StudentDAO;
import database.Database;
import entities.Classes;
import entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddInfoController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public ComboBox<String> cbGender;
    public ComboBox<Classes> cbClass;
    public DatePicker txtBirthday;


    public void backToInfo(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/info.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> gt = FXCollections.observableArrayList();
        gt.add("Male");
        gt.add("Female");
        cbGender.setItems(gt);

        try{
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from lophoc";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Classes> list = FXCollections.observableArrayList();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                Classes c = new Classes(id, name, room);
                list.add(c);
                cbClass.setItems(list);
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String birthday = Date.valueOf(txtBirthday.getValue()).toString();
            String gender = cbGender.getValue();
            Integer class_id = cbClass.getValue().getId();
            if (name.isEmpty() || email.isEmpty() || birthday.isEmpty() || gender.isEmpty() || class_id == null) {
                throw new Exception("Vui l??ng ??i???n ?????y ????? th??ng tin");
            }
            Student s = new Student(null, name, email, Date.valueOf(birthday), gender, class_id);
            StudentDAO cd = StudentDAO.getInstance();
            if (cd.create(s))
                backToInfo(null);
            else
                throw new Exception("Kh??ng th??? t???o l???p h???c");
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
