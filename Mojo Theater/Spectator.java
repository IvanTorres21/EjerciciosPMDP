
public class Spectator {

  private String name;
  private String dni;
  private int age;
  private float money;
  private String seat = "None"; //Will be in the format of A1, B4, ... but the data will be recieved as two ints; we need to convert it
  
  public String getSeat() {
    
    return seat;
  }
  
  public Spectator(String name, String dni, int age, float money) {
    
    this.name = name;
    this.dni = dni;
    this.age = age;
    this.money = money;
  }
  
  public String toString() {
    
    return "Name: " + this.name + "\nDNI: " + this.dni + "\nAge: " + this.age + "\nMoney: " + this.money + "\nSeat: " + this.seat;
  }
  /**
   * Function that assigns a seat to the spectator, but only if
   * it has enough money and is old enough.
   * @param i letter of the seat as an integer
   * @param j number of the seat
   * @param play an object with all the data of the play
   * @return False if it couldn't be seated
   */
  public boolean seatEspectator(int i, int j, Play play) {
    
    String seatNumber = "";
    
    if (this.age >= play.getMinAge() && this.money >= play.getPrice()) {
      
      //this.money = this.money - play.getPrice();
      seatNumber += ((char) (65+j));
      seatNumber += "" + i;
      this.seat = seatNumber;
      return true;
    } else return false;
  }
  
  /**
   * Function that randomizes and initializes a spectator
   * @param i which spectator we are randomizing
   * @return Spectator object
   */
  public static Spectator randSpectator(int i) {
    
    String name = "Spectator" + i;
    String dni = "" + i + ((char) (65+(i/10000000)));
    int dniSize = dni.length();
    for(int j = 0; j < (9-dniSize);j++) { //To fill the rest of the DNI
      dni = "0" + dni;
    }
    int age = (int) (Math.random()*80);
    float money = (float) (Math.random()*300);
    return new Spectator(name, dni, age, money);
  }
  
}
