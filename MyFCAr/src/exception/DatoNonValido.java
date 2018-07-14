package exception;

public class DatoNonValido extends Exception {
	
	private static final long serialVersionUID = 1L;
	public DatoNonValido() {
	}
	public DatoNonValido(String specifica){
		this.message=this.message+": "+specifica;
	}
	public String getMessage(){
		return message;
	}
	private String message="Dato errato";

}
