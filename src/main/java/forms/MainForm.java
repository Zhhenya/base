package forms;


import Service.*;
import forms.handbooks.Class;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
                listOfClass.add(new Class(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            Connection.closeConnection();


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
