public class Snake extends Animal {
	public Snake(int posX, int posY) {
		super(posX, posY);
	}

	public void eat() {
		System.out.println("Snake: I will feast on your flesh! *Nom nom*");
	}

	public void speakPosition() {
		speakPosition("Snake");
	}
}