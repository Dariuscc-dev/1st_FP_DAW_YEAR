package conditionals;

public class chainOfConditionals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int time = 21;
		
		if (time <= 12) {
			System.out.println("Good morning");
		}
		
		else if (time > 12 && time < 20) {
			System.out.println("Good afternoon");
		}
		else {
			System.out.println("Good night");
		}
		
	}

}
