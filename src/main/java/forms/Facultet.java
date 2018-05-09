package forms;

import Service.Connection;
import Service.Request;
import forms.handbooks.Both;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.util.Locale;

public class Facultet {

    private ObservableList<Both> listBoth = FXCollections.observableArrayList();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Both, String> name;
    @FXML
    private TextField addFacultet;
    @FXML
    private  void initialize(){
        init();
        name.setCellValueFactory(new PropertyValueFactory<>("field"));
        tableView.setItems(listBoth);
    }

    private void init(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            ResultSet rs = Connection.stmt.executeQuery(Request.facultetTable);
            while (rs.next()){
                listBoth.add(new Both(rs.getString(1)));
            }
            rs.close();

            tableView.setItems(listBoth);


        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void addFacultet(ActionEvent actionEvent) {
        Locale.setDefault(Locale.ENGLISH);
        try{
            String name = "(\'" + addFacultet.getText() + "\')";
            ResultSet rs = Connection.stmt.executeQuery("insert into FACULTET (name) values " + name);
            listBoth.add(new Both(addFacultet .getText()));
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
