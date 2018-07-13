package exception;

public class DatoInputErrato extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DatoInputErrato() {
	}
	public DatoInputErrato(String specifica){
		this.message=this.message+": "+specifica;
	}
	public String getMessage(){
		return message;
	}
	private String message="Dato errato";
}
