/**
 * 
 */

/**
 * @author Home
 *
 */


import java.util.InputMismatchException;
import java.util.Scanner;
public class UI {
	
	private Scanner kb = new Scanner(System.in);
	private CypherEngine cypher = null;
	public UI(CypherEngine cypher){
		this.cypher = cypher;
		greeting();
	}
	
	public void greeting(){
		System.out.println("\n\tCeaser Cypher\n");
	}
	
	public void startCypher(){
			menu();
		
	}
	
	public void menu(){
		int decision = 0;
		try {
			System.out.print("\n     MENU: \n\t(1) Start Cypher\n\t(2) "
					+ "Quit\n\n> ");
			decision = kb.nextInt();
			kb.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input. Must type a number.\n");
			kb.nextLine();
			menu();
		}
		switch(decision) {
			case 1:
				System.out.println();
				cypherLoop();
				break;
			case (2):
				System.out.println("\tGoodbye Friend.");
				System.exit(0);
				
		}
	}
	
	public void cypherLoop(){
		do{
		stringPrompt();
		} while (true);
	}
	
	public void stringPrompt(){
		String message, encrypted ,decrypted;
		int shift = 0;
		
		try {
			System.out.print("Encrypt a Message (press ENTER to go to menu): ");
			message = kb.nextLine();
			if (message.equals("")){
				menu();
			}	
			System.out.print("Give an Shift Value: ");
			shift = kb.nextInt();
			kb.nextLine();
			System.out.println();
			encrypted =  cypher.encryptMessage(message, shift);
			decrypted = cypher.decryptMessage(encrypted, shift);
			System.out.println("Encrypted Message: " + encrypted);
			System.out.println("Decrypted Message: " + decrypted + "\n");
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input. Please Try Again.\n");
			kb.nextLine();
			stringPrompt();
		}
		
	
	}

}
