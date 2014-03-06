
public class Human {
	private Dog dog;
	private String name;
	
	public Human(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public void buyDog(Dog d){
		dog = d;
	}
	
	public String getInfo(){
		if(dog != null){
			return (name+" �ger en hund som heter "+dog.getName());
		}
		
		else{
			return (name+" �ger ingen hund");
		}
	}
}
