package exception;

public class ConfigurazioneAutoInesistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConfigurazioneAutoInesistente(){
		
	}
	public String getMessage(){
		return message;
	}
	private final String message = "ConfigurazioneAuto inesistente.";

}
