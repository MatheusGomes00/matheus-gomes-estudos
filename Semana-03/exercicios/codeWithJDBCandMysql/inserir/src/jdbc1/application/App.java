package jdbc1.application;

import jdbc1.db.DB;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) {

        SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();

            /*
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);


            st.setString(1, "Mario Green");
            st.setString(2, "marin@gmail.com");
            st.setDate(3, new java.sql.Date(stf.parse("25/09/2085").getTime()));
            st.setDouble(4, 4500.0);
            st.setInt(5, 3);
             */

            st = conn.prepareStatement(
                    "insert into department (Name) values ('Food'),('Sports')",
                    Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! ID = " + id);
                }
            }else{
                System.out.println("No rown affected!");
            }

        } catch(SQLException e){
            e.getMessage();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
        //catch(ParseException e){
          //  e.printStackTrace(); }



    }
}
