import java.util.Scanner;
import java.math.BigInteger;  

public class RSAMain {
	
public static void main(String[] args) {
	Scanner myMessage = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter Encryption Message : ");
    BigInteger m = myMessage.nextBigInteger(); 
    System.out.println("Enter Decryption Message : ");
    BigInteger c = myMessage.nextBigInteger(); 
		RSA rsa = new RSA(m,c);
		rsa.DoRSA();
		
	}

}
