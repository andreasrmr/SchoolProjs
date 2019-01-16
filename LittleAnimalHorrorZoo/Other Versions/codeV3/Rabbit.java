public class Rabbit extends Animal {
	public Rabbit(int posX, int posY) {
		super(posX, posY);
	}

	public void beg() {
		System.out.println("Rabbit: Oh nooes, plOx don't killz meh! Q_Q");
	}

	public void speakPosition() {
		speakPosition("Rabbit");
	}
}