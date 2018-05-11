package forms;


import Service.*;
import forms.handbooks.Both;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @FXML
    private TableColumn<Class, String> id;


    @FXML
    private TextField addDiscipline;
    @FXML
    private TextField addGroup;
    @FXML
    private TextField addTeacher;
    @FXML
    private TextField addVid;

    @FXML
    private void initialize(){

        printTable();


        id.setCellValueFactory(new PropertyValueFactory<>("index"));
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
                listOfClass.add(new Class(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getInt(5)));
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

   /* private void errorWindow(String error ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
    }*/

    @FXML
    private void addPara(ActionEvent actionEvent) {
        Locale.setDefault(Locale.ENGLISH);
        int idDiscipline = 0, idTeacher = 0, idGroup = 0, idVid = 0;
        try{
            String discipline = "\'" + addDiscipline.getText() + "\'";
            String group = "\'" + addGroup.getText() + "\'";
            String teacher = "\'" + addTeacher.getText() + "\'";
            String vid = "\'" + addVid.getText() + "\'";
       /*     if(discipline.compareTo("''" ) == 0 || group.compareTo("''") == 0 || teacher.compareTo("''") == 0 || vid.compareTo("''") == 0){
                errorWindow("Все поля должны быть заполнены!!!");
                return;
            }*/
            ResultSet rs = Connection.stmt.executeQuery("select DISCIPLINA.PK_DISC from DISCIPLINA where DISCIPLINA.NAME = " + discipline);
            rs.next();
            idDiscipline  = rs.getInt(1);
            rs.close();

            rs = Connection.stmt.executeQuery("select PREPODAVATEL.PK_PREPOD from PREPODAVATEL where PREPODAVATEL.FIO = " + teacher);
            rs.next();
            idTeacher = rs.getInt(1);
            rs.close();

            rs = Connection.stmt.executeQuery("select GROUPPA.PK_GROUP from GROUPPA where GROUPPA.NAME = " + group );
            rs.next();
            idGroup = rs.getInt(1);
            rs.close();

            rs = Connection.stmt.executeQuery("select VID.PK_VID from VID where VID.VID = " + vid );
            rs.next();
            idVid = rs.getInt(1);
            rs.close();


            String para = "( \'" + idDiscipline + "\', \'" + idGroup + "\', \'" + idTeacher + "\',\'" + idVid + "\')";
            rs = Connection.stmt.executeQuery("insert into PARA (DISCIPLINA_PK_DISC, GROUP_PK_GROUP, PREPODAVATEL_PK_PREPOD, VID_PK_VID) values " + para);
            listOfClass.add(new Class(addDiscipline .getText(), addGroup.getText(), addTeacher.getText(), addVid.getText()));
            rs.close();




        }catch (Exception e){
            FunctionsForForms.errorWindow("Значение поля не найдено");
            e.printStackTrace();
        }

    }
    @FXML
    private void deleteRow(){
        int row = tableView.getSelectionModel().getSelectedIndex();
        Class c = (Class)tableView.getSelectionModel().getSelectedItem();
        listOfClass.remove(row);

        ResultSet rs = null;
        try {
            rs = Connection.stmt.executeQuery("delete from PARA where PARA.PK_PARA = " + c.getIndex() );
            rs.next();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        tableView.getItems().remove(row);

    }
}
