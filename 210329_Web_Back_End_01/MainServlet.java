package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import dto.Product;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
     ArrayList<Product> list = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String info = request.getParameter("info");
		response.setContentType("text/html;charset=utf-8");
		
		list.add(new Product(name, price, info));
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("	<body>");
		out.println("	<div align=\"center\">");
		out.println("<h3>등록된 상품 정보입니다.</h3>");
		out.print("<table>");
		out.print("	<tr>");
		out.print("		<th>상품명</th>");
		out.print("		<th>상품 가격</th>");
		out.print("		<th>상품 정보</th>");
		out.print("	</tr>");
		for(int i=0;i<list.size();i++) {
			out.print("	<tr>");
			out.print("		<td>"+list.get(i).getName()+"</td>");
			out.print("		<td>"+list.get(i).getPrice()+"</td>");
			out.print("		<td>"+list.get(i).getDes()+"</td>");
			out.print("	</tr>");
		}
		out.print("</table>");
		out.println("	</div>");
		out.println("	</body>");
		out.println("</html>");
		
	}

}
