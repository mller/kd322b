
public class Main {
	public static void main(String[] args) {
		BikeStore bikes = new BikeStore();
		
		bikes.addBike("red", 20, 2500);
		bikes.addBike("green", 18, 2100);
		bikes.addBike("black", 22, 2800);
		bikes.addBike("white", 17, 2000);
		bikes.addBike("green", 20, 1900);
		bikes.addBike("black", 15, 1800);
		bikes.addBike("red", 29, 3100);
		bikes.addBike("yellow", 21, 2600);
		bikes.addBike("blue", 18, 1900);
		bikes.addBike("black", 12, 1300);
		
		System.out.println(bikes.getAllBikes());
	}

}
