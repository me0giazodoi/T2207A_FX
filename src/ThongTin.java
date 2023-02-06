import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ThongTin {
    public TextField txtFullName;
    public TextField txtEmail;
    public Text txtInfo;

    public ArrayList<Student> ListStudent = new ArrayList<>();
    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String em = txtEmail.getText();

        Student s = new Student(fn,em);
        ListStudent.add(s);
        String txt = "";
        for (Student sv: ListStudent){
            txt+= "\n==========\n"+sv.toString();
        }
        txtInfo.setText(txt);
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

    }
}
