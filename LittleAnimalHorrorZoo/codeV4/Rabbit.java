class Rabbit {
   int positionX = 0;
   int positionY = 0;
   
   void talkSnakeIsClose() {
      System.out.println("Rabbit:\t Ohh no dont kill me");
   }
   
   void move(int newPosX, int newPosY) {
      positionX = positionX + newPosX;
      positionY = positionY + newPosY;
      System.out.println("Rabbit:\t My position is: " + positionX + ", " + positionY);
   }
}
   