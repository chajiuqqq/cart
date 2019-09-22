package entity;

import DAO.ProductDAO;

public class OrderItem {
	Product product;
	int number;
	double totalPrice;
	int oid;
	
	public OrderItem(int pid,int anumber) {
		// TODO Auto-generated constructor stub
		ProductDAO dao=new ProductDAO();
		product=dao.getProduct(pid);
		number=anumber;
		totalPrice=calTotalPrice(product.getPrice(), anumber);
	}
	
	
	private double calTotalPrice(double singlePrice,int number) {
		return singlePrice*number;
	}
	
	public Product getProduct() {
		return product;
	}
	public int getNumber() {
		return number;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getOid() {
		return oid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string="["+product.getName()+" "+number+"]";
		return string;
	}
}
