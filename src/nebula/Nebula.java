package nebula;

import org.opennebula.client.Client;
import org.opennebula.client.ClientConfigurationException;
import org.opennebula.client.OneResponse;

public class Nebula {
	
	protected Client client;
	
	public Nebula(){
		
		try {
			client = new Client("oneadmin:5bd7fcf39891cdff5896e10a79b7cd9e", "http://192.168.56.101:2633/RPC2");
		} catch (ClientConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getVersion(){
		
		OneResponse resp = client.get_version();
		System.out.println(resp.getMessage());
		
	}
	
}
