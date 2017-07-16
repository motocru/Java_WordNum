/*Author: Kevin Urban
  Date: 7/16/2017
*/

//Import statements
import java.util.Scanner;

public class NumeralWriter {

	//Final values
	/*Final values of numbers added to make code easier to read and avoid large numeral repetition in converter method*/
	private static final long THOU = 1000L;
	private static final long MIL = 1000000L;
	private static final long BIL = 1000000000L;
	private static final long TRIL = 1000000000000L;
	private static final long QUAD = 1000000000000000l;	

	public static void main(String[] args){
		System.out.println("Start of File");
		Long number = reInput();
		System.out.println("Your number is: " + number);
		System.out.println("Your Number converted to word format is: \n\t" + converter(number) +"\n");
		System.out.println("Program over");
	}
	
	/*Method reInput sets up try-catch block for user input. If String conversion to Long does not occur then the program will recurse back into itslef for another attempt at entering a correct number
	Mothod reInput returns a Long number*/
	private static Long reInput(){
		try {
			System.out.println("Please enter a number");
			Scanner scan = new Scanner(System.in);
			return Long.parseLong(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Error in Converting Number to Long");
			return reInput();
		}
	}

	/*Method converter takes in a long number and runs through different methods and recurses over itself to piece together the English word form of the number given. 
	The method provides a way to account for negative numbers by multiplying by -1, adding "minus" to the beginning of the string and then following the method routine as normal.
	The method uses division and modulus in order to divide up the much much larger numbers that get used near the end of the program. Currently the number range from a possible outcome of -999999999999999 to 999999999999999*/
	private static String converter(Long number){
		if (number < 0) 
			return "minus " + converter((number*-1));
		if (number > 0 && number < 20)
			return hard(number);
		else if (number >= 20 && number < 100)
			return tens(number);
		else if (number >= 100 && number < THOU){
			if ((number%100) == 0)
				return converter(number/100) + "hundred ";
			else
				return converter(number/100) + "hundred " + converter(number%100);
		} else if (number >= THOU && number < MIL) {
			if ((number%1000) == 0)
				return converter(number/THOU) + "thousand ";
			else 
				return converter(number/THOU) + "thousand " + converter(number%THOU);
		} else if (number >= MIL && number < BIL) {
			if ((number%MIL) == 0)
				return converter(number/MIL) + "million ";
			else
				return converter(number/MIL) + "million " + converter(number%MIL);
		} else if (number >= BIL && number < TRIL){
			if ((number%BIL) == 0)
				return converter(number/BIL) + "billion";
			else
				return converter(number/BIL) + "billion " + converter(number%BIL);
		} else if (number >= TRIL && number < QUAD){
			if ((number%TRIL) == 0)
				return converter(number/TRIL) + "trillion ";
			else 
				return converter(number/TRIL) + "trillion " + converter(number%TRIL);
		}
		return "zero";
	}

	/*Method hard takes a number in the range of 0 to 19 then uses a switch statement to determine the value of the number given and returns the appropriate english word version of the number.*/
	private static String hard(Long number){
		String wordString;
		int tempNum = number.intValue();
		switch(tempNum){
			case 1: wordString = "one ";
					break;
			case 2: wordString = "two ";
					break;
			case 3: wordString = "three ";
					break;
			case 4: wordString = "four ";
					break;
			case 5: wordString = "five ";
					break;
			case 6: wordString = "six ";
					break;
			case 7: wordString = "seven ";
					break;
			case 8: wordString = "eight ";
					break;
			case 9: wordString = "nine ";
					break;
			case 10: wordString = "ten ";
					break;
			case 11: wordString = "eleven ";
					break;
			case 12: wordString = "twelve ";
					break;
			case 13: wordString = "thirteen ";
					break;
			case 14: wordString = "fourteen ";
					break;
			case 15: wordString = "fifteen ";
					break;
			case 16: wordString = "sixteen ";
					break;
			case 17: wordString = "seventeen ";
					break;
			case 18: wordString = "eighteen ";
					break;
			case 19: wordString = "nineteen ";
					break;
			default: wordString = "Invalid Number";
					break;
		}
		return wordString;
	}

	/*Method tens insepcts numbers in the range of 20 to 99.
	This method will check first which tens range it is in then return the appropriate tens number by itself if it is something like twenty, thirty, etc. or it will return the tens number then move to the hard method to add the single digit number to the end of the string and return the fully built String.*/
	private static String tens(Long number){
		if (number >= 20 && number <= 29){
			if ((number-20) == 0)
				return "twenty ";
			else
				return "Twenty " + hard(number-20);
		} else if (number >= 30 && number <= 39){
			if ((number-30) == 0)
				return "thirty ";
			else
				return "thirty " + hard(number-30);
		} else if (number >= 40 && number <= 49){
			if ((number-40) == 0)
				return "fourty ";
			else
				return "fourty " +hard(number-40);
		} else if (number >= 50 && number <= 59){
			if ((number-50) == 0)
				return "fifty ";
			else
				return "fifty " +hard(number-50);
		} else if (number >= 60 && number <= 69){
			if ((number-60) == 0)
				return "sixty ";
			else
				return "sixty " +hard(number-60);
		} else if (number >= 70 && number <= 79){
			if ((number-70) == 0)
				return "seventy ";
			else
				return "seventy " +hard(number-70);
		} else if (number >= 80 && number <= 89){
			if ((number-80) == 0)
				return "eighty ";
			else
				return "eighty " +hard(number-80);
		} else if (number >= 90 && number <= 99){
			if ((number-90) == 0)
				return "ninety ";
			else
				return "ninety " +hard(number-90);
		} else
			return "Invalid Number";
	}
}
