package forms;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class MainForm{

  /*  private Statement stmt = null;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn discipline;
    @FXML
    private TableColumn group;
    @FXML
    private TableColumn teacher;
    @FXML
    private TableColumn vid;
    public MainForm(Statement stmt){
        this.stmt = stmt;
    }

    public void printTable(){
        try {
            ResultSet rs = stmt.executeQuery("SELECT DISCIPLINA.NAME, GROUPPA.NAME, VID.VID, PREPODAVATEL.FIO\n" +
                    "FROM PREPODAVATEL  JOIN PARA  on PARA.PREPODAVATEL_PK_PREPOD = PREPODAVATEL.PK_PREPOD\n" +
                    "  JOIN VID on PARA.VID_PK_VID = VID.PK_VID\n" +
                    "  JOIN GROUPPA  on PARA.GROUP_PK_GROUP = GROUPPA.PK_GROUP\n" +
                    "  JOIN DISCIPLINA  on PARA.DISCIPLINA_PK_DISC = DISCIPLINA.PK_DISC;");

            while (rs.next()){
                discipline.setText(rs.getString(1));
                group.setText(rs.getString(2));
                teacher.setText(rs.getString(3));
                vid.setText(rs.getString(4));
            }


        }catch (Exception e){

        }
    }
*/

}
