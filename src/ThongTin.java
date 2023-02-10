import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class ThongTin implements Initializable {
    public TextField txtFullName;
    public TextField txtEmail;
    public static TextField stFullName;
    public static TextField stEmail;
    public Text txtInfo;

    public ObservableList<Student> ListStudent = FXCollections.observableArrayList();
    public static Student editStudent;
    public TableView<Student> tbview;
    public TableColumn<Student,String> cFullname;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student, Button> cAction;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String em = txtEmail.getText();

        if (editStudent == null){
            Student s = new Student(fn,em);
            ListStudent.add(s);
        }else{
//            editStudent.setFullName(fn);
//            editStudent.setEmail(em);
            for (Student s: ListStudent){
                if (s.getEmail().equals(editStudent.email)
                        && s.fullName.equals(editStudent.fullName)){
                    s.setFullName(fn);
                    s.setEmail(em);
                }
            }
        }
        tbview.setItems( ListStudent);
        tbview.refresh();
        editStudent = null;
        clearInput();
    }

    void clearInput(){
        txtEmail.clear();
        txtFullName.clear();
    }

    public void edit(MouseEvent mouseEvent) {
//        editStudent = lv.getSelectionModel().getSelectedItem();
        txtFullName.setText(editStudent.getFullName());
        txtEmail.setText(editStudent.getEmail());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cFullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stFullName = txtFullName;
        stEmail = txtEmail;
    }
}

//        // lambda expression
//        IStudent s1 = (a)->{
//
//        };
//        s1.learn(5);
//        ArrayList<String> arrs = new ArrayList<>();
//        arrs.add("Hello");
//        arrs.add("world");
//
//        arrs.stream().filter(s->!s.equals("a")).forEach(s->{
//            System.out.println(s);
//        });
