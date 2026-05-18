package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Todo {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public Todo() {
        initSchema();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS todo (" + "id INTEGER PRIMARY KEY," 
        + "task TEXT NOT NULL) STRICT";
        try(
            Connection connection = DriverManager.getConnection("jdbc:sqlite:todo.db");
            Statement stmt = connection.createStatement();
            )
            {
            stmt.executeUpdate(sql);
            }
        catch (SQLException e) {
            System.out.println(e.getMessage());
}
}
}