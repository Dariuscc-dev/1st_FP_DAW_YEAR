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
		
		System.out.println("=================================================================================================");
		
		int [] numberss = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(numberss[0]);
		
		System.out.println(numberss[2]);

		System.out.println(numberss[7]);

		System.out.println(numberss[3]);

		System.out.println(numberss[9]);

		numberss[0] = 1289;
		
		System.out.println(numberss[0]); //It has changed now
		
		int sum = 0;
		
		for (int i=0; i < numberss.length; i++) {
		sum = sum + numberss[i];
		}
		
		System.out.println("Sum is = " + sum);
		
		double average = (double) sum / numberss.length;
		
		System.out.println("Average is = " + average);
		
		int [] amountOfEggs = {5,2,4,4,8,6};
		int searching = 8;
		boolean found = false;
		
		for (int i=0; i < amountOfEggs.length; i++) {
			if (amountOfEggs[i] == searching); {
			found = true;
			}
			
		}
		
		System.out.println("The parsed number was found? = " + found);
		
		}

	}
