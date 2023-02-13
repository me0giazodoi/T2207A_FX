package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class InfoStudentController {
    public void goToAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/add.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }
}
