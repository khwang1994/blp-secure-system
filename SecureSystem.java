import java.io.*;
import java.util.*;

public class SecureSystem{

	LinkedHashMap<String, Subject> subj_hash = new LinkedHashMap();
	public static ReferenceMonitor box = new ReferenceMonitor();

	public static void main(String[] args) throws IOException{
		SecureSystem sys = new SecureSystem();
		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;
		sys.createSubject("lyle", low);
		sys.createSubject("hal", high);
		
		sys.getReferenceMonitor().createNewObject("Lobj", low);
		sys.getReferenceMonitor().createNewObject("Hobj", high);

		File f = new File(args[0]);
		Scanner input = new Scanner(f);
		System.out.println("Reading from file: " + f + "\n");

		while(input.hasNext()){
			String line = input.nextLine();
			InstructionObject inst = new InstructionObject(line);
			sys.getReferenceMonitor().execute(inst);
		}

	}

	public ReferenceMonitor getReferenceMonitor(){
		return SecureSystem.box;
	}

	public void createSubject(String name, SecurityLevel lvl){
		name = name.toLowerCase();
		Subject s = new Subject(name, lvl); 
		subj_hash.put(name, s);
		box.newSubjAlert(name, s);
	}
}