package business.client.account;

import java.util.List;

import business.client.iclient.IGestoreAccount;
import business.domain.Account;
import business.domain.Auto;
import business.domain.Configurazione;
import business.domain.ConfigurazioneAuto;
import business.server.iserver.IServerGestoreAccount;
import exception.AccountInesistente;
import exception.ServerError;

public class GestoreAccount implements IGestoreAccount {
	
	private Account logged;
	private static GestoreAccount instance = null;
	
	private GestoreAccount(){}
	
	public static GestoreAccount getInstance(){
		if(instance == null)
			instance = new GestoreAccount();
		return instance;
	}

	@Override
	public void login(String Email, String Password, IServerGestoreAccount iserver) {
		// TODO Auto-generated method stub
		try {
			logged = iserver.login(Email, Password);
			if(logged != null)
				logged.stampaAccount();
		} catch (AccountInesistente | ServerError e) {
			// TODO Auto-generated catch block
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
		return logged;
	}

	@Override
	public List<Configurazione> getConfigurazioneAccount() {
		// TODO Auto-generated method stub
		return logged.getAllConfigurazione();
	}

	@Override
	public List<Auto> getAutoAccount() {
		// TODO Auto-generated method stub
		return logged.getAllAuto();
	}
	
	public List<ConfigurazioneAuto> getConfigurazioneAutoAccount(){
		return logged.getAllConfigurazioneAuto();
	}
	
	public Auto cercaAutoAccount(Integer idAuto){
		return logged.getAuto(idAuto);
	}

}
