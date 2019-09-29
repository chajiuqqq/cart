import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.OrderItem;

public class DelOrderItemServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		List<OrderItem> list=(List<OrderItem>)request.getSession().getAttribute("orderitemlist");
		double money=0;
		
		Iterator<OrderItem> iterator=list.iterator();
		while(iterator.hasNext()){
			OrderItem item=iterator.next();
			if(item.getProduct().getId()==pid){
				money=item.getTotalPrice();
				iterator.remove();
			}
		}
		
		double totalMoney=(double)request.getSession().getAttribute("totalMoney");
		totalMoney-=money;
		request.getSession().setAttribute("totalMoney", totalMoney);
		
		response.sendRedirect("listcart.jsp");
	
	
	}
}
