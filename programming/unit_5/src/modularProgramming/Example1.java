package modularProgramming;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int comparisonResult = bigger(300 , 200);
		
		System.out.println("The biggest number in the made comparison is " + comparisonResult);
		
		hello();
		hello();
		hello();
		hello();
		hello();
		hello();
		hello();
		hello();
		
		int sum = mathSum(11 , 67);
		
		System.out.println(sum);
		
		String salutation = sayHello("Darius");
		
		System.out.println(salutation);
		
		sayHello2("Godofredo");
		
		double average = average (100, 387.122);
		
		System.out.println(average);
		
		double average2 = average2 (1378138, 387.122);
		
		System.out.println(average2);
		
	}
	

	public static int bigger(int a, int b) {
		if (a>b) {
			return a;
		}
			return b;
		}
	
	public static void hello() {
		System.out.println("Hello, I guess.");
	}
	
	public static int mathSum(int c, int d) {
		return c + d;
	}
	
	public static String sayHello(String name) {
		return ("Hello " + name + ", how are you?");
	}
	
	public static void sayHello2(String name) {
		System.out.println("Hello " + name + ", how are you?");
	}
	
	public static double average(double a, double b) {
		return ((a + b) / 2);
	}
	
	public static double average2(double a, double b) {
		
		double average = ((a + b) / 2);
		return average;
	}
	
	
}