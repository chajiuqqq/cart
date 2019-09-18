import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import entity.Product;

public class ProductListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao=new ProductDAO();
		List<Product> products=dao.ListProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}
}
