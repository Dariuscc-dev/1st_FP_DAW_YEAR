package dataStructures;
import java.util.Scanner;

public class MoreArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers;
		
		numbers = new int [6]; // All variables inside this array will be 0
		
		int [] numbers1 = {1, 2, 3, 4, 5, 6}; // We initialize and define the array
		
		System.out.println(numbers[1]);

		System.out.println(numbers1[1]);
		
		System.out.println(numbers1.length); // Length is 6, although index will end at 5, as it starts at 0
		
		for (int i=0; i < numbers1.length; i++) {
			System.out.println(numbers[i]);
		}
		
		Scanner keyboard = new Scanner(System.in);
		int[] numbers2 = new int[6];
		for (int i=0; i < numbers2.length; i++) {
			System.out.println("Insert the value that you want to be stored in the " + i +" index position of the array =");
			numbers2[i] = keyboard.nextInt();
		}
		
	}

}
