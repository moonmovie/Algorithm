package com.ssafy.product.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.UsersDto;
import com.ssafy.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	
	String errorPath = "/error/error500.jsp";
	
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
		}else if("delete".equals(act)) {
			delete(request,response);
		}else if("modify".equals(act)) {
			modify(request,response);
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDto product = new ProductDto();
		product.setId(request.getParameter("id"));
		product.setName(request.getParameter("name"));
		product.setPrice(request.getParameter("price"));
		product.setDes(request.getParameter("des"));
		
		try {
			ProductServiceImpl.getproductservice().updateProduct(product);
			System.out.println("modify");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/product?act=productlist").forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int res;
		try {
			System.out.println("delete");
			res = ProductServiceImpl.getproductservice().deleteProduct(id);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "삭제에 실패했습니다.");
			request.getRequestDispatcher(errorPath).forward(request, response);
		}
		request.getRequestDispatcher("/product?act=productlist").forward(request, response);
		
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
		String path = "/product.jsp";
		
		ProductDto product = new ProductDto();
		HttpSession s = request.getSession();
		
		if(s==null) {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}else {
			UsersDto user = (UsersDto)s.getAttribute("userinfo");
			
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setDes(des);
			product.setAdder(user.getUserId());
			
			try {
				ProductServiceImpl.getproductservice().insertProduct(product);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 쓰기에 실패했습니다");
				request.getRequestDispatcher(errorPath).forward(request, response);
			}
			
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}
		
	}
	
	private void productlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ProductDto> list=null;
		
		try {
			list = ProductServiceImpl.getproductservice().productList();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "리스트를 재 로딩해주세요");
			request.getRequestDispatcher(errorPath).forward(request, response);
		}
		System.out.println(list);
		
		String path = "/productlist.jsp";
		request.setAttribute("list", list);
//		response.sendRedirect(request.getContextPath()+"/productlist.jsp");
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	}
	
	private void lastlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		UsersDto user = (UsersDto)s.getAttribute("userinfo");
		ProductDto stuff=null;
		
		try {
			stuff = ProductServiceImpl.getproductservice().lastproductList(user.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "리스트를 재 로딩해주세요");
			request.getRequestDispatcher(errorPath).forward(request, response);
		}
		
		System.out.println(stuff);			
		request.setAttribute("lastlist", stuff);
		String path = "/lastlist.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	}
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String key  = request.getParameter("sel1");
		String word = request.getParameter("search_ip");
		System.out.println(key+" "+word);
		String path = "/productlist.jsp";
		List<ProductDto> list=null;
		try {
			list = ProductServiceImpl.getproductservice().searchProduct(key, word);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "리스트를 찾을 수 없습니다.");
			request.getRequestDispatcher(errorPath).forward(request, response);
		}
		
		System.out.println(list);
		request.setAttribute("list", list);
//		response.sendRedirect(request.getContextPath()+"/productlist.jsp");
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	}

}
