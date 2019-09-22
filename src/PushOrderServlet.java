import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderDAO;
import DAO.OrderItemDAO;
import entity.Order;
import entity.OrderItem;
import entity.User;
import util.DateUtil;

public class PushOrderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新建订单
		Random rand=new Random();
		OrderDAO orderDAO=new OrderDAO();
		
		int oid=Math.abs(rand.nextInt());
		User parentuser=(User)request.getSession().getAttribute("parentuser");
		if(parentuser==null){
			response.sendRedirect("login.jsp");
		}

		System.out.println("oid:"+oid);
		
		
		orderDAO.add(new Order(oid,parentuser, DateUtil.getDate()));
		
		OrderItemDAO orderItemDAO=new OrderItemDAO();
		List<OrderItem> list=(List<OrderItem>)request.getSession().getAttribute("orderitemlist");
		for(OrderItem item:list){
			item.setOid(oid);
			orderItemDAO.add(item);
			System.out.println(item);
		}
		list.clear();
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().println("提交成功！");
		
	}
}
