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
				if (vm.state() == 3){ // ie VM running
					System.out.print("HOST : "+document.selectSingleNode("//HOSTNAME").getText()+"; ");
					System.out.print("HYPERVISEUR : "+document.selectSingleNode("//VMMMAD").getText()+"; ");
					System.out.print("CPU used in %: "+document.selectSingleNode("//CPU").getText()+"; ");
					System.out.println("Memory used in kB: "+document.selectSingleNode("//MEMORY").getText()+"; ");
				}
				
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void suspendVM(Integer id){
		try{
			VirtualMachine vm = new VirtualMachine(id, client);
			vm.suspend();
			System.out.println("Virtual Machine suspended");
		} catch (Exception e){
			System.out.println("Error while suspending Virtual Machine");
		}
		
	}
	
	public void restartVM(Integer id){
		try{
			VirtualMachine vm = new VirtualMachine(id, client);
			vm.resume();
			System.out.println("Virtual Machine restarted");
		} catch (Exception e){
			System.out.println("Error while restarting Virtual Machine");
		}
		
	}
	
	public void deleteVM(Integer id){
		try{
			VirtualMachine vm = new VirtualMachine(id, client);
			vm.delete();
			System.out.println("Virtual Machine deleted");
		} catch (Exception e){
			System.out.println("Error while deleting Virtual Machine");
		}
	}
	
	public void migrateVM(Integer idVM, Integer idHost){
		try{
			VirtualMachine vm = new VirtualMachine(idVM, client);
			vm.migrate(idHost);
			System.out.println("Virtual Machine deleted");
		} catch (Exception e){
			System.out.println("Error while deleting Virtual Machine");
		}
	}
	
}
