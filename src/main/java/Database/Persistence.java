package Database;

import Model.Animal;
import jakarta.persistence.PersistenceException;

import java.util.Collection;

public interface Persistence {
  Animal create(String animalId, String weight, String arrivalDate, String status) throws
      PersistenceException;
  Collection<Animal> readAll() throws PersistenceException;
  void update(Animal animal) throws PersistenceException;
  void delete(String animalId) throws PersistenceException;
  Animal read(String animalId) throws PersistenceException;
}
