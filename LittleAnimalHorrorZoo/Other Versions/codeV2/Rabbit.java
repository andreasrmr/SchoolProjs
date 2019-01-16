 public class Rabbit extends Animal
{
//dette er vores metode
   public void beg() {
      System.out.println("Rabbit: Please dont eat me");
   }
//dette er vores constructor
   public Rabbit (int posX, int posY)
   {
      super(posX, posY);
   }
   
   public void speakPosition()
   {
      System.out.println("Rabbit: My position is: " + this.getPosX() + ", " + this.getPosY());
   }
}
