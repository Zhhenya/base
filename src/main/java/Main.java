import forms.MainForm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("forms/main.fxml"));
        primaryStage.setTitle("...");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static Statement stmt = null;
    public static Connection con = null;
    public static void main(String[] args) {
            Locale.setDefault(Locale.ENGLISH);
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Ze", "z");
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT student.fio FROM student ");
                while(rs.next()){
                    System.out.println(rs.getString("fio"));
                }

            /*    MainForm mainForm = new MainForm(stmt);
                mainForm.printTable();
*/

                rs.close();
                stmt.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        launch(args);
    }
}