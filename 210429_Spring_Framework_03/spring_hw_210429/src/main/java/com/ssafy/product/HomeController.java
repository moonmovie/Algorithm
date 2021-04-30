package com.ssafy.product;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.product.dto.Product;
import com.ssafy.product.service.ProductServic;

/**
 * Handles requests for the application home page.
 * DB mysql mybatis mybatis-spring spring-jdbc dbcp => dependency필요 
 * dbcp 만들어서 mybatis 이용 spring 기반으로 사용할거임 meta-inf 톰캣이 시작하면서 먼저 살펴봄 이 때 dataSource 객체 생성
 * 
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductServic productservice;
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		
		return "index";
	}
	@PostMapping("/regist")
	public String regist(Product product) {
		
		productservice.insert(product);
		
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Locale locale, Model model) {
		List<Product> list = productservice.selectAll();
		model.addAttribute("products", list);
		return "list";
	}
	
	
}
