package forms;

import Service.Connection;
import Service.Request;
import Service.FunctionsForForms;
import forms.handbooks.Student;
import forms.handbooks.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Locale;

public class TeacherForm {
    private ObservableList<Teacher> listOfTeacher = FXCollections.observableArrayList();
    private ObservableList<Teacher> listOfTeacherDiscipline = FXCollections.observableArrayList();

    @FXML
    private TableView tableViewTeacher;
    @FXML
    private TableColumn<Teacher, String> fio;
    @FXML
    private TableView tableViewTeacherDiscipline;
    @FXML
    private TableColumn<Teacher, String> fioTeacher;
    @FXML
    private TableColumn<Teacher, String> discipline;
    @FXML
    private void initialize(){
        tableViewTeacher.setVisible(true);
        tableViewTeacherDiscipline.setVisible(false);
        initList();
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        tableViewTeacher.setItems(listOfTeacher);

        initListTD();
        fioTeacher.setCellValueFactory(new PropertyValueFactory<>("fio"));
        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
        tableViewTeacherDiscipline.setItems(listOfTeacherDiscipline);

    }

    private void initList(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            ResultSet rs = Connection.stmt.executeQuery(Request.teacherTable);
            while (rs.next()){
                listOfTeacher.add(new Teacher(rs.getString(1)));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initListTD(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            ResultSet rs = Connection.stmt.executeQuery(Request.teacherDisciplineTable);
            while (rs.next()){
                listOfTeacherDiscipline.add(new Teacher(rs.getString(1), rs.getString(2)));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   /* public void openStage(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/
    @FXML
    private void editing() throws IOException {

        FunctionsForForms f = new FunctionsForForms();
        f.openStage("editingTeacher.fxml");

    }
    @FXML
    private void showDiscipline(){

        tableViewTeacher.setVisible(false);
        tableViewTeacherDiscipline.setVisible(true);

    }

    @FXML
    private void showTeacher(){
        tableViewTeacherDiscipline.setVisible(false);
        tableViewTeacher.setVisible(true);

       // listOfTeacher.add(new Teacher("Гораций Слизнорт"));
    }

    @FXML
    private void addTeacher(){

    }
}
