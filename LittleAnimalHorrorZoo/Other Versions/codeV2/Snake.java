public class Snake extends Animal
{
//dette er vores metode
   public void eat() {
      System.out.println("Snake: Muhahah im gonna eat you now");
   }
//dette er vores constructor
   public Snake (int posX, int posY)
   {
      super(posX, posY);
   }
   
     public void speakPosition()
   {
      System.out.println("Snake: My position is: " + this.getPosX() + ", " + this.getPosY());
   }
}
