package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;
import dto.Users;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		System.out.println(act);
		if("productin".equals(act)) {
			productin(request,response);
		}else if("productlist".equals(act)) {
			productlist(request,response);
		}else if("lastlist".equals(act)) {
			lastlist(request,response);
		}else if("search".equals(act)){
			search(request,response);
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
			String sql = "insert into product (id, name, price, des, adder, date) \n";
			sql+="values(?,?,?,?,?,?)";
			HttpSession s = request.getSession();
			Users user = (Users)s.getAttribute("userinfo");
			Date date = new Date();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, price);
			pstmt.setString(4, des);
			pstmt.setString(5, user.getUserId());
			pstmt.setString(6, dateFormat.format(date));
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
			while(rs.next()) {
				stuff = new Product();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
				list.add(stuff);
			}
			
			
			System.out.println(list);
			request.setAttribute("list", list);
//			response.sendRedirect(request.getContextPath()+"/productlist.jsp");
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
	
	private void lastlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Product stuff=null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			String sql = "select * from product \n";
			sql+="where adder = ?;";
			
			
			HttpSession s = request.getSession();
			Users user = (Users)s.getAttribute("userinfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			String path = "/lastlist.jsp";
			
			while(rs.next()) {
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
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sel = request.getParameter("sel1");
		String tg = request.getParameter("search_ip");
		System.out.println(tg);
		System.out.println(sel);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		ArrayList<Product> list = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			
			if(sel.equals("상품명")) {
				sql += "select * from product \n";
				sql += "where name = ?" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, tg);
			}else {
				sql += "select * from product \n";
				sql += "where  price < " + tg;
				pstmt = conn.prepareStatement(sql);
			}
			
			rs =pstmt.executeQuery();
			
			System.out.println(rs);
			String path = "/productlist.jsp";
			Product stuff=null;
			
			while(rs.next()) {
				stuff = new Product();
				stuff.setId(rs.getString("id"));
				stuff.setName(rs.getString("name"));
				stuff.setPrice(rs.getString("price"));
				stuff.setDes(rs.getString("des"));
				stuff.setAdder(rs.getString("adder"));
				list.add(stuff);
			}
			
			System.out.println(list);
			request.setAttribute("list", list);
//			response.sendRedirect(request.getContextPath()+"/productlist.jsp");
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
