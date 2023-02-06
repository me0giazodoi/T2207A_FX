import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class ThongTin {
    public TextField txtFullName;
    public TextField txtEmail;
    public Text txtInfo;

    public ObservableList<Student> ListStudent = FXCollections.observableArrayList();
    public ListView<Student> lv;
    public Student editStudent;

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
        lv.setItems( ListStudent);
        lv.refresh();
        editStudent = null;
        clearInput();
    }

    void clearInput(){
        txtEmail.clear();
        txtFullName.clear();
    }

    public void edit(MouseEvent mouseEvent) {
        editStudent = lv.getSelectionModel().getSelectedItem();
        txtFullName.setText(editStudent.getFullName());
        txtEmail.setText(editStudent.getEmail());
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
