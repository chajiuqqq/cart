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
	Random rand=new Random();
	int oid=Math.abs(rand.nextInt());
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新建订单
		
		User parentuser=(User)request.getSession().getAttribute("parentuser");
		if(parentuser==null){
			response.sendRedirect("login.jsp");
		}
		
		archiveOrder(parentuser);
		
		List<OrderItem> orderItemlist=(List<OrderItem>)request.getSession().getAttribute("orderitemlist");
		
		archiveOrderItem(orderItemlist);
		
		response.setContentType("text/html;charset=utf-8"); 
		response.getWriter().println("提交成功！");
		
	}
	private void archiveOrderItem(List<OrderItem> list) {
		OrderItemDAO orderItemDAO=new OrderItemDAO();
		for(OrderItem item:list){
			item.setOid(oid);
			orderItemDAO.add(item);
			System.out.println(item);
		}
//		list.clear();
	}
	private void archiveOrder(User parentuser) {

		OrderDAO orderDAO=new OrderDAO();
		orderDAO.add(new Order(oid,parentuser, DateUtil.getDate()));	
	}
}
