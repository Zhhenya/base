package forms;

import Service.Connection;
import Service.Request;
import forms.handbooks.Class;
import forms.handbooks.Student;
import forms.handbooks.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Pane editingPane;
    @FXML
    private TextField addStudent;
    @FXML
    private TextField addGroup;
    @FXML
    private Pane pane;
    @FXML
    private TextField findStudent;



    @FXML
    private void initialize(){
        initList();

        fio.setCellValueFactory(new PropertyValueFactory<>("FIO"));
     //   group.setCellValueFactory(new PropertyValueFactory<>("group"));

        tableViewStudent.setItems(listOfStudent);

        tableViewStudent.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                try {
                    openStage(listOfStudent, "editStudent.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initList(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            ResultSet rs = Connection.stmt.executeQuery(Request.studentTable);
            while (rs.next()){
                listOfStudent.add(new Student((rs.getString(1))));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void addStudent(ActionEvent actionEvent) {
        Locale.setDefault(Locale.ENGLISH);
        try{
            String name = "(\'" + addStudent.getText() + "\')";

            ResultSet rs = Connection.stmt.executeQuery("insert into student (FIO) values " + name);
            listOfStudent.add(new Student(addStudent.getText()));

            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addInfo(ActionEvent actionEvent) {
    }


    public void findStudent(ActionEvent actionEvent) {
    }

    public void show(ActionEvent actionEvent) {
    }

    public void editing(ActionEvent actionEvent) {
    }



    public void openStage(ObservableList<Student> list, String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
