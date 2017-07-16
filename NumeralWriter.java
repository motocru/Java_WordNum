/*Author: Kevin Urban
  Date: 7/16/2017
*/

//Import statements
import java.util.Scanner;

public class NumeralWriter {
	public static void main(String[] args){
		System.out.println("Start of File");
		System.out.println("Please enter a number");
		Scanner scan = new Scanner(System.in);
		String number = scan.nextLine();
		System.out.println("\nThe Number given is: " + number);
	}
}
