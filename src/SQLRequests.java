public class SQLRequests {
    public static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS Users (\n" +
            "id int NOT NULL  AUTO_INCREMENT,\n" +
            "name varchar(255),\n" +
            "surname varchar(255),\n" +
            "birthdate date,\n" +
            "PRIMARY KEY (id));";

    public static final String CREATE_FRIENDSHIPS_TABLE = "CREATE TABLE IF NOT EXISTS Friendships (\n" +
            "userid1 int,\n" +
            "userid2 int,\n" +
            "timestamp datetime,\n" +
            "FOREIGN KEY(userid1) REFERENCES Users(id), \n" +
            "FOREIGN KEY(userid2) REFERENCES Users(id));";

    public static final String CREATE_POSTS_TABLE = "CREATE TABLE IF NOT EXISTS posts (\n" +
            "id int  AUTO_INCREMENT,\n" +
            "userid int,\n" +
            "text VARCHAR(255),\n" +
            "timestamp DATETIME,\n" +
            "PRIMARY KEY (id),\n" +
            "FOREIGN KEY (userid) REFERENCES users(id));";

    public static final String CREATE_LIKES_TABLE = "CREATE TABLE likes (\n" +
            "postid INT,\n" +
            "userid INT,\n" +
            "timestamp DATETIME,\n" +
            "FOREIGN KEY(postid) REFERENCES posts(id), \n" +
            "FOREIGN KEY(userid) REFERENCES users(id));";

    public static String getInsertIntoUsersTable(String name, String surname, String date) {
        return "INSERT INTO users\n" +
                "(name,\n" +
                "surname,\n" +
                "birthdate)\n" +
                "VALUES\n" +
                "('"+ name +"','"+ surname +"', '"+date+"');";
    }

    public static String getInsertIntoFriendshipsTable(int id1, int id2, String timestamp) {
        return "INSERT INTO friendships\n" +
                "(userid1,\n" +
                "userid2,\n" +
                "timestamp\n" +
                ")\n" +
                "VALUES\n" +
                "("+id1+", "+id2+", '"+timestamp+"');";
    }

    public static String getInsertIntoPostsTable(int userId, String timestamp) {
        return "INSERT INTO posts\n" +
                "(userid,\n" +
                "timestamp\n" +
                ")\n" +
                "VALUES\n" +
                "("+userId+", '"+timestamp+"');";
    }

    public static String getInsertIntoLikesTable(int postId, int userId, String timestamp) {
        return "INSERT INTO likes\n" +
                "(postid,\n" +
                "userid,\n" +
                "timestamp\n" +
                ")\n" +
                "VALUES\n" +
                "("+postId+","+userId+",'"+timestamp+"');";
    }
    public static String getCreateLikesTable() {
        return CREATE_LIKES_TABLE;
    }

    public static String getCreateUsersTable() {
        return CREATE_USERS_TABLE;
    }

    public static String getCreateFriendshipsTable() {
        return CREATE_FRIENDSHIPS_TABLE;
    }

    public static String getCreatePostsTable() {
        return CREATE_POSTS_TABLE;
    }
}
