package com.ssafy.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.UsersDto;
import com.ssafy.product.service.UserServiceImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainController extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
		if("login".equals(act)) {
			login(request,response);
		}else if("logout".equals(act)) {
			logout(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	private void login( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpwd");
		String path = "/product.jsp";
		UsersDto user=null;
		String errorPath = "/error/error500.jsp";
		try {
			user = UserServiceImpl.getUserService().login(userid, userpw);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "재 로그인 해주세요");
			request.getRequestDispatcher(errorPath).forward(request, response);
		}
		
		if(user != null) {
			//session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", user);
			
			//cookie 설정 로그인 되고 save check
			String idsv = request.getParameter("idsave");
			if("saveok".equals(idsv)) {
				Cookie cookie = new Cookie("save_id", userid);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60*24*365*40); // 초 기준임
				response.addCookie(cookie);
			}else {
				Cookie cookies[] = request.getCookies();
				String idck="";
				String saveid="";
				if(cookies!=null){
					for(Cookie c : cookies){
						if(c.getName().equals("save_id")){
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
				}
			}
		}else {
			request.setAttribute("msg", "가입되지 않은 아이디이거나, 잘못된 비밀번호 입니다.");
			path = "/Main.jsp";
//			response.sendRedirect(request.getContextPath()+"/user/login.jsp");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	
	}
	private void logout( HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userinfo");
		response.sendRedirect(request.getContextPath()+"/Main.jsp");
		
	}
	
}
