package forms;


import Service.*;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Locale;

public class MainForm{

    private ObservableList<Class> listOfClass = FXCollections.observableArrayList();
    @FXML
    private TableView<Class> tableView;
    @FXML
    private TableColumn<Class, String> discipline;
    @FXML
    private TableColumn<Class, String> group;
    @FXML
    private TableColumn<Class, String> teacher;
    @FXML
    private TableColumn<Class, String> vid;
   /* @FXML
    private TabPane tabPane;
    @FXML
    private Tab studentGroup;
    @FXML
    private TableView tableViewStudent;
    @FXML
    private TableColumn<Student, String> groupStudent;
    @FXML
    private TableColumn<Student, String> fioStudent;
    @FXML
    private Tab teacherDiscipline;
    @FXML
    private TableView tableViewTeacher;
    @FXML
    private TableColumn<Teacher, String> fioTeacher;
    @FXML
    private TableColumn<Teacher, String> disciplineTeacher;*/

    @FXML
    private void initialize(){

        printTable();

        discipline.setCellValueFactory(new PropertyValueFactory<>("Discipline"));
        group.setCellValueFactory(new PropertyValueFactory<>("Group"));
        teacher.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        vid.setCellValueFactory(new PropertyValueFactory<>("Vid"));

        tableView.setItems(listOfClass);


    }

    private void printTable(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            ResultSet rs = Connection.stmt.executeQuery(Request.paraTable);
            while (rs.next()){
                listOfClass.add(new Class(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3)));
            }
            rs.close();
         //   Connection.closeConnection();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

  /*  public void openStage(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    public void openStudentForm(ActionEvent actionEvent) throws IOException {
      /*  Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

      FunctionsForForms f = new FunctionsForForms();
      f.openStage("student.fxml");

    }

    @FXML
    public void openTeacherForm(ActionEvent actionEvent) throws IOException {
       /* Parent root = FXMLLoader.load(getClass().getResource("teacher.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/


       FunctionsForForms f = new FunctionsForForms();
       f.openStage("forms/teacher.fxml");
    }
}
