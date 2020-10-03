import java.util.ArrayList;
import java.util.Scanner;
/**
 * Application that manages the seats in a 
 * theatre, assigning them and making sure that
 * each person meets the requirements to watch the play
 * @author Iván Torres de Oses
 *
 */
public class MojoTheater {
  
  
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    ArrayList<Spectator> clientList = new ArrayList<Spectator>();
    Spectator[][] seats = new Spectator[10][9]; //If the seat is null it's not used.
    System.out.println("Please fill in the information about the play.");
    Play play = playData();
    System.out.println("Please input the amount of spectators to create: ");
    int numSpec = Integer.parseInt(s.nextLine());
    //Adding random spectators to the list
    for(int i = 0; i < numSpec; i++) {
      
      System.out.println("Generating spectator number: " + i);
      clientList.add(Spectator.randSpectator(i));
    }
    assignSeats(seats, clientList, play); //Randomly assign the spectators
    showSeats(seats);
    // Seeing information about those who are seated
    String opt = "";
    do {
      System.out.println("Type the seat code to see who is seated in it.");
      System.out.println("Type show to show the table again, type play to see the play information, type exit to exit.");
      opt = s.nextLine();
      if (opt.equalsIgnoreCase("show")) showSeats(seats);
      else if (opt.equalsIgnoreCase("exit")) System.out.println("Goodbye");
      else if (opt.equalsIgnoreCase("play")) System.out.println(play);
      else {
        
        opt = opt.toUpperCase();
        // Convert the letters into positions in the array
        int i = opt.charAt(0) - 65;
        int j = Character.getNumericValue(opt.charAt(1));
        System.out.println("\n" + seats[j][i]);
      }
    } while (!opt.equalsIgnoreCase("exit"));
    s.close();
    
  }
  
  /**
   * Assigns random seats to spectators;
   * @param seats An array of Spectators
   * @param clientList A list of Spectators to be seated
   * @param play The parameters of the play, with age requirements and money
   */
  public static void assignSeats(Spectator[][] seats, ArrayList<Spectator> clientList, Play play) {
    
    int numAssigned = 0; //To make sure that if no more seats are left we stop trying to assing.
    for(int s = 0; s < clientList.size() && numAssigned < 90;) {
      
      //Randomize position
      int i = (int) (Math.random()*10);
      int j = (int) (Math.random()*9);
      if(seats[i][j] == null) {
        
        if(clientList.get(s).seatEspectator(i, j, play)) {
          
          seats[i][j] = clientList.get(s);
          numAssigned++;
        }
        s++;
      }
    }
  }
  
  /**
  * Function that gets all the data needed to 
  * make a Play Object. 
  */
 public static Play playData() {
 
   Scanner s = new Scanner(System.in);
   System.out.print("Title: ");
   String title = s.nextLine();
   System.out.print("Duration: ");
   int duration = Integer.parseInt(s.nextLine());
   System.out.print("Company: ");
   String company = s.nextLine();
   System.out.print("Producer: ");
   String producer = s.nextLine();
   System.out.print("Ticket price: ");
   float price = Float.parseFloat(s.nextLine());
   System.out.print("Minimun Age: ");
   int age = Integer.parseInt(s.nextLine());
   System.out.println();
   return new Play(title, duration, company, producer, price, age);
 }
 /**
  * Function that show how people are seated
  * @param seats An array of spectators 
  */
  public static void showSeats(Spectator[][] seats) {
    
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 10; j++) {
        if (seats[j][i] != null) System.out.print("   " + seats[j][i].getSeat()); // If there is someone seated
        else System.out.print("   XX"); //If there isn't
      }
      System.out.println();
    }
  }
}
