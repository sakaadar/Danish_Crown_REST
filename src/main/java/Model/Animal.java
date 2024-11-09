package Model;

public class Animal
{
  private String animalId;
  private String weight;
  private String arrivalDate;
  private String status;
  private String origin;
  // Constructor
  public Animal(String animalId, String weight, String arrivalDate, String status,String origin) {
    this.animalId = animalId;
    this.weight = weight;
    this.arrivalDate = arrivalDate;
    this.status = status;
    this.origin = origin;
  }

  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }

  public String getAnimalId()
  {
    return animalId;
  }

  public void setAnimalId(String animalId)
  {
    this.animalId = animalId;
  }

  public String getWeight()
  {
    return weight;
  }

  public void setWeight(String weight)
  {
    this.weight = weight;
  }

  public String getArrivalDate()
  {
    return arrivalDate;
  }

  public void setArrivalDate(String arrivalDate)
  {
    this.arrivalDate = arrivalDate;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Animal{" +
        "animalId='" + animalId + '\'' +
        ", weight='" + weight + '\'' +
        ", arrivalDate='" + arrivalDate + '\'' +
        ", status='" + status + '\'' +
        ", origin='" + origin + '\'' +
        '}';
  }

}
