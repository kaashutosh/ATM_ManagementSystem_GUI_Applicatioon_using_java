package bank.management.system;

import java.sql.*;


public class ConnectDataBase {
    //Class.forName("oracle.jdbc.driver.OracleDriver");
    //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
    //java.sql.Statement smt=con.createStatement();
    // sql_query = "select * from t2";
    //ResultSet rs = smt.executeQuery(sql_query);
    Connection con;
    Statement statement;
    public ConnectDataBase(){
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","bankSystem","bankSystem");
            statement = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
