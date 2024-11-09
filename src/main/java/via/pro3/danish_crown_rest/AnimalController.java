package via.pro3.danish_crown_rest;

import Database.Databasehelper;
import Model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController
{


  private Databasehelper databasehelper = new Databasehelper();

  @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
      return databasehelper.addAnimal(animal.getAnimalId(), animal.getWeight(), animal.getArrivalDate(), animal.getStatus(), animal.getOrigin());
    }

  // Endpoint to get animals by origin
  @GetMapping("/origin/{origin}")
  public List<Animal> getAnimalsByOrigin(@PathVariable("origin") String origin) {
    return databasehelper.getAllAnimals(origin);
  }

  // Endpoint to get animal by id
  @GetMapping("/id/{id}")
  public Animal getAnimalById(@PathVariable("id") String id) {
    return databasehelper.getAnimalById(id);
  }

  // Endpoint to get animals by arrival date
  @GetMapping("/arrivalDate/{arrivalDate}")
  public List<Animal> getAnimalsByArrivalDate(@PathVariable("arrivalDate") String arrivalDate) {
    return databasehelper.getAllAnimalsbyArrivaldate(arrivalDate);
  }


}
