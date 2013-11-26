package nebula;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.opennebula.client.Client;
import org.opennebula.client.ClientConfigurationException;
import org.opennebula.client.OneResponse;

public class Nebula {
	
	protected Client client;
	
	
	
	public Nebula(){	
		String login = null,address = null;
		try {
			try {
				BufferedReader br = new BufferedReader(new FileReader("login.config"));
				login=br.readLine();
				address=br.readLine();
			}catch (IOException fnfe){
				login="oneadmin:5bd7fcf39891cdff5896e10a79b7cd9e";
				address="http://192.168.56.101:2633/RPC2";
			}finally{
				client= new Client(login, address);
			}
		}catch (ClientConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getVersion(){
		
		OneResponse resp = client.get_version();
		System.out.println(resp.getMessage());
		
	}
	
}
