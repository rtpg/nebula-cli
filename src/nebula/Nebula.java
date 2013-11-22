package nebula;

import org.opennebula.client.Client;
import org.opennebula.client.ClientConfigurationException;

public class Nebula {
	
	public Client client;
	
	public Nebula(){
		
		try {
			client = new Client("oneadmin:5bd7fcf39891cdff5896e10a79b7cd9e", "http://192.168.56.101:2633/RPC2");
		} catch (ClientConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
