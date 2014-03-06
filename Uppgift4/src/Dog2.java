
public class Dog2 extends Mammal{
	private String stupid;
	
	public Dog2(String na, int nu, boolean s){
		super(na, nu);
		if(s == true){
			stupid = "stupid";
		}
		else{
			stupid = "not stupid";
		}
		
	}
	
	public String getInfo(){
		return ("The dog "+name+" nurses for "+nurses+" months and is "+stupid);
	}
}
