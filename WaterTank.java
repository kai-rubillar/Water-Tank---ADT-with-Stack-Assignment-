package test;


public class WaterTank {

	private String name;
	private int[] buckets;
	private int top;
	
	public WaterTank() {
		this.name = "Standard Tank";
		this.buckets = new int[5];
		this.top = -1;
		
		System.out.println(name + " created no-arguement constructor");
	}
	public WaterTank(String name, int capacity) {
		this.name = name;
		this.buckets = new int[capacity];
		this.top = -1;
		System.out.println(name + ": Holds" + capacity + "buckets.");
	}
	
	public void pour(int liters) {
		if (top == buckets.length - 1) {
			System.out.println("OVERFLOW: " + name + " is full." + liters + "L spilled on the floor");
			return;
		}
		top++;
		buckets[top] = liters;
		System.out.println("Poured " + liters + "L into " + name);
		
	}
	public int drain() {
		if (isEmpty()) {
			System.out.println("UNDERFLOW");
			return 0;
		}
		int liters = buckets[top];
		top--;
		System.out.println("Drained " + liters + "L from " + name);
		return liters;
	}
	public int bucketCount(){
		return top + 1;
	}
	public int checktop() {
		if (isEmpty()) {
			System.out.println(name + " is empty");
			return 0;
		}
		return buckets[top];
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public static void main(String[] args){
		WaterTank tank1 = new WaterTank();
		tank1.pour(10);
		tank1.pour(20);
		tank1.pour(15);
		System.out.println("Top bucket: " + tank1.checktop() + "L");
		tank1.drain();
		System.out.println("Bucket left: " + tank1.bucketCount() + "| Total water: + "
				+ tank1.bucketCount());
		
		WaterTank tank2 = new WaterTank("Mini Tank", 3);
		tank2.pour(5);
		tank2.pour(10);
		tank2.pour(15);
		tank2.pour(20);
		tank2.drain();
		tank2.drain();
		tank2.drain();
		tank2.drain();
		
		System.out.println("Is the tank emtpy? " + tank2.isEmpty());
	}		
}
