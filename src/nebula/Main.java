package nebula;


public class Main {
	
	public static void vm_do(String[] args,VirtualMachines vms){
		switch(args[1]){
			case "list":
				vms.displayVM();
				break;
			case "delete":
			case "suspend":
			case "restart": 
			case "detail":
				if(args.length==2 ){
					P(help_text);
				}else{
					String id=args[2];
					int parsedId = 0;
					try{
						parsedId = Integer.parseInt(args[2]);
					}catch(NumberFormatException nfe){
						System.out.println("error: ID must be an integer");
					}
					switch(args[1]){
					case "delete":
						vms.deleteVM(parsedId);
						break;
					case "suspend":
						vms.suspendVM(parsedId);
						break;
					case "restart":
						vms.restartVM(parsedId);
						break;
					default:
						P(help_text);
						break;
					}
				}
				break;
			case "migrate":
				if(args.length<4){
					//print usage
				}else{
					String vm_id_str=args[2];
					String destination_node_str=args[3];
					int vm_id=0;int destination_node=0;
					try{
						vm_id=Integer.parseInt(vm_id_str);
						destination_node=Integer.parseInt(destination_node_str);
					}catch(NumberFormatException nfe){
						System.out.println("error: ID must be an integer");
					}
					
				}
			default:
				P(help_text);
		}
	}
	
	//nebula node [stuff]
	public static void node_do(String[] args,Nodes ns){
		switch(args[1]){
		case "list":
			ns.listNodes();
			break;
		default:
			P(help_text);
		}
	}
	public static void P(String arg){ System.out.println(arg); };
	public static String help_text= "nebula API tools\n";
	
	public static void main(String[] args) {

		if(args.length==0){
			P(help_text);
		}
		else{
			switch(args[0]){
			case "help":
				P(help_text);
				break;
			case "vm":
				if(args.length==1){
					P(help_text);
				}else{
					vm_do(args, new VirtualMachines());
				}
				break;
			case "node":
				node_do(args,new Nodes());
				break;
			case "version":
				(new Nebula()).getVersion();
				break;
			}
		}
	}

}
