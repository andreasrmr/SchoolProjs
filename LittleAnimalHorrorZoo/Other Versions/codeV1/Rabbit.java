class Rabbit {
   int positionX = 0;
   int positionY = 0;
   
   void killed() {
      System.out.println("Rabbit is dead");
   }
   void snakeIsClose()  {
      System.out.println("Rabbit: Ohh no dont kill me");
   }
   void move(int newPosX, int newPosY) {
      positionX = positionX + newPosX;
      positionY = positionY + newPosY;
      System.out.println("Rabbit: My position is: " + positionX + ", " + positionY);
   }
}