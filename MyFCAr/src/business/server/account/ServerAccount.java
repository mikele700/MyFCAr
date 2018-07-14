package business.server.account;

import java.io.IOException;
import business.server.iserver.IServerGestoreAccount;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;

public class ServerAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IServerGestoreAccount servitore = new ServerGestoreAccount();
		CallHandler ch = new CallHandler();
		try {
			ch.registerGlobal(IServerGestoreAccount.class, servitore);
			Server server = new Server();
			server.bind(4456, ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LipeRMIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
