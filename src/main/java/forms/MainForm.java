package forms;


import Service.*;
import forms.handbooks.Class;
import forms.handbooks.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Locale;

public class MainForm{

    private ObservableList<Class> listOfClass = FXCollections.observableArrayList();
    @FXML
    private TableView tableView;
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

        discipline.setCellFactory(TextFieldTableCell.forTableColumn());
        discipline.setOnEditCommit(t -> { (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDiscipline(t.getNewValue()); }
        );



        group.setCellFactory(TextFieldTableCell.forTableColumn());
        group.setOnEditCommit(t -> {
            ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setGroup(t.getNewValue());
            //   changeValue("update PREPODAVATEL set fio = \'" + t.getNewValue() + "\' where fio = \'" + t.getOldValue() + "\'" );

        }
        );

        teacher.setCellFactory(TextFieldTableCell.forTableColumn());
        teacher.setOnEditCommit(t -> {
            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setTeacher(t.getNewValue());
            //   changeValue("update PREPODAVATEL set fio = \'" + t.getNewValue() + "\' where fio = \'" + t.getOldValue() + "\'" );

        }
        );

        vid.setCellFactory(TextFieldTableCell.forTableColumn());
        vid.setOnEditCommit(t -> {
            ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setVid(t.getNewValue());
            //   changeValue("update PREPODAVATEL set fio = \'" + t.getNewValue() + "\' where fio = \'" + t.getOldValue() + "\'" );

        }
        );

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

    public void openStage(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void openStudentForm(ActionEvent actionEvent) throws IOException {
      openStage("student.fxml");

    }

    @FXML
    public void openTeacherForm(ActionEvent actionEvent) throws IOException {
       openStage("teacher.fxml");
    }

    @FXML
    private void facultetTable() throws IOException {
        openStage("facultet.fxml");
    }
    @FXML
    private void specialnostTable() throws IOException {
        openStage("specialnost.fxml");
    }
    @FXML
    private void marksTable() throws IOException {
        openStage("mark.fxml");
    }

    @FXML
    private void disciplineTable() throws IOException {
        openStage("discipline.fxml");
    }

}
