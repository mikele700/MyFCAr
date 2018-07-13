package business.server.iserver;

public interface IServerGestoreAccount {

	public void login(String email, String password);
	public void registra(String email, String password);
	public boolean verificaEmail(String email);
}
