package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import entity.User;
import util.DBUtil;

public class UserDAO {
	public List<User> listUser() {
		String sql="select * from user";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			List<User> lists=new ArrayList<>();
			ResultSet results=p.executeQuery();
			while(results.next()){
				int aid=results.getInt("id");
				String aname=results.getString("name");
				String ausername=results.getString("username");
				String apassword=results.getString("password");
				User item=new User(aid, aname, ausername, apassword);
				lists.add(item);
			}
			return lists;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean confirmUser(String username,String password) {
		String sql="select count(*) from user where username=? and password=?";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			
			p.setString(1, username);
			p.setString(2, password);
			
			ResultSet results=p.executeQuery();
			int num=0;
			while(results.next()){
				num=results.getInt(1);
				
			}
			
			return num!=0;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public boolean checkUserExisted(String username) {
		String sql="select count(*) from user where username=? ";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			
			p.setString(1, username);
		
			ResultSet results=p.executeQuery();
			int num=0;
			while(results.next()){
				num=results.getInt(1);
				
			}
			
			return num!=0;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public void addUser(String username,String password,String name) {
		String sql="insert into user values(null,?,?,?)";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			
			p.setString(1, name);
			p.setString(2, username);
			p.setString(3, password);
			p.execute();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	public String getName(String username) {
		String sql="select name from user where username=? ";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			
			p.setString(1, username);
		
			ResultSet results=p.executeQuery();
			String name=null;
			while(results.next()){
				name=results.getString(1);
				
			}
			
			return name;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public int getID(String username) {
		String sql="select id from user where username=? ";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			
			p.setString(1, username);
		
			ResultSet results=p.executeQuery();
			int id=0;
			while(results.next()){
				id=results.getInt(1);
				
			}
			
			return id;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public User getUser(int id) {
		String sql="select * from user where id=? ";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			
			p.setInt(1, id);
		
			ResultSet results=p.executeQuery();
			
			while(results.next()){
				String name=results.getString(2);
				String uname=results.getString(3);
				String pw=results.getString(4);
				User user=new User(id,name, uname, pw);
				return user;
			}
			
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new UserDAO().getUser(1));
	}
}
