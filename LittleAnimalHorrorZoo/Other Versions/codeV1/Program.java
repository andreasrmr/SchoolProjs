class Program {
   public static void main(String[] args){
   Rabbit rabbit1 = new Rabbit();
   Snake snake1 = new Snake();
   
   
   do {
   snake1.move(-1,-1);
   rabbit1.move(1, 1);
   
   if (snake1.positionX  == rabbit1.positionX && snake1.positionY == rabbit1.positionY) {
      rabbit1.killed();
      snake1.talk();
   }
   else if (snake1.positionX - rabbit1.positionX == 2 && snake1.positionY - rabbit1.positionY == 2) {
      rabbit1.snakeIsClose();
   }
   }while (snake1.positionX != rabbit1.positionX && snake1.positionY != rabbit1.positionY);
   
   
   
   
   
   }

}