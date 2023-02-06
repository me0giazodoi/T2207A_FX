package assignment15;

public class Human {
    String Name;
    String Phone;

    public Human(String name, String phone) {
        Name = name;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    public String toString(){
        return this.Name+ "--"+this.Phone;
    }
}
