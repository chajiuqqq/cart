package entity;

import java.sql.Date;

public class Order {
	int id;
	User user;
	Date date;
	public Order(int aid,User aUser,Date aDate) {
		id=aid;
		user=aUser;
		date=aDate;
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
}
