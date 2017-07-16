/*Author: Kevin Urban
  Date: 7/16/2017
*/

//Import statements
import java.util.Scanner;

public class NumeralWriter {
	public static void main(String[] args){
		System.out.println("Start of File");
		System.out.println("Please enter a number");
		Long number = 0L;
		try {
			Scanner scan = new Scanner(System.in);
			number = Long.parseLong(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Conversion from String to Long failed");
			number = reInput();
		}
		System.out.println("The Number in long format is: " + number);
		System.out.println("Program over");
	}

	private static Long reInput(){
		try {
			System.out.println("Please enter a number");
			Scanner scan = new Scanner(System.in);
			return Long.parseLong(scan.nextLine());
		} catch (NumberFormatException e) {
			return reInput();
		}
	}
}
