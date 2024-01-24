package tw.com.beans;

public class Fruit {
  private String name;
  private String key;
  private int count;
  private int price;
  
	   public Fruit(String name, String key, 
			   int price) {
		super();
		this.name = name;
		this.key = key;
		this.price = price;
	}
public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
  
	public int total() {
		return this.getPrice() * this.getCount();
	}
  
}
