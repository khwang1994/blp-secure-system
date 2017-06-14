public class SecurityLevel{

    public final static SecurityLevel LOW = new SecurityLevel(0);
    public final static SecurityLevel HIGH = new SecurityLevel(1);

    private int val = 0;

    public SecurityLevel(int val){
        this.val = val;
    }

    /* Determines if this SecurityLevel dominates SecurityLevel x */
    public boolean doesDom(SecurityLevel x){
        return this.val >= x.val;
    }
}