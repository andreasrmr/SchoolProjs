class Animal {
   public int getPosX() { return this.posX; }
   public void setPosX(int posX){ this.posX = posX; }
   public int getPosY() { return this.posY; }
   public void setPosY(int posY) { this.posY = posY; }

   private int posX;
   private int posY;

   
   public Animal(int posX, int posY)
   {
      this.posX = posX;
      this.posY = posY;
   }

   public void speakPosition()
   {
      System.out.println(": My position is: " + this.getPosX() + ", " + this.getPosY());
   }
   public void move(String direction)
   {
      int x = getPosX();
      int y = getPosY();
       
      if (direction == "left")
      {
         setPosX(x -= 1);
      }
      else if (direction == "right") 
      {
         setPosX(x += 1);
      }
      else if (direction == "up") {
         setPosY(y += 1);
      }
      else if (direction == "down") {
         setPosY(y -= 1);
      }
   }
}