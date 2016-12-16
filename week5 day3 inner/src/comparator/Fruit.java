package comparator;


public class Fruit {
	private String name;
	private String color;
	private int price;
	private int kcal;
	
	public Fruit() {}

	public Fruit(String name, String color, int price, int kcal) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", color=" + color + ", price=" + price + ", kcal=" + kcal + "]";
	}
	
	
}
