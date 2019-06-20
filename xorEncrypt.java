/*Encryption Class:
 * Description: A 16bit key is used to XOR encrypt a string.
 * Input: 16-bit byte array(key) and a string(message).
 * Output: String of encrypted message.*/
package symCrypt;

public class xorEncrypt {
//Byte array and string instance variables.
	private byte[] key;
	private String message;
//Constructor declaration.
	public xorEncrypt(byte[] key, String message) {
		this.key = key;
		this.message = message;
	}
/*encryptMessage method:
 * Description: A nested for loop is used to cycle between the two
 * bytes in the byte array and these are XORed with the ASCII chars
 * in the message string to create the encrypted characters. The
 * encrypted chars are stored in encrytChar then added to the encryptedMessage
 * string.
 * Input: message, key
 * Output: encryptedMessage string.*/
	public String encryptMessage() {

		String encryptedMessage = "";

		for (int i = 0; i < message.length();) {
			for (int j = 0; j < 2; j++) {
				char encryptChar = (char) (message.charAt(i) ^ key[j]);
				encryptedMessage = encryptedMessage + encryptChar;
				i++;
			}
		}
		System.out.println("Encrypted message is: " + encryptedMessage);
		return encryptedMessage;
	}

}
