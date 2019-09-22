package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Order;import entity.User;
import util.DBUtil;
import util.DateUtil;

public class OrderDAO {
	public void add(Order item) {
		String sql="insert into order_ values(?,?,?)";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			p.setInt(1, item.getId());
			p.setInt(2, item.getUser().getId());
			p.setDate(3, item.getDate());
			p.execute();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		User user=new UserDAO().getUser(1);
		
		new OrderDAO().add(new Order(3,user, new DateUtil().getDate()));
		System.out.println("dad");
	}
}
