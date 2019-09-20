import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.OrderItem;

public class AddIntoCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<OrderItem> list=null;
//		Double totalMoney=null;
		double totalMoney=0.0;
		
		if(request.getSession().getAttribute("orderitemlist")==null){
			list=new ArrayList<>();
			request.getSession().setAttribute("orderitemlist", list);
		}else{
			list=(List<OrderItem>)request.getSession().getAttribute("orderitemlist");//获取了引用
		}
		
		if(request.getSession().getAttribute("totalMoney")!=null){
			totalMoney=(double)request.getSession().getAttribute("totalMoney");//获取了他的字面值，不是引用
		}
		
		int id=Integer.parseInt(request.getParameter("pid"));
		int num=Integer.parseInt(request.getParameter("selectnumber"));
		
		OrderItem item=new OrderItem(id, num);
		list.add(item);
		totalMoney+=item.getTotalPrice();
		request.getSession().setAttribute("totalMoney", totalMoney);//totalMoney对应的是基本数据类型，所以要重新设置attr
		
		request.getRequestDispatcher("listProduct").forward(request, response);
		
	}
}
