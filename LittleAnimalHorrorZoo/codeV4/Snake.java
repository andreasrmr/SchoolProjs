class Snake {
   int positionX = 10;
   int positionY = 10;
   void eat()  {
      System.out.println("Snake :\t Now i will eat you, Muhahaha");
   }
   void move(int newPosX, int newPosY) {
      positionX = positionX + newPosX;
      positionY = positionY + newPosY;
      System.out.println("Snake :\t My position is: " + positionX + ", " + positionY);
   }  
}