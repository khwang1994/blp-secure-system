public class InstructionObject{

    public static final int READ = 0;
    public static final int WRITE = 1;

    String[] inst_arr; // The instruction stored in an array
    int type; // WRITE or READ, otherwise -1
    boolean valid; // Is this a valid instruction?
    String subj; // Subject referenced by the instruction
    String obj; // ObjectManager referenced by the instruction
    int obj_val; // The value provided by ObjectManager obj

    public InstructionObject(String x){
        inst_arr = x.split("[ ]+");
        type = findType(inst_arr[0]);
        valid = findValid(type, inst_arr.length);

        if(valid){
            subj = inst_arr[1];
            obj = inst_arr[2];
            if(type == WRITE){
                obj_val = Integer.parseInt(inst_arr[3]);
            }
        }
        else{
            subj = null;
            obj = null;
            obj_val = -1;
        }
    }
    /* Determines if the instruction is a READ or WRITE one */
    private int findType(String x){
        if(x.toLowerCase().equals("write")){
            return WRITE;
        }
        else if(x.toLowerCase().equals("read")){
            return READ;
        }
        else{
            return -1;
        }
    }
    /* Determines if the given instruction is valid */
    private boolean findValid(int type, int len){
        if(type == WRITE && len == 4
            || type == READ && len == 3){
            return true;
        }
        else{
            return false;
        }
    }
}