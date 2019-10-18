package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<OrderItem> getItems(int oid) {
		List<OrderItem> list=new ArrayList<>();
		OrderItem orderItem;
		String sql="select * from orderitem where oid=?";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			p.setInt(1, oid);
			ResultSet results=p.executeQuery();
			while(results.next()){
				int pid=results.getInt(2);
				int num=results.getInt(3);
				
				orderItem=new OrderItem(pid, num);
				list.add(orderItem);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public static void main(String[] args) {
		OrderItemDAO dao=new OrderItemDAO();
		List<OrderItem> list=dao.getItems(645296458);
		for(OrderItem x:list){
			System.out.println(x);
		}
	
	}
}
