import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ThongTin {
    public TextField txtFullName;
    public TextField txtEmail;

    public void Submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String el = txtEmail.getText();
        System.out.println("Full Name: "+fn);
        System.out.println("Email: "+el);
    }
}
