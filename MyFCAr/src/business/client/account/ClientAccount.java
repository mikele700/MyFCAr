package business.client.account;

import java.io.IOException;

import business.client.configurazioneauto.GestoreConfigurazioneAuto;
import business.client.iclient.IGestoreAccount;
import business.client.iclient.IGestoreConfigurazioneAuto;
import business.server.iserver.IServerGestoreAccount;
import business.server.iserver.IServerGestoreConfigurazioneAuto;
import lipermi.handler.CallHandler;
import lipermi.net.Client;

public class ClientAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallHandler ch = new CallHandler();
		try {
			Client clienta = new Client("localhost",4456, ch);
			IServerGestoreAccount iservera;
			iservera = (IServerGestoreAccount) clienta.getGlobal(IServerGestoreAccount.class);
			IGestoreAccount gestorea = GestoreAccount.getInstance();
			System.out.println("-----------LOGIN----------------\n");
			gestorea.login("mi.pommella@studenti.unina.i", "dmd", iservera);
			System.out.println("\n---------------------------------");
			System.out.println("-----------ASSOCIA AUTO-----------\n");
			
			
			Client clientca = new Client("localhost",4455, ch);
			IServerGestoreConfigurazioneAuto iserverca;
			iserverca = (IServerGestoreConfigurazioneAuto) clientca.getGlobal(IServerGestoreConfigurazioneAuto.class);
			IGestoreConfigurazioneAuto gestoreca = GestoreConfigurazioneAuto.getInstance();
			gestoreca.associaAuto(gestorea.getAccount(), gestorea.getAutoAccount().get(1), gestorea.getConfigurazioneAccount().get(0),iserverca);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}