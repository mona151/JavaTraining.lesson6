import java.sql.*;
import java.util.ArrayList;

public class Main {

    //private static final java.sql.DriverManager DriverManager = ;

    public static void main(String[] args) {
        ArrayList<Integer> usersIDList = new ArrayList<>();
        ArrayList<Integer> postIDList = new ArrayList<>();
        try(Connection conn = MySQLJDBCConnector.getConnection()) {
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
            Statement stmt = conn.createStatement();

            //Creating 4 tables:
            stmt.executeUpdate(SQLRequests.getCreateUsersTable());
            stmt.executeUpdate(SQLRequests.getCreateFriendshipsTable());
            stmt.executeUpdate(SQLRequests.getCreatePostsTable());
            stmt.executeUpdate(SQLRequests.getCreateLikesTable());

            //Filling up users table:
            for (int i = 0; i < 1500 ; i++) { stmt.executeUpdate(SQLRequests.getInsertIntoUsersTable(RandomNameGenerator.getRandomName(), RandomNameGenerator.getRandomName(), RandomDateGenerator.getSimpleRandomDate()));}

            //Getting set of user IDs
            ResultSet userIDs = stmt.executeQuery("select id from USERS;");
            while(userIDs.next()){
                usersIDList.add(userIDs.getInt("id")) ;
            }

            //Filling up friendship table with pairs userid1 -> userid2
            for (int i = 0; i < usersIDList.size()-1; i++) {
                for (int j = 0; j < 50; j++) {
                    int id2=usersIDList.get((int)(Math.random() * usersIDList.size()));
                    if (id2 != usersIDList.get(j)){
                        stmt.executeUpdate(SQLRequests.getInsertIntoFriendshipsTable(usersIDList.get(i), id2, RandomDateGenerator.getRandomTimestamp()));
                        System.out.println(usersIDList.get(i)+"->"+ id2);
                    }
                }
            }

            //Filling up posts table
            for (int i = 0; i < usersIDList.size(); i++) {
                stmt.executeUpdate(SQLRequests.getInsertIntoPostsTable(usersIDList.get(i), RandomDateGenerator.getRandomTimestamp()));
            }

            //Getting set of posts IDs
            ResultSet postIDs = stmt.executeQuery("SELECT id FROM posts;");
            while(postIDs.next()){
                postIDList.add(postIDs.getInt("id")) ;
            }

            //Filling up likes tables (random amount of likes from 1 to 50 for each post)
            for (int i = 0; i < postIDList.size(); i++) {
                for (int j = 0; j < (int)(Math.random() * 50); j++) {
                    stmt.executeUpdate(SQLRequests.getInsertIntoLikesTable(postIDList.get(i), usersIDList.get((int)(Math.random() * usersIDList.size())), RandomDateGenerator.getRandomTimestamp()));
                    System.out.println(postIDList.get(i)+"-> some user");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

