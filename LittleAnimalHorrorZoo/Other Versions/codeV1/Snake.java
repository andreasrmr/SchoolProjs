class Snake {
   int positionX = 10;
   int positionY = 10;
   void talk()  {
      System.out.println("Snake: Muhahaha");
   }
   void move(int newPosX, int newPosY) {
      positionX = positionX + newPosX;
      positionY = positionY + newPosY;
      System.out.println("Snake: my posisiton is: " + positionX + ", " + positionY);
   }  
   
}