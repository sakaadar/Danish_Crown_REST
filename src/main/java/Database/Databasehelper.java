package Database;
import Model.Animal;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Databasehelper {
  String url = "jdbc:sqlite:C:/Users/adres/IdeaProjects/Danish_Crown_REST/src/main/java/Database/Animal.db";



  public Connection getConnection() {
    try {
      return DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.err.println("Failed to connect to SQLite database.");
      e.printStackTrace();
      return null;
    }
  }


  public Animal addAnimal(String animalId, String weight, String arrivalDate, String status, String origin)
  {
    Animal animal = new Animal(animalId, weight, arrivalDate, status, origin);
    String Querysql = "INSERT INTO Animal (animalId, weight, arrivalDate, status, origin) VALUES (?, ?, ?, ?,?)";

    try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(Querysql)) {

      pstmt.setString(1, animalId);
      pstmt.setString(2, weight);
      pstmt.setString(3, arrivalDate);
      pstmt.setString(4, status);
      pstmt.setString(5, origin);
      pstmt.executeUpdate();

    return animal;
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }

  }

  public Animal getAnimalById(String id) {
    Animal animal = null;

    String QuerySql= "SELECT * FROM Animal WHERE animalId = ?";
    // 1. Establish a connection
    try (Connection connection =getConnection()) {

      // 2. Create a prepared statement to avoid SQL injection
      PreparedStatement preparedStatement = connection.prepareStatement(QuerySql);
      preparedStatement.setString(1, id); // Set the ID parameter in the query

      // 3. Execute the query
      ResultSet rs = preparedStatement.executeQuery();

      // 4. Process the result set
      if (rs.next()) {
        String animalId = rs.getString("animalId");
        String weight = rs.getString("weight");
        String arrivalDate = rs.getString("arrivalDate");
        String status = rs.getString("status");
        String origin = rs.getString("origin");
        animal = new Animal(animalId, weight, arrivalDate, status, origin);
      }


    }

    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }

    return animal;
  }

  public List<Animal> getAllAnimals(String origin)
  {
    ArrayList<Animal> animals = new ArrayList<>();
    String QuerySql= "SELECT * FROM Animal WHERE origin = ?";

    try(Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement(QuerySql);
      preparedStatement.setString(1, origin);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String animalId = rs.getString("animalId");
        String weight = rs.getString("weight");
        String arrivalDate = rs.getString("arrivalDate");
        String status = rs.getString("status");
        animals.add(new Animal(animalId, weight, arrivalDate, status, origin));
      }
      return animals;
    }

    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }



  }
  public List<Animal> getAllAnimalsbyArrivaldate(String arrivaldate)
  {
    ArrayList<Animal> animals = new ArrayList<>();
    String QuerySql= "SELECT * FROM Animal WHERE arrivaldate = ?";

    try(Connection connection = getConnection())
    {
      PreparedStatement preparedStatement = connection.prepareStatement(QuerySql);
      preparedStatement.setString(1, arrivaldate);

      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String animalId = rs.getString("animalId");
        String weight = rs.getString("weight");
        String arrivalDate = rs.getString("arrivalDate");
        String status = rs.getString("status");
        String origin = rs.getString("origin");
        animals.add(new Animal(animalId, weight, arrivalDate, status, origin));
      }
      return animals;
    }

    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
    }

  }



