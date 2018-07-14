package business.client.iclient;

import java.util.List;

import business.domain.*;
import business.server.iserver.IServerGestoreAccount;

public interface IGestoreAccount {
	
	public void login(String Email, String Password, IServerGestoreAccount iserver);
	public void logout(Account account);
	public void registra(String Email, String Password);
	public boolean verificaEmail(String Email);
	public Account getAccount();
	public List<Configurazione> getConfigurazioneAccount();
	public List<Auto> getAutoAccount();

}
