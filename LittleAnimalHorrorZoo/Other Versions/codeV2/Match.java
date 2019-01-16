class Match {
    
      Rabbit rabbit = new Rabbit(0,0);
      Snake snake = new Snake(10,10);
    
      int boardSizeX;
      int boardSizeY;
      
      int maxMoves = 10;
      
      public void startMatch() 
      {
         while (snake.getPosX() != rabbit.getPosX() && snake.getPosY() != rabbit.getPosY()) {
            rabbit.move("up");
            rabbit.move("right");
            rabbit.speakPosition();
            if (snake.getPosX() - rabbit.getPosX() == 1 && snake.getPosY() - rabbit.getPosY() == 1){
               rabbit.beg();            
            }
            snake.move("down");
            snake.move("left");
            snake.speakPosition();      
         }
         snake.eat();
      }
}