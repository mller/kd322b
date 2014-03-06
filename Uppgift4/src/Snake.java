
public class Snake extends Animal{
	private String p;
	
	public Snake(String na, boolean poisonous){
		super(na);
		if(poisonous){
			p = "poisonous";
		}
		else{
			p = "not poisonous";
		}
		
	}
	
	public String getInfo(){
		return ("The snake "+name+" is "+p);
	}

}
