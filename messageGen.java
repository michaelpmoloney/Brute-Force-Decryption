/*Message Generator class:
 * Description: Creates a string of random upper and lower-case
 * characters between the size of 1 and 50.
 * Input: None
 * Output: String*/
package symCrypt;
//Java random library imported
import java.util.*;

public class messageGen {
//character array created. Random instance created.
	private char[] message;
	Random random = new Random();

	public String getMessage() {
/*random integer between 1 and 50 is created to dictate
 * string length. Then the message character array is
 * resized to that length*/
		int stringLength = (random.nextInt(25) + 1) * 2;
		message = new char[stringLength];
/*A for loop is used to fill the character array. A random boolean is used
 * to determine if each character will be upper or lower-case. A random
 * ASCII int in the range of either upper or lower case letters is then used
 * and cast to a char before being put into the array.*/
		for (int i = 0; i < message.length; i++) {
			boolean capOrNot = random.nextBoolean();
			if (capOrNot)
				message[i] = (char) (random.nextInt((90 - 65) + 1) + 65);
			else
				message[i] = (char) (random.nextInt((122 - 97) + 1) + 97);
		}
//char array is put into a string before being returned.
		String stringMessage = new String(message);
		System.out.println("Randomly generated message is: " + stringMessage);
		return stringMessage;
	}

}
