package forms;

import Service.Connection;
import Service.Request;
import Service.FunctionsForForms;
import forms.handbooks.Both;
import forms.handbooks.Student;
import forms.handbooks.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Locale;

public class TeacherForm {
    private ObservableList<Teacher> listOfTeacher = FXCollections.observableArrayList();
    private ObservableList<Teacher> listOfTeacherDiscipline = FXCollections.observableArrayList();
    private ObservableList<Teacher> listFound = FXCollections.observableArrayList();
    private ObservableList<Both> listOfDisc = FXCollections.observableArrayList();


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
    private TableView found;
    @FXML
    private TableColumn<Teacher, String> foundFio;
    @FXML
    private TableColumn<Teacher, String> foundDiscipline;
    @FXML
    private TextField find;
    @FXML
    private TextField add;
    @FXML
    private Button editingButton;
    @FXML
    private Pane editingPane;
    @FXML
    private Pane pane;
    @FXML
    private TextField addDisc;
    @FXML
    private TableView tableViewDiscipline;
    @FXML
    private TableColumn<Both, String> disc;


    @FXML
    private void initialize(){
     /*   tableViewTeacher.setVisible(true);
        tableViewTeacherDiscipline.setVisible(false);
        found.setVisible(false);*/

        initList();
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        tableViewTeacher.setItems(listOfTeacher);

     /*   tableViewTeacher.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Node node = ((Node) event.getTarget()).getParent();
                    TableRow row;
                    if (node instanceof TableRow) {
                        row = (TableRow) node;
                    } else {
                        // clicking on text part
                        row = (TableRow) node.getParent();
                    }
                    System.out.println(row.getItem().toString());
                }
            }
        });*/

        fio.setCellFactory(TextFieldTableCell.forTableColumn());
        fio.setOnEditCommit(t -> {
            (t.getTableView().getItems().get(t.getTablePosition().getRow())).setFio(t.getNewValue());
        //      changeValue("update PREPODAVATEL set fio = \'" + t.getNewValue() + "\' where fio = \'" + t.getOldValue() + "\'" );

        }
        );




        initDisc();
        disc.setCellValueFactory(new PropertyValueFactory<>("field"));
        tableViewDiscipline.setItems(listOfDisc);

        disc.setCellFactory(TextFieldTableCell.forTableColumn());
        disc.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Both, String>>() {
                                @Override
                                public void handle(TableColumn.CellEditEvent<Both, String> t) {
                                    ((Both) t.getTableView().getItems().get(t.getTablePosition().getRow())).setField(t.getNewValue());
                                //    changeValue("update PREPODAVATEL set fio = \'" + t.getNewValue() + "\' where fio = \'" + t.getOldValue() + "\'" );

                                }
                            }
        );


        initListTD();
        fioTeacher.setCellValueFactory(new PropertyValueFactory<>("fio"));
        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
        tableViewTeacherDiscipline.setItems(listOfTeacherDiscipline);




     /*   foundFio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        foundDiscipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
        found.setItems(listFound);*/

    }


    private void initDisc(){
        try {
            ResultSet rs = Connection.stmt.executeQuery(Request.disciplineTable);
            while (rs.next()){
                listOfDisc.add(new Both(rs.getString(1)));
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void changeValue(String request){
        try {
            ResultSet rs = Connection.stmt.executeQuery(request);
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public void openStage(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void editing() throws IOException {
      editingPane.setFocusTraversable(true);
      editingPane.setVisible(true);
      pane.setFocusTraversable(false);
      pane.setVisible(false);

    }

    @FXML
    private void close(){
        editingPane.setFocusTraversable(false);
        editingPane.setVisible(false);
        pane.setFocusTraversable(true);
        pane.setVisible(true);
    }

    @FXML
    private void showDiscipline(){

        tableViewTeacher.setVisible(false);
        found.setVisible(false);
        listFound = FXCollections.observableArrayList();
        tableViewTeacherDiscipline.setVisible(true);

    }
    @FXML
    private void addDiscipline(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            String name = "(\'" + addDisc.getText() + "\')";
            ResultSet rs = Connection.stmt.executeQuery("insert into DISCIPLINA (name) values " + name);
            listOfDisc.add(new Both(addDisc .getText()));
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void showTeacher(){
        tableViewTeacherDiscipline.setVisible(false);
        tableViewTeacher.setVisible(true);
        found.setVisible(false);
        listFound = FXCollections.observableArrayList();
    }

    @FXML
    private void addTeacher(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            String name = "(\'" + add.getText() + "\')";

            ResultSet rs = Connection.stmt.executeQuery("insert into prepodavatel (FIO) values " + name);
                listOfTeacher.add(new Teacher(add.getText()));

            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void findTeacher(){
        Locale.setDefault(Locale.ENGLISH);
        try{
            String name = "";
            String s[] = find.getText().split(" |  |   |    |\t|     ");
            for(String item : s)
                if(item.compareTo("") != 0)
                    name += " " + item;
            name = name.trim();
            ResultSet rs = Connection.stmt.executeQuery(Request.findTeacher +  "\'" + name + "\'");
            while(rs.next()) {
                listFound.add(new Teacher(rs.getString(1), rs.getString(2)));
            }
           // foundDiscipline.setVisible(true);
            if(listFound.size() == 0){
                 rs = Connection.stmt.executeQuery(Request.findTeacherWithoutDiscipline +  "\'" + name + "\'");
                while(rs.next()) {
                    listFound.add(new Teacher(rs.getString(1)));
                }
            /*    if(listFound.size() != 0)
                    foundDiscipline.setVisible(false);*/
            }
            found.setItems(listFound);
            found.setVisible(true);
            tableViewTeacherDiscipline.setVisible(false);
            tableViewTeacher.setVisible(false);

            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
