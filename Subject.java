public class Subject{

	String subj_name;
	int subj_temp;
	SecurityLevel subj_level;

	public Subject(String subj_name, SecurityLevel subj_level){
		this.subj_name = subj_name;
		this.subj_level = subj_level;
		this.subj_temp = 0;
	}

	/* Returns the SecurityLevel of the Subject */
	public SecurityLevel getLevel(){
		return this.subj_level;
	}

	/* Returns the subject's name */
	public String getName(){
		return this.subj_name;
	}

	/* Returns the temporary value that the subject most recently read */
	public int getTemp(){
		return this.subj_temp;
	}

	/* Stores a new temp value for the subject, indicating that it is reading
		a new value */
	public void changeTemp(int x){
		this.subj_temp = x;
	}
}