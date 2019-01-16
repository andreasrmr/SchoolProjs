class Program{
      public static void main(String[] args) {
      Snake snake1 = new Snake();  
      Rabbit rabbit1 = new Rabbit();
      
      do { 
            snake1.move(-1,-1);
            rabbit1.move(1, 1);
            rabbit1.talkPosition();
            snake1.talkPosition();
         System.out.println(snake1.positionX - rabbit1.positionX + " - " + snake1.positionY - rabbit1.positionY);
            if (snake1.positionX - rabbit1.positionX == -1 && snake1.positionY - rabbit1.positionY == -1){
               rabbit1.talkAlmostDead();
            }
            else if(snake1.positionX == rabbit1.positionX && snake1.positionY == rabbit1.positionY) {
            rabbit1.talkDead();
            } 
      }while (snake1.positionX != rabbit1.positionX && snake1.positionY != rabbit1.positionY);          
   }
}


class Rabbit {
   int positionX = 1;
   int positionY = 1;
   void talkPosition() {
      System.out.println("I am the Rabbit my position is; " + positionX + ", " + positionY);
   }
   void talkAlmostDead() {
      System.out.println("I am the Rabbit; Noo dont kill me, mercy");
   }
   void talkDead(){
      System.out.println("I am Rabbit, I am dead");
   }
   void move(int newPosX, int newPosY) {
      positionX = positionX + newPosX;
      positionY = positionY + newPosY;
   }
}

class Snake {
   int positionX = 10;
   int positionY = 10;
   
   void talkPosition() {
      System.out.println("I am the Snake my position is; " + positionX + ", " + positionY);
   }
   void move(int newPosX, int newPosY) {
      positionX = positionX + newPosX;
      positionY = positionY + newPosY;
   }
}