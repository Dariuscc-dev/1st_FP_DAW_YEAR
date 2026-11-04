package dataStructures;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers;
		numbers = new int[6];
		 //OR
		int [] second = new int [20];
		
		int [] numbers2 = {5,2,4,4,8,6};
		
		System.out.println("The first number of my array is = " + numbers2[0]);
		
		System.out.println("The lenghts of my second array is = " + numbers2.length);
		
		for (int i=0; i<5;i++) {
			System.out.println(numbers2[i]);
		}
		
		System.out.println("=================================================================================================");
		
		for (int i=0; i<numbers2.length;i++) {
			System.out.println(numbers2[i]);
		}
		
	}

}
