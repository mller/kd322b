import java.util.ArrayList;


public class BikeStore {
	private String newBike;
	ArrayList<Bike> bikes = new ArrayList<Bike>();
	
	/**Loops through the array and ads all bikes in a string called allBikes*/
	public String getAllBikes(){
		String allBikes="";
				 
		for(int i = 0;i<bikes.size();i++){
			allBikes=allBikes+("Color: "+bikes.get(i).getColor()+"\tTire size: "+bikes.get(i).getSize()+"\tPrice:"+bikes.get(i).getPrice()+"$\n");
		}
		return allBikes;
	}
	
	/**Adds a bike in the array based on what the user puts in the text fields*/
	public void addBike(String c, int s, int p){
		bikes.add(new Bike(c, s, p));
	}
}
