package entity;

import java.sql.Date;
import java.util.List;

import DAO.OrderItemDAO;

public class Order {
	int id;
	User user;
	Date date;
	List<OrderItem> orderItems;
	
	public Order(int aid,User aUser,Date aDate) {
		id=aid;
		user=aUser;
		date=aDate;
		orderItems=searchOrderItems(aid);
	}
	
	public int getId() {
		return id;
	};
	public Date getDate() {
		return date;
	}
	public User getUser() {
		return user;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> searchOrderItems(int oid){
		OrderItemDAO dao=new OrderItemDAO();
		return dao.getItems(oid);
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[oid:"+id+ "  user:"+user.getId()+"  date:"+date+"]";
	}

	
}
