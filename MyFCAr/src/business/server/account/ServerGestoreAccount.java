package business.server.account;

import business.domain.Account;
import business.server.iserver.IServerGestoreAccount;
import data.AccountDAO;
import exception.AccountInesistente;

public class ServerGestoreAccount implements IServerGestoreAccount {

	@Override
	public Account login(String email, String password) throws AccountInesistente {
		// TODO Auto-generated method stub
		Account account = null;
		account = AccountDAO.read(email, password);
		return account;
	}

	@Override
	public void registra(String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verificaEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	/* TEST
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Account a = AccountDAO.read("mi.pommella@studenti.unina.it", "dmd");
			System.out.println("ID account "+a.getId()+" "+a.getEmail()+" "+a.getPassword());
			for (Iterator<Configurazione> iterator = a.getAllConfigurazione().iterator(); iterator.hasNext();) {
				Configurazione c = iterator.next();
				System.out.println("ID conf "+c.getId());
				c.stampaSetting();
			}
			for (Iterator<Auto> iterator = a.getAllAuto().iterator(); iterator.hasNext();) {
				Auto at = iterator.next();
				System.out.println("ID auto "+at.getId()+" "+at.getVIN()+" "+at.getTarga()+" "+at.getModello());
				at.stampaOptional();
				if(at.getConfigurazioneAuto()!=null)
					System.out.print("Conf Associata "+at.getConfigurazioneAuto().getConfigurazione().getId());
			}
			for (Iterator<ConfigurazioneAuto> iterator = a.getAllConfigurazioneAuto().iterator(); iterator.hasNext();) {
				ConfigurazioneAuto ca = iterator.next();
				System.out.println("ID conf associata auto "+ca.getId());
			}
		} catch (AccountInesistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
