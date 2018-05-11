package forms;

import Service.Connection;
import Service.FunctionsForForms;
import Service.Request;
import forms.handbooks.Both;
import forms.handbooks.Class;
import forms.handbooks.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;


public class Specialnost {
    private ObservableList<Both> listBoth = FXCollections.observableArrayList();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Both, String> name;
    @FXML
    private TextField addSpecialnost;
    @FXML
    private TableColumn<Both, String> index;

    @FXML
    private  void initialize(){
        init();

        name.setCellValueFactory(new PropertyValueFactory<>("field"));
        tableView.setItems(listBoth);
    }

    private void init(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            ResultSet rs = Connection.stmt.executeQuery(Request.specTable);
            while (rs.next()){
                listBoth.add(new Both(rs.getString(1)));
            }
            rs.close();
            tableView.setItems(listBoth);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addSpecialnost(ActionEvent actionEvent) {
        Locale.setDefault(Locale.ENGLISH);
        try{
            String name = "(\'" + addSpecialnost.getText() + "\')";
            ResultSet rs = Connection.stmt.executeQuery("insert into SPECIALNOST (name) values " + name);
            listBoth.add(new Both(addSpecialnost .getText()));
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void delete(){
        int row = tableView.getSelectionModel().getSelectedIndex();
        Both b = (Both) tableView.getSelectionModel().getSelectedItem();
        ResultSet rs = null;
        try {
            rs = Connection.stmt.executeQuery("delete from SPECIALNOST where SPECIALNOST.PK_CPEC = " + b.getIndex() );
            rs.next();
            rs.close();
            tableView.getItems().remove(row);
        } catch (SQLException e) {
            FunctionsForForms.errorWindow("Эта запись используется");
            e.printStackTrace();
        }

    }
}
