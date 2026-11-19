package Strings;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String one = "Hello how are you";
		
		String two = "How are you";
		
		System.out.println(one.equals(two));
		
		int position = one.indexOf("you");
		
		System.out.println(position);
		
		int position2 = one.indexOf("You"); //says -1 if it is not found
		
		System.out.println(position2);
		
		String date = "12/02/2001";
		
		String[] parts = date.split("/");
		
		System.out.print("Date is " + parts[0] + "-" + parts[1] + "-" + parts[2]);
		
		String[] names = {"Ana", "Annabell", "Joseph"};
		String searching = "Joseph";
		boolean found = false;
		for (int i = 0; i < names.length; i++) {
			if (searching == names[2]) {
				found = true;
			}
		}
		
		System.out.println();
		
		System.out.println(found);

}
}