package business.server.iserver;

import business.domain.Account;
import exception.AccountInesistente;

public interface IServerGestoreAccount {

	public Account login(String email, String password) throws AccountInesistente;
	public void registra(String email, String password);
	public boolean verificaEmail(String email);
}
