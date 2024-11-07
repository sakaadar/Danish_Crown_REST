package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasehelper {
  String url = "jdbc:sqlite:C:/Users/sakaa/IdeaProjects/Danish_Crown_REST/src/main/java/Database/Animal.db";


  public Connection getConnection() {
    try {
      return DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.err.println("Failed to connect to SQLite database.");
      e.printStackTrace();
      return null;
    }
  }
}