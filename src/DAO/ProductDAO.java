package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import util.DBUtil;

public class ProductDAO {
	public List<Product> ListProduct() {
		String sql="select * from product";
		try(Connection c=new DBUtil().getConnection();
				PreparedStatement p=c.prepareStatement(sql);){
			List<Product> lists=new ArrayList<>();
			ResultSet results=p.executeQuery();
			while(results.next()){
				int aid=results.getInt("id");
				String aname=results.getString("name");
				double aprice=results.getDouble("price");
				Product item=new Product(aid, aname, aprice);
				lists.add(item);
			}
			return lists;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new ProductDAO().ListProduct());
	}
}
