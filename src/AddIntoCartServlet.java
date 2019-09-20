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
			list=(List<OrderItem>)request.getSession().getAttribute("orderitemlist");//��ȡ������
		}
		
		if(request.getSession().getAttribute("totalMoney")!=null){
			totalMoney=(double)request.getSession().getAttribute("totalMoney");//��ȡ����������ֵ����������
		}
		
		int id=Integer.parseInt(request.getParameter("pid"));
		int num=Integer.parseInt(request.getParameter("selectnumber"));
		
		OrderItem item=new OrderItem(id, num);
		list.add(item);
		totalMoney+=item.getTotalPrice();
		request.getSession().setAttribute("totalMoney", totalMoney);//totalMoney��Ӧ���ǻ����������ͣ�����Ҫ��������attr
		
		request.getRequestDispatcher("listProduct").forward(request, response);
		
	}
}
