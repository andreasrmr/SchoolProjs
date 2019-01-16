class Program {
   public static void main(String[] args){
      Rabbit rabbit1 = new Rabbit();
      Snake snake1 = new Snake();
      while (snake1.positionX != rabbit1.positionX && snake1.positionY != rabbit1.positionY) {
      
         rabbit1.move(1, 1);
         if (snake1.positionX - rabbit1.positionX == 1 && snake1.positionY - rabbit1.positionY == 1) {
            rabbit1.talkSnakeIsClose();
         }    
         snake1.move(-1,-1);       
      }
      snake1.eat();
      System.out.println("Game over - Rabbit is dead");
   }
}