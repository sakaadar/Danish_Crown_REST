import Database.Databasehelper;

import java.sql.Connection;

public class Main
{
  public static void main(String[] args)
  {
    Databasehelper dbHelper = new Databasehelper();
    Connection connection = dbHelper.getConnection();
    if (connection != null) {
      System.out.println("Connection successful!");
    } else {
      System.out.println("Failed to connect.");
    }
  }
}
