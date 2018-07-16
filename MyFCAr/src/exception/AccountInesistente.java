package exception;

public class AccountInesistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccountInesistente(){
		
	}
	
	public String getMessage(){
		return message;
	}
	private final String message = "Email e/o password errati!";

}
