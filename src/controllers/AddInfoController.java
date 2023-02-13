package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class AddInfoController {
    public void backToInfo(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/student/info.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }
}
