/*Author: Michael Moloney
 * Student ID: 900-85-1985
 * Class: CSC 4222
 * Description: The program randomly generates a 16-bit key
 * and a random string message. The message is XOR encrypted.
 * The program then discovers the original key through brute
 * force and decrypts the message.
 * Input: None
 * Output: 16-bit key, message, encrypted message, # of attempts
 * to find the key, brute force discovered key, decrypted message.
 * Usage: Just run the program. No other user input is required.*/
package symCrypt;
//main class
public class mainClass {

	public static void main(String[] args) {
//Creates instance of keyGen class, then runs its getKey method.
		keyGen kg = new keyGen();
		byte[] key = kg.getKey();
//Creates instance of messageGen class, then runs its getMessage method.	
		messageGen mg = new messageGen();
		String message = mg.getMessage();
//Creates instance of xorEncrypt class, then runs its encrypt message method.	
		xorEncrypt xe = new xorEncrypt(key,message);
		String encryptedMessage = xe.encryptMessage();
//Creates instance o bruteDecrypt class, then runs its decryptMessage
//and toString methods.
		bruteDecrypt bd = new bruteDecrypt(message,encryptedMessage);
		bd.decryptMessage();
		System.out.println(bd.toString());

	}

}