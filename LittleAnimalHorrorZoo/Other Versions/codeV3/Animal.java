public class Animal {
	public int getPosX() { return this.posX; }
	public void setPosX(int posX) { this.posX = posX; }
	public int getPosY() { return this.posY; }
	public void setPosY(int posY) { this.posY = posY; }

	int posX;
	int posY;

	public Animal(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void move(String direction) {
		switch(direction) {
			case "up":
				posY += 1;
				break;
			case "down":
				posY -= 1;
				break;
			case "left":
				posX -= 1;
				break;
			case "right":
				posX += 1;
				break;
			default:
				System.out.println("Animal::move(String direction) - parameter doesn't match a case");
			return;
		}
	}

	protected void speakPosition(String who) {
		System.out.println(who + ": I'm currently at " + this.posX + ", " + this.posY);
	}
}