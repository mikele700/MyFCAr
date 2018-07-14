package business.client.account;

import java.io.IOException;

import business.client.iclient.IGestoreAccount;
import business.server.iserver.IServerGestoreAccount;
import lipermi.handler.CallHandler;
import lipermi.net.Client;

public class ClientAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallHandler ch = new CallHandler();
		try {
			Client client = new Client("localhost",4456, ch);
			IServerGestoreAccount iserver;
			iserver = (IServerGestoreAccount) client.getGlobal(IServerGestoreAccount.class);
			IGestoreAccount gestore = new GestoreAccount();
			gestore.login("mi.pommella@studenti.unina.it", "dmd", iserver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}