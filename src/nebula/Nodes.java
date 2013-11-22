package nebula;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.opennebula.client.host.HostPool;

public class Nodes extends Nebula {

	private HostPool hostPool;
	private String response; 
	
	public Nodes(){
		super();
		hostPool = new HostPool(client);
		response = hostPool.info().getMessage();
	}
	
	public void getNodes(){
		
		
		try {
			Document document = DocumentHelper.parseText(response);
			@SuppressWarnings("unchecked")
			List<Node> nodes = document.selectNodes("//NAME");
			for (org.dom4j.Node node : nodes){
				System.out.println(node.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
}
