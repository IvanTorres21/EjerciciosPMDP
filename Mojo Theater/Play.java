
public class Play {

  private String title;
  private int duration;  //In minutes
  private String company; 
  private String producer;
  private float price;
  private int minAge; 
  
  public Play (String ti, int dur, String comp, String pro, float pri, int age) {
    
    this.title = ti;
    this.duration = dur;
    this.company = comp;
    this.producer = pro;
    this.price = pri;
    this.minAge = age;
  }
  public int getMinAge() {
    
    return this.minAge;
  }
  public float getPrice() {
    
    return this.price;
  }
  
  public String toString() {
    
    return "Title: " + title + "\nDuration: " + duration + "\nCompany: " + company + "\nProducer: " + 
            producer + "\nPrice: " + price + "\nMinimun age: " + minAge;
  }

}
