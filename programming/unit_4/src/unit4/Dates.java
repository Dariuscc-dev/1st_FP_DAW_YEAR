package unit4;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Dates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date today = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Today is " + today);
		System.out.println("Today is " + f.format(today));
		
		Date todayy = new Date();
		SimpleDateFormat ff = new SimpleDateFormat(
		"dd 'de' MMMM 'de' yyyy",
		new Locale("es", "ES"));
		System.out.println(ff.format(todayy));
		
	}

}
