package exception;

public class ServerError extends Exception {
	private static final long serialVersionUID = 1L;
	public ServerError() {
	}
	public ServerError(String specifica){
		this.message=this.message+specifica;
	}
	public String getMessage(){
		return message;
	}
	private String message="Server Error\n";

}
