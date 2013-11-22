package nebula;

public class Main {

	//nebula vm [stuff]
	public static void vm_do(String[] args){
		switch(args[1]){
			case "create":
			    //create a vm and print info
				break;
			case "list":
				//list vms (id/state) 
				break;
			case "destroy":
			case "stop":
			case "start": 
			case "detail":
				if(args.length==2){
					//print usage
				}else{
					String id=args[2];
					switch(args[1]){
					case "destroy":
						//destroy
						break;
					case "stop":
						//stop 
						break;
					case "start":
						//start vm
						break;
					case "detail":
						//detail
						break;
					}
				}
				break;
			case "migrate":
				if(args.length<4){
					//print usage
				}else{
					String vm_id=args[2];
					String destination_node=args[3];
					//migrate a vm from to destination
				}
		}
	}
	
	//nebula node [stuff]
	public static void node_do(String[] args){
		switch(args[1]){
		case "list":
			//stuff
			break;
		case "details":
			if(args.length==2){
				//print usage
			}else{
				String id=args[2];
				//details of a node
			}
		}
	}
	public static void P(String arg){ System.out.println(arg); };
	public static String help_text= "nebula API tool"
			+ "usage :    ";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					//print usage
				}
				
				break;
			case "node":
				node_do(args);
				break;
			case "version":
				//version of opennebula
				break;
			}
		}
	}

}
