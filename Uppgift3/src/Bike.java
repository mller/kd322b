
public class Bike {
	private String color;
	private int price;
	private int size;
	private static int nbrOfBikes;
	
	/**Creates a bike with instance-variables limited by values in Constants.java and adds +1 to the total number of bikes*/
	public Bike(String c, int s, int p){
		nbrOfBikes++;
		for(int i = 0;i<Constants.colors.length;i++){
			if(c.equals(Constants.colors[i])){
				color = c;
				break;
			}
			else{
				color = "no color";
			}
		}
		if(s<Constants.MIN_SIZE){
			size = 8;
		}
		else if(s>Constants.MAX_SIZE){
			size = 28;
		}
		else{
			size = s;
		}
		
		if(p<Constants.MIN_PRICE){
			price = 0;
		}
		else if(p>Constants.MAX_PRICE){
			price = 3000;
		}
		else{
			price = p;
		}
	}
	
	/**Returns the color of the bike as a String*/
	public String getColor(){
		return color;
	}
	
	/**Returns the size of the bike as an integer*/
	public int getSize(){
		return size;
	}
	
	/**Returns the price of the bike as an integer*/
	public int getPrice(){
		return price;
	}
	
	/**Sets a new price of the bike and returns it as an integer*/
	public int setPrice(int p){
		price = p;
		return price;
	}
	
	/**Returns the total number of bikes*/
	public int getNbrOfBikes(){
		return nbrOfBikes;
	}
	

}
