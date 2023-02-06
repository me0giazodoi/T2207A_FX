package assignment15;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DanhSach extends Human {
    public TextField txtName;
    public TextField txtPhone;
    public Text txtDanhSach;
    public ObservableList<Human> ListHuman = FXCollections.observableArrayList();
    public ListView<Human> lv;
    public Human editHuman;

    public DanhSach(String name, String phone) {
        super(name, phone);
    }

    public void submit(ActionEvent actionEvent) {
        String nm = txtName.getText();
        String ph = txtPhone.getText();

        if (editHuman == null){
            Human hm = new DanhSach(nm,ph);
            ListHuman.add(hm);
        }else{
            for (Human s: ListHuman){
                if (s.getPhone().equals(editHuman.getPhone())
                        && nm.equals(editHuman.getName())){
                    s.setName(nm);
                    s.setPhone(ph);
                }
            }
        }
        lv.setItems( ListHuman);
        lv.refresh();
        editHuman = null;
        clearInput();
    }

    void clearInput(){
        txtPhone.clear();
        txtName.clear();
    }

    public void edit(MouseEvent mouseEvent) {
        editHuman = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editHuman.getName());
        txtPhone.setText(editHuman.getPhone());
    }
}
