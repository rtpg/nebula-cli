package nebula;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.opennebula.client.host.HostPool;

public class Node extends Nebula {

	public Node(){
		super();
	}
	
	public void getNodes(){
		HostPool hostPool = new HostPool(client);
		String response = hostPool.info().getMessage();
		
		try {
			Document document = DocumentHelper.parseText(response);
			@SuppressWarnings("unchecked")
			List<org.dom4j.Node> nodes = document.selectNodes("//NAME");
			for (org.dom4j.Node node : nodes){
				System.out.println(node.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
}
