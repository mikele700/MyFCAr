package client;

import java.io.IOException;

import lipermi.handler.CallHandler;
import lipermi.net.Client;
import service.IExampleService;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallHandler callHandler = new CallHandler();
		try {
			Client client = new Client("localhost", 4455, callHandler);
			IExampleService service;
			service = (IExampleService) client.getGlobal(IExampleService.class);
			service.saluto();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
