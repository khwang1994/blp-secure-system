public class ObjectManager{

    String obj_name; // Name of the object
    int obj_val; // The valued stored by the object
    SecurityLevel obj_level; 

    public ObjectManager(String name, SecurityLevel lvl){
        this.obj_name = name;
        this.obj_level = lvl;
        this.obj_val = 0;
    }

    /* Returns the SecurityLevel of the object */
    public SecurityLevel getLevel(){
        return this.obj_level;
    }

    /* Returns the name of the object */
    public String getName(){
        return this.obj_name;
    }

    /* Returns the value stored in the object */
    public int getVal(){
        return this.obj_val;
    }

    /* Edits the value stored in the object */
    public void writeVal(int x){
        this.obj_val = x;
    }
}