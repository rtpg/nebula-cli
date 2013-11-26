package nebula;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.opennebula.client.host.Host;
import org.opennebula.client.host.HostPool;

public class Nodes extends Nebula {

	private HostPool hostPool;
	
	public Nodes(){
		super();
		hostPool = new HostPool(client);
	}
	
	public void listNodes(){
		
		System.out.println("There are "+hostPool.getLength()+" hosts");
		Iterator<Host> hosts = hostPool.iterator();
		while(hosts.hasNext()){
			Host host = hosts.next();
			System.out.print("ID : "+host.getId()+"; ");
			System.out.print("NAME : "+host.getName()+"; ");
			String monitoring = host.monitoring().getMessage();
			try {
				Document document = DocumentHelper.parseText(monitoring);
				System.out.print("HYPERVISEUR: "+document.selectSingleNode("//VM_MAD").getText()+"; ");
				System.out.print("Proc Capacity: "+document.selectSingleNode("//MAX_CPU").getText()+"; ");
				System.out.print("Proc Used: "+document.selectSingleNode("//USED_CPU").getText()+"; ");
				System.out.print("Proc Free: "+document.selectSingleNode("//FREE_CPU").getText()+"; ");
				System.out.print("Memory Capacity: "+document.selectSingleNode("//MAX_MEM").getText()+"; ");
				System.out.print("Memory Used: "+document.selectSingleNode("//USED_MEM").getText()+"; ");
				System.out.println("Memory Free: "+document.selectSingleNode("//FREE_MEM").getText()+"; ");
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (Exception e){
				System.out.println("Error while getting nodes : "+e.toString());
			}
		}
		
	}
}
