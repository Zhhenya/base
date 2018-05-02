package Service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Connection {

    public static Statement stmt = null;
    public static java.sql.Connection con = null;

    public  static void getConnection(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Ze", "z");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /* public static void getParaTable(){

        try{
            ResultSet rs = stmt.executeQuery("SELECT student.fio FROM student ");
          *//*  while(rs.next()){
                System.out.println(rs.getString("fio"));
            }*//*

                MainForm mainForm = new MainForm();
                mainForm.printTable();
            rs.close();
            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
