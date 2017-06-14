import java.util.*;

public class ReferenceMonitor{

    /* The Reference Monitor stores a copy of the subjects and objects in the 
        SecureSystem */
    LinkedHashMap<String, Subject> rm_subjHash = new LinkedHashMap();
    LinkedHashMap<String, ObjectManager> rm_objHash = new LinkedHashMap();

    public void execute(InstructionObject x){
        if(x.valid == false){
            System.out.println("Bad Instruction");
        }
        else{
            Subject s = (Subject)rm_subjHash.get(x.subj);
            ObjectManager o = (ObjectManager)rm_objHash.get(x.obj);

            /* If the Subject and/or Object do not exist in the system */
            if(s == null || o == null){
                x.valid = false;
                System.out.println("Bad Instruction");
            }
            else if(x.type == 0){
                executeRead(s, o);
            }
            else{
                executeWrite(s, o, x.obj_val);
            }
        }
        printState();
    }

    /* Performs a READ based on the Simple Security Property */
    private void executeRead(Subject s, ObjectManager o){
        System.out.println(s.getName() + " reads " + o.getName());
        SecurityLevel subject_level = s.getLevel();
        SecurityLevel object_level = o.getLevel();
        if(subject_level.doesDom(object_level)){
            s.changeTemp(o.getVal());
        }
        else{
            s.changeTemp(0);
        }
    }

    /* Performs a WRITE based on the *-Property */
    private void executeWrite(Subject s, ObjectManager o, int val){
        System.out.println(s.getName() + " writes value " + val + " to " + o.getName());
        SecurityLevel subject_level = s.getLevel();
        SecurityLevel object_level = o.getLevel();
        if(object_level.doesDom(subject_level)){
            o.writeVal(val);
        }
    }

    /* When a Subject is introduced in SecureSystem, we also store it in the
       ReferenceMonitor's table of Subjects */
    public void newSubjAlert(String name, Subject subj){
        rm_subjHash.put(name, subj);
    }

    /* Creates a new Object */
    public void createNewObject(String name, SecurityLevel lvl){
        name = name.toLowerCase();
        ObjectManager obj = new ObjectManager(name, lvl); 
        rm_objHash.put(name, obj);
    }

    /* Prints the state of the system */
    public void printState(){
        Set subj_set = rm_subjHash.entrySet();
        Set obj_set = rm_objHash.entrySet();
        Iterator subj_iter = subj_set.iterator();
        Iterator obj_iter = obj_set.iterator();

        System.out.println("The current state is:");
        while(obj_iter.hasNext()){
            Map.Entry o = (Map.Entry)obj_iter.next();
            ObjectManager obj = (ObjectManager)o.getValue();
            System.out.println("\t" + o.getKey() + " has value: " + obj.getVal());
        }
        while(subj_iter.hasNext()){
            Map.Entry s = (Map.Entry)subj_iter.next();
            Subject subj = (Subject)s.getValue();
            System.out.println("\t" + s.getKey() + " has recently read: " + subj.getTemp());
        }
        System.out.println("");
    }

}