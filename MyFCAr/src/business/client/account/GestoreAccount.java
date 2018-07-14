package business.client.account;

import business.client.iclient.IGestoreAccount;
import business.domain.Account;
import business.server.iserver.IServerGestoreAccount;
import exception.AccountInesistente;

public class GestoreAccount implements IGestoreAccount {
	
	private Account logged;

	@Override
	public void login(String Email, String Password, IServerGestoreAccount iserver) {
		// TODO Auto-generated method stub
		try {
			logged = iserver.login(Email, Password);
			logged.stampaAccount();
		} catch (AccountInesistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}

	@Override
	public void logout(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registra(String Email, String Password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verificaEmail(String Email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

}
