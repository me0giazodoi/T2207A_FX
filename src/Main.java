import controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        HomeController.rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("resources/home.fxml"));
        primaryStage.setScene(new Scene(root,888,688));
        primaryStage.show();
    }
}
