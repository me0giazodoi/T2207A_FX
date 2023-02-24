import controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    public static void main(String[] args) {
        // write file data.txt
//        try {
//            FileOutputStream fos = new FileOutputStream("data.txt");
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeBytes("\nXin chào T2207A");
//            dos.writeBytes("\nĐây là môn JP2");
//            dos.writeBytes("\nBuổi hc về File");
//        }catch (Exception e) {
//
//        }
        // read file
//        try {
//            FileInputStream fis = new FileInputStream("data.txt");
//            DataInputStream dis = new DataInputStream(fis);
//            String txt = dis.readLine();
//            while (txt != null){
//                System.out.println(txt);
//                txt = dis.readLine();
//            }
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
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
