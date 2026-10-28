package exam;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Insert the score of your exam (1-10): ");
		int score = keyboard.nextInt();
		
		if (score < 5) {
			System.out.println("Not enough, next try will be better, keep on studying :)");
		}

		else if (score >= 5 && score < 6) {
			System.out.println("Phheww, almost didn´t make it, but you did!");
		}
		
		else if (score >= 6 && score < 7) {
			System.out.println("Good job, you still have room to grow");
		}
		
		else if (score >= 7 && score < 9) {
			System.out.println("Very good job, I´ve always believed in you!");
		}
		
		else if (score >= 9) {
			System.out.println("You´re a beast!)");
		}
		
	}

}
