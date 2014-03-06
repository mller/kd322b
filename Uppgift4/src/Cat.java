
public class Cat extends Mammal{
	private int lives;
	
	public Cat(String name, int nurses, int l){
		super(name, nurses);
		lives = l;
		
	}
	
	public String getInfo(){
		return ("The cat "+this.name+" nurses for "+this.nurses+" months and has "+lives+" lives");
	}
}
