/*Key Generator Class:
 * Description: generates a random 16-bit length key.
 * Input: none.
 * Output: byte array containing key*/
package symCrypt;
//Java random library imported
import java.util.concurrent.ThreadLocalRandom;

public class keyGen {

	private byte[] key = new byte[2];
	/*Random 16-bit key generation. Key is an array of bytes.
	 * ThreadLocalRandom fills the array with random bits.
	 * The bit string is then printed to console and key 
	 * returned from class*/		
	public byte[] getKey() {
		ThreadLocalRandom.current().nextBytes(key);
		System.out.print("The randomly generated 16-bit key is: ");
		for (byte b : key) {
			System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1));
		}
		System.out.println();
		return key;
	}
}