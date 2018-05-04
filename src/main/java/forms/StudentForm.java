package forms;

import Service.Connection;
import Service.Request;
import forms.handbooks.Class;
import forms.handbooks.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.util.Locale;

public class StudentForm {
    private ObservableList<Student> listOfStudent = FXCollections.observableArrayList();

    @FXML
    private TableView tableViewStudent;
    @FXML
    private TableColumn<Student, String> fio;
    @FXML
    private TableColumn<Student, String> group;
    @FXML
    private void initialize(){
        initList();

        fio.setCellValueFactory(new PropertyValueFactory<>("FIO"));
     //   group.setCellValueFactory(new PropertyValueFactory<>("group"));

        tableViewStudent.setItems(listOfStudent);
    }

    private void initList(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            ResultSet rs = Connection.stmt.executeQuery(Request.studentTable);
            while (rs.next()){
              //  listOfStudent.add(new Student(rs.getString(1), rs.getString(2)));
                listOfStudent.add(new Student((rs.getString(1))));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
