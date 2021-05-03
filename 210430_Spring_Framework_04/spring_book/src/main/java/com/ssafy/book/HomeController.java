package com.ssafy.book;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.book.dto.Book;
import com.ssafy.book.dto.User;
import com.ssafy.book.service.BookService;
import com.ssafy.book.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
		@Autowired
		private UserService userservice;
		
		@Autowired
		private BookService bookservice;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	@PostMapping("/login")
	public String login(User u, HttpSession session, HttpServletRequest request ) {
		logger.info("/login");
		User user = userservice.login(u);
		if(user != null) {
			session = request.getSession();
			session.setAttribute("userinfo", user);
			System.out.println(user);
		}
		System.out.println((User)session.getAttribute("userinfo"));
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		logger.info("/booklist");
		List<Book> list = bookservice.selectAll();
		System.out.println(list);
		model.addAttribute("books", list);
		return "list";
	}
	
	@GetMapping("/revisebook")
	public String revisebook(String isbn,Model model) {
		logger.info("/revisebook");
		System.out.println(isbn);
		Book book = bookservice.select(isbn);
		model.addAttribute("book",book);
		return "revise";
	}
	
	@PostMapping("/revise")
	public String revise(Book book) {
		logger.info("/revise");
		System.out.println(book);
		bookservice.updatebook(book);
		return "redirect:/list";
		
	}
	@GetMapping("/regist")
	public String regist(Book book) {
		logger.info("/regist");
		
		return "regist";
		
	}
	
	@PostMapping("/bookregist")
	public String bookregist(Book book) {
		logger.info("/bookregist");
		System.out.println(book);
		bookservice.insertbook(book);
		return "redirect:/list";
	}
	
	@PostMapping("/delete")
	public String delete(Book book) {
		logger.info("/delete");
		bookservice.deletebook(book.getIsbn());
		return "redirect:/list";
	}
	
}
