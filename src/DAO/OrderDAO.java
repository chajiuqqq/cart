package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entity.Order;
import entity.OrderItem;
import entity.User;
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
	

	public List<Order> getOrders(int uid) {
		List<Order> list=new ArrayList<>();
		Order order;
		String sql="select * from order_ where uid=?";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			p.setInt(1, uid);
			ResultSet results=p.executeQuery();
			while(results.next()){
				int aoid=results.getInt(1);
				int auid=results.getInt(2);
				Date aDate=results.getDate(3);
				
				order=new Order(aoid, new UserDAO().getUser(auid), aDate);
				list.add(order);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		list.sort((d1,d2)->{return d2.getDate().compareTo(d1.getDate());});
		return list;
	}
	
	public static void main(String[] args) {
		OrderDAO dao=new OrderDAO();
		List<Order> list=dao.getOrders(10);
	for(Order x:list){
		System.out.println(x);
	}
	}
}
