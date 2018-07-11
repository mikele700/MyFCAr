package server;

import java.io.IOException;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;
import service.IExampleService;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IExampleService service = new ExampleServiceImpl();
		
		CallHandler callHandler = new CallHandler();
		
		try {
			callHandler.registerGlobal(IExampleService.class,service);
		} catch (LipeRMIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Server server = new Server();
		try {
			server.bind(4455, callHandler);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
