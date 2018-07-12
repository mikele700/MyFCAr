package business.server.configurazioneauto;

import java.io.IOException;

import business.server.iserver.IServerGestoreConfigurazioneAuto;
import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;

public class ServerConfigurazioneAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IServerGestoreConfigurazioneAuto servitore = new ServerGestoreConfigurazioneAuto();
		CallHandler ch = new CallHandler();
		try {
			ch.registerGlobal(IServerGestoreConfigurazioneAuto.class, servitore);
		} catch (LipeRMIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Server server = new Server();
		try {
			server.bind(4455, ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
