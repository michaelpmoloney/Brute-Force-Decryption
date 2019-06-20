/*Brute Force Decryption Class:
 * Description: Discovers the original 16-bit key used to
 * encrypt a message through the brute force method. The
 * Found key and number of times it took to find it are then
 * displayed.
 * Input: The original string message and the encrypted string
 * message.
 * Output: Discovered 16-bit key as a byte array, and the
 * decrypted message.*/
package symCrypt;

public class bruteDecrypt {
/*instance variables:
 * Byte array to hold discovered key. Strings to hold input
 * strings and decrypted XORed result.*/
	private byte[] key = new byte[2];
	private String message;
	private String encryptedMessage;
	private String xoredMessage = "";
//Constructor declaration. Assigns input strings.
	public bruteDecrypt(String message, String encryptedMessage) {
		this.message = message;
		this.encryptedMessage = encryptedMessage;
	}
/*decryptMessage method:
 * Description: Iterates through all 16-bit values. XORs each possible
 * 16-bit value with the encrypted message. If the result matches the
 * original message then the key is found. When the key is found, the
 * number of tries is outputted and found key and decrypted message
 * are returned.
 * Input: Original message string and encrypted message string.
 * Output: found 16-bit key as a byte array and decrypted message
 * as a string.*/
	public void decryptMessage() {
//for loop to cycle through all 16-bit values
		for (int i = 0; i < 256; i++) {
			key[0] = (byte) i;
			for (int j = 0; j < 256; j++) {
				key[1] = (byte) j;
				String temp = "";
/*Nested for loop to XOR encrypted message with each key.*/
				for (int k = 0; k < encryptedMessage.length();) {
					for (int l = 0; l < 2; l++) {
						char encryptChar = (char) (encryptedMessage.charAt(k) ^ key[l]);
						temp += encryptChar;
						k++;
					}
				}
//XORed message is compared to original message. if match then temp is stored
// as xoredMessage
				if (temp.equals(message)) {
					xoredMessage = temp;
				}
//if match is found, number of tries to find key is displayed
				if (xoredMessage.equals(message)) {
					System.out.println("Key discovered on attempt: " + (i * j));
					break;
				}
			}
//If match is found then for loop is broken
			if (xoredMessage.equals(message))
				break;
		}
	}
//toString Method:
//key and decrypted message are displayed if key is found. Otherwise
// 'could not discover key.' is returned as a string
	public String toString() {
		if (xoredMessage.equals(message)) {
			System.out.print("Brute force discoverd key is: ");
			for (byte b : key) {
				System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1));
			}
			return "\nDecrypted message is: " + xoredMessage;
		} else
			return "could not discover key.";
	}
}
