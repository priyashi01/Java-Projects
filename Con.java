package EMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {

    Connection connection;
    Statement statement;

    public Con(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","Priyashi@021");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
