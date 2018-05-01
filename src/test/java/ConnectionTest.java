
import org.junit.jupiter.api.Test;


import java.sql.*;
import java.util.Locale;


public class ConnectionTest {

    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "Ze";
    private final String PASSWORD = "z";

    @Test
   void ConnectionTest() {

        Locale.setDefault(Locale.ENGLISH);

        Connection connection;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

        //    DriverManager.registerDriver(new oracle.driver.OracleDriver());
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("You are win!!!");
            }



        /*
            Connection con = DriverManager.getConnection("", "Ze", "z");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT student.fio FROM student");
            while (rs.next()) {
              //  String s = getString();
                System.out.println(rs.getString(1));
            }

            con.close();*/
        }
        catch(ClassNotFoundException c){
            System.out.println("Are you loser?");
        }
        catch (SQLException s){
            s.printStackTrace();
          //  System.out.println("Just do that!!!");
        }
    }
}
