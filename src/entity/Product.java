package entity;

public class Product {
	int id;
	String name;
	double price;
	
	public Product(int aid,String aname,double aprice) {
		id=aid;
		name=aname;
		price=aprice;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="[id:"+id+" name:"+name+ " price:"+price+"]";
		return str;
	}
}
