import java.sql.*;
import java.util.Locale;
import java.util.TimeZone;

public class Main {

    //private static final java.sql.DriverManager DriverManager = ;

    public static void main(String[] args) {
        try(Connection conn = MySQLJDBCConnector.getConnection()) {
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQLRequests.getCreateUsersTable());
            stmt.executeUpdate(SQLRequests.getCreateFriendshipsTable());
            stmt.executeUpdate(SQLRequests.getCreatePostsTable());
            stmt.executeUpdate(SQLRequests.getCreateLikesTable());

            //ResultSet rs = stmt.executeQuery(sql);

           /* while (rs.next()){
                System.out.println(rs.getString("Name")+
                        rs.getString("Continent")+
                        rs.getString("Region"));
            }*/
            //System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

