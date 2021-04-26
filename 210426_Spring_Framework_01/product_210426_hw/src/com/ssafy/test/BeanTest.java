package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.configuration.ApplicationConfig;
import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;
import com.ssafy.model.service.ProductServicelmpl;

public class BeanTest {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ProductService productservice = context.getBean("pdtService", ProductServicelmpl.class);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Product pd=null;
		while(true) {
			System.out.println("1.insert | 2. update | 3. selectAll | 4. delete | 5.search product | 6. exit");
			int check = Integer.parseInt(br.readLine());
			if(check==1) {
				pd = new Product();
				System.out.print("id : ");
				pd.setId(br.readLine());
				System.out.print("name : ");
				pd.setName(br.readLine());
				System.out.print("price : ");
				pd.setPrice(br.readLine());
				System.out.print("des : ");
				pd.setDescription(br.readLine());
				
				productservice.insert(pd);
				
				System.out.println("================================== product 목록 ================================== ");
				System.out.println("품목번호\t품목이름\t가격\t\t\t\t내용");
				System.out.println("----------------------------------------------------------------");
				
				List<Product> list = productservice.selectAll();
				for(Product p : list) {
					System.out.println(p);
				}
				
			}else if(check==2) {
				pd = new Product();
				System.out.print("기존 품목 id : ");
				pd.setId(br.readLine());
				System.out.print("name : ");
				pd.setName(br.readLine());
				System.out.print("price : ");
				pd.setPrice(br.readLine());
				System.out.print("des : ");
				pd.setDescription(br.readLine());
				
				int rs = productservice.update(pd);
				if(rs==1) {
					System.out.println("정상적으로 수정되었습니다.");
				}else {
					System.out.println("다시 시도해 주세요.");
				}
			}else if(check==3) {
				System.out.println("================================== product 목록 ================================== ");
				System.out.println("\t품목번호\t\t품목이름\t\t가격\t\t내용");
				System.out.println("----------------------------------------------------------------");
				
				List<Product> list = productservice.selectAll();
				for(Product p : list) {
					System.out.println(p);
				}
			}else if(check==4) {
				System.out.print("삭제 할 id : ");
				String id = br.readLine();
				int rs = productservice.delete(id);
				if(rs==1) {
					System.out.println("정상적으로 삭제되었습니다.");
				}else {
					System.out.println("다시 시도해 주세요.");
				}
			}else if(check==5) {
				System.out.print("검색 할 id : ");
				String id = br.readLine();
				Product p = productservice.select(id);
				System.out.println("================================== product 목록 ================================== ");
				System.out.println("\t품목번호\t\t품목이름\t\t가격\t\t내용");
				System.out.println("----------------------------------------------------------------");
				System.out.println(p);
			}else if(check==6) {
				break;
			}
			
		}
		
		
		
	}

}
