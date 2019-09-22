package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.Order;
import entity.OrderItem;
import util.DBUtil;

public class OrderItemDAO {
	public void add(OrderItem item) {
		String sql="insert into orderitem values(null,?,?,?)";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			p.setInt(1, item.getProduct().getId());
			p.setInt(2, item.getNumber());
			p.setInt(3, item.getOid());
			p.execute();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		
		OrderItem item=new OrderItem(1, 2);
		
		item.setOid(100);
		new OrderItemDAO().add(item);
	}
}
