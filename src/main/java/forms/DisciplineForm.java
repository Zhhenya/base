package forms;

import Service.Connection;
import Service.Request;
import forms.handbooks.Both;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.util.Locale;

public class DisciplineForm {
    private ObservableList<Both> listDisc = FXCollections.observableArrayList();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Both, String> name;
    @FXML
    private  void initialize(){
        init();
        name.setCellValueFactory(new PropertyValueFactory<>("field"));
        tableView.setItems(listDisc);
    }

    private void init(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            ResultSet rs = Connection.stmt.executeQuery(Request.disciplineTable);
            while (rs.next()){
                listDisc.add(new Both(rs.getString(1)));
            }
            rs.close();

            tableView.setItems(listDisc);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
