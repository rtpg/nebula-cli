package nebula;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.opennebula.client.vm.VirtualMachine;
import org.opennebula.client.vm.VirtualMachinePool;

public class VirtualMachines extends Nebula {

	private VirtualMachinePool vmPool;
	
	public VirtualMachines(){
		super();
		vmPool = new VirtualMachinePool(client);
	}
	
	public void displayVM(){
		
		Iterator<VirtualMachine> vms = vmPool.iterator();
		while(vms.hasNext()){
			
			try {
				
				VirtualMachine vm = vms.next();
				System.out.print("ID : "+vm.getId()+"; ");
				System.out.print("NAME : "+vm.getName()+"; ");
				System.out.print("STATUS : "+vm.lcmStateStr()+"; ");
				String monitoring = vm.monitoring().getMessage();
				Document document = DocumentHelper.parseText(monitoring);
				System.out.print("HOST : "+document.selectSingleNode("//HOSTNAME").getText()+"; ");
				System.out.print("HYPERVISEUR : "+document.selectSingleNode("//VMMMAD").getText()+"; ");
				System.out.println("CPU : "+document.selectSingleNode("//CPU").getText()+"; ");
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
