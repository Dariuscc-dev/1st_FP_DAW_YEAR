package operations;

public class Examples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 5;
		int y = 23;
		
		System.out.println(x+y);
		
		System.out.println(x/y); // It returns zero, we should make the variables doubles, this way, we would get an exact result with decimals.
		
		System.out.println(y%x); // If we declare the variables as doubles, the result of this operation would be zero.
		
		int a = ++x; // X first goes up in 1, and then a takes x as its own value too (6).
		
		System.out.println("The value of a is " + a);
		
		int b = x++; // Here, b takes 6  as its value, and then X goes from 6 to  7, but that change is not visible and transferred to the variable b.
		
		System.out.println("The value of b is " + b + ", and below, we have the results of more operations.");
		
		int c = 11;
		
		boolean d = a == b;		
		
		boolean e = a != b;
		
		boolean f = a < c && b < c;
		
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		
		int mathRules = 5 + 2 * 3;
		System.out.println(mathRules);
		mathRules = (5+2) * 3;
		System.out.println(mathRules);
		
		// Casting is also an interesting thing about Java, where you can nest a number from a variable inside another variable when that other variable has the type of the first variable inside of her, like doubles with integers.
		// BUT, we can´t go from a double to an integer WITHOUR losing information.
		
		int number1 = 21;
		double number2 = number1; //there won´t be a problem here
		
		System.out.println(number2);
		
		double number3 = 21.1019;
		int number4 = (int) number3; // We have to first convert the number into an integer for the Java code not to crash.
		
		System.out.println (number4);
		
		Math.round(3.5);
		Math.ceil(3.5);
		Math.floor(3.8);
		
	}

}
