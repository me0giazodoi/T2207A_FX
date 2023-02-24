package daopattern;

import database.Database;
import entities.Student;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student> {
    private static StudentDAO instance;
    private StudentDAO(){

    }
    public static  StudentDAO getInstance(){
        if (instance == null)
            instance = new StudentDAO();
        return instance;
    }
    public ArrayList<Student> getAll(){
        ArrayList<Student> list = new ArrayList<>();
        try {
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from sinhvien";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                String gender = rs.getString("gender");
                Integer class_id = rs.getInt("class_id");
                Student s = new Student(id,name,email,birthday,gender,class_id);
                list.add(s);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public boolean create(Student student){
        try{
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into sinhvien(name,email,birthday,gender,class_id) values('"+student.getName()+"','"+student.getEmail()+"','"+student.getBirthday()+"','"+student.getGender()+"','"+student.getClass_id()+"')";
            if (stt.executeUpdate(sql)>0){
                return true;
            }
        }catch (Exception e) {
        }
        return false;
    }
    public boolean update (Student student){
        try{
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "update sinhvien set name = '"+student.getName()+"', email = '"+student.getEmail()+"', birthday = '"+student.getBirthday()+"', gender = '"+student.getGender()+"', class_id = '"+student.getClass_id()+"' where id = "+student.getId();
            if (stt.executeUpdate(sql)>0){
                return true;
            }
        }catch (Exception e) {
        }
        return false;
    }
    public boolean delete(Student student){
        try{
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "delete from sinhvien where id= "+student.getId();
            if (stt.executeUpdate(sql)>0){
                return true;
            }
        }catch (Exception e) {
        }
        return false;
    }
    public Student find(Integer id){
        try {
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from sinhvien where id="+id;
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                String gender = rs.getString("gender");
                Integer class_id = rs.getInt("class_id");
                Student s = new Student(id,name,email,birthday,gender,class_id);
                return s;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
