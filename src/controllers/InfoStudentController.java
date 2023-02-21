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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InfoStudentController implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student, Integer> cId;
    public TableColumn<Student, String> cName;
    public TableColumn<Student, String> cEmail;
    public TableColumn<Student, Date> cBirthday;
    public TableColumn<Student, String> cGender;
    public TableColumn<Student, Integer> cClass;
    public TableColumn<Student, Button> cAction;

    public void goToAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/add.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cClass.setCellValueFactory(new PropertyValueFactory<>("class_id"));

        StudentDAO cd = StudentDAO.getInstance();
        ArrayList<Student> tths = cd.getAll();
        tbStudent.getItems().addAll(tths);
        tbStudent.refresh();
    }
}
