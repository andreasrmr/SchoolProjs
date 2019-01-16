public class Match {
	Rabbit rabbit;
	Snake snake;
	int boardSizeX;
	int boardSizeY;
	int maxMoves = 50;

	public Match() {
		snake = new Snake(0,0);
		rabbit = new Rabbit(10,10);
	}

	public void startMatch() {
		snake.speakPosition();
		rabbit.speakPosition();
		for(int i = 0; i < maxMoves; i++) {
			if(i % 2 == 0) {
				rabbit.move("down");
				rabbit.speakPosition(); 
				neighboursCheck();
				if(collisionCheck()) { return; }

				snake.move("up");
				snake.speakPosition();
				neighboursCheck();
				if(collisionCheck()) { return; }
			} else {
				rabbit.move("left");
				rabbit.speakPosition();
				neighboursCheck();
				if(collisionCheck()) { return; }
				
				snake.move("right");
				snake.speakPosition();
				neighboursCheck();
				if(collisionCheck()) { return; }
			}
		}
	}

	public void neighboursCheck() {
		if(isNeighbours()) {
			rabbit.beg();
		}
	}

	public boolean collisionCheck() {
		if(!isColliding()) {
			return false;
		}
		snake.eat();
		return true;
	}

	public boolean isNeighbours() {
		boolean borders = false;

		// rabbit above/below snake
		if(rabbit.getPosX() == snake.getPosX()) {
			if(rabbit.getPosY() + 1 == snake.getPosY() || rabbit.getPosY() -1 == snake.getPosY()) {
				borders = true;
			}
		}

		// rabbit besides snake
		if(rabbit.getPosY() == snake.getPosY()) {
			if(rabbit.getPosX() + 1 == snake.getPosX() || rabbit.getPosX() -1 == snake.getPosX()) {
				borders = true;
			}
		}

		return borders;
	}

	public boolean isColliding() {
		return (snake.getPosX() == rabbit.getPosX() &&
				rabbit.getPosY() == rabbit.getPosY());
	}
}