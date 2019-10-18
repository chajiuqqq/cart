import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderDAO;
import DAO.OrderItemDAO;
import entity.Order;
import entity.User;

public class MyOrderServlet extends HttpServlet{
	
	OrderItemDAO orderItemDAO=new OrderItemDAO();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User curUser=getCurUser(request, response);
		List<Order> orders=getUserOrders(request, response,curUser.getId());

		request.getSession().setAttribute("myOrders", orders);
		request.getRequestDispatcher("myorders.jsp").forward(request, response);
		
	}
	public User getCurUser(HttpServletRequest request, HttpServletResponse response) {
		User user=(User)request.getSession().getAttribute("parentuser");
		return user;
	}
	public List<Order> getUserOrders(HttpServletRequest request, HttpServletResponse response,int uid) {
		OrderDAO orderDAO=new OrderDAO();
		return orderDAO.getOrders(uid);
		
	}
}
