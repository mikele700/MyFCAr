package business.client.iclient;

import business.domain.Account;
import business.server.iserver.IServerGestoreAccount;

public interface IGestoreAccount {
	
	public void login(String Email, String Password, IServerGestoreAccount iserver);
	public void logout(Account account);
	public void registra(String Email, String Password);
	public boolean verificaEmail(String Email);
	public Account getAccount();

}
