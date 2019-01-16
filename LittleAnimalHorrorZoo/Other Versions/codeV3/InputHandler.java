import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHandler {
	BufferedReader reader;
	InputStreamReader stream;

	public InputHandler(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in));
	}

	public int readInt() {
		try {
			return Integer.parseInt(reader.readLine());
		} catch(Exception e) {
			System.out.println("Input must be an integer, try again.");
			return readInt();
		}
	}

	public String readString() {
		String input;

		try {
			input = reader.readLine();
		} catch(Exception e) {
			input = "ERROR";
		}

		return input;
	}
}