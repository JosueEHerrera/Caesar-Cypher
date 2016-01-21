
/**
 * @author Josue Herrera
 *
 */

/**
 * The Class does the Caesar Cypher.
 *
 */

public class CypherEngine {
	
	
	/**
	 * This is the first part of the encryption process 
	 * @param message
	 * @param shift
	 * @return
	 */
	
	public String encryptMessage(String message, int shift){
		String encrypted; 
		char[] a = message.toCharArray();
		
		for(int i = 0; i < a.length; i++){
			if(a[i] != ' '){
				a[i] = encrypt(a[i],shift);
			}
		}
		encrypted = new String(a);
		return encrypted;
		
	}
	
	public String decryptMessage(String message, int shift){
		
		String decrypted; 
		char[] a = message.toCharArray();
		
		for(int i = 0; i < a.length; i++){
			if(a[i] != ' '){
				a[i] = decrypt(a[i],shift);
			}
		}
		decrypted = new String(a);
		
		return decrypted;
	}
	
	public static char decrypt(char init, int shift){
		int x=0;
		if(shift > 27){
			x = shift % 27;
			return normalDecrypt(init,x);
		} else if (shift < 0) {
			x = shift % (27 * -1);
			return normalDecrypt(init,x);
		} else if(shift <= 27 && shift >=0){
			return normalDecrypt(init, shift);
		}
		return 0;
	} 
	
	public static char normalDecrypt(char init, int shift){
		int x, y; x=0; y=0;
		
		x = (int)init - shift;

		if(x > 122){
			
			y = 123 - x;
			y = 97 - y;
			
			return (char)y;
		} else if (x<97){
			
			y = 97 - x;
			y = 123 - y;
			
			return (char)y;
		}
		return (char)x;	
	}


	
	public char encrypt(char init, int shift){
		int x=0;
		
		if(shift > 27){
			x = shift % 27;
			return normalShift(init,x);
		} else if (shift < 0) {
			x = shift % (27 * -1);
			return normalShift(init,x);
		}else if(shift <= 27 && shift >=0){
			return normalShift(init,shift);
		}
		return 0;
	}
	
	public char normalShift(char init, int shift){
		int x, y; x=0; y=0;
		
		x = (int)init + shift;
		
		if(x > 122)	{
			y = x - 123;
			y += 97;
			return (char)y;
		
		} else if (x < 97){
			y = x - 97;
			y += 123;
			return (char)y;
		}
		
		return (char)x;	
	}
	
	
}
