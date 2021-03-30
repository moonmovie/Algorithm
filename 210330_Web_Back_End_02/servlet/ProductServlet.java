package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dto.Product;
import dto.Users;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		if("productin".equals(act)) {
			productin(request,response);
		}else if("productlist".equals(act)) {
			productlist(request,response);
		}else if("lastlist".equals(act)) {
			lastlist(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	private void productin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String des = request.getParameter("info");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			String sql = "insert into product (id, name, price, des, adder) \n";
			sql+="values(?,?,?,?,?)";
			HttpSession s = request.getSession();
			Users user = (Users)s.getAttribute("userinfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, price);
			pstmt.setString(4, des);
			pstmt.setString(5, user.getUserId());
			
			rs =pstmt.executeUpdate();
			
			String path = "/product.jsp";
			
			if(rs!=0) {
				request.setAttribute("msg", 1);
			}else {
				request.setAttribute("msg", 0);
			}
			
			
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void productlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Product> list = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			String sql = "select * from product";
			
			pstmt = conn.prepareStatement(sql);

			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			String path = "/productlist.jsp";
			Product stuff=null;
			if(rs.next()) {
				stuff = new Product();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
				list.add(stuff);
			}
			
			
//			response.sendRedirect(request.getContextPath()+"/productlist.jsp");
			request.setAttribute("list", list);
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
			System.out.println(list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void lastlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Product stuff=null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			String sql = "select * from product \n";
			sql+="where adder = ?";
			
			HttpSession s = request.getSession();
			Users user = (Users)s.getAttribute("userinfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			String path = "/lastlist.jsp";
			
			if(rs.next()) {
				stuff = new Product();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
			}
			
			System.out.println(stuff);			
			request.setAttribute("lastlist", stuff);

			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
