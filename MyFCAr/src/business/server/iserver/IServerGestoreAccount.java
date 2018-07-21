package business.server.iserver;

import domain.Account;
import exception.*;

public interface IServerGestoreAccount {

	public Account login(String email, String password) throws AccountInesistente, ServerError;
	public void registra(String email, String password);
	public boolean verificaEmail(String email);
}
