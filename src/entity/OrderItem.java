package entity;

import DAO.ProductDAO;

public class OrderItem {
	Product product;
	int number;
	double totalPrice;
	public OrderItem(int id,int anumber) {
		// TODO Auto-generated constructor stub
		ProductDAO dao=new ProductDAO();
		product=dao.getProduct(id);
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
	
}
