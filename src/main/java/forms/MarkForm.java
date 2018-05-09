package forms;

import Service.Connection;
import Service.Request;
import forms.handbooks.Class;
import forms.handbooks.Mark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.util.Locale;

public class MarkForm {
    private ObservableList<Mark> listOfMark = FXCollections.observableArrayList();

    @FXML
    private TableView<Mark> tableView;
    @FXML
    private TableColumn<Mark, String> discipline;
    @FXML
    private TableColumn<Mark, String> vid;
    @FXML
    private TableColumn<Mark, String> mark;
    @FXML
    private TableColumn<Mark, String> teacher;
    @FXML
    private TableColumn<Mark, String> student;


    @FXML
    private void initialize(){
        printTable();

        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
        student.setCellValueFactory(new PropertyValueFactory<>("student"));
        teacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        vid.setCellValueFactory(new PropertyValueFactory<>("vid"));
        mark.setCellValueFactory(new  PropertyValueFactory<>("mark"));

        tableView.setItems(listOfMark);
    }
    private void printTable(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            ResultSet rs = Connection.stmt.executeQuery(Request.markTable);
            while (rs.next()){
                listOfMark.add(new Mark(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
            rs.close();

//            tableView.setItems(listOfMark);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
