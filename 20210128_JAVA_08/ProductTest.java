package com.ssafy.abc.excepte;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductTest {

	public static void main(String[] args) throws IOException{
		//int sirialNum, String name, int price, int amount
		ProductMgr manager= ProductMgr.getInstance();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		manager.add(new Refrigerator(12345,"BESFORK 양문형 냉장고",2000000,5,80));
		manager.add(new TV(55555,"QLED TV 55",1500000,5,45,"QLED"));
		manager.add(new TV(44444,"OLED TV 50",1000000,5,50,"OLED"));
		manager.add(new Refrigerator(22222,"삼성 냉장고",800000,5,65));
		manager.add(new TV(11111,"삼성 TV",200000,5,45,"LED"));
		while(true) {
			System.out.println("0.상품 가격 수정--1.상품추가--2.상품목록--3.상품검색--4.상품명으로 검색--5.상품삭제--6.특정가격이하상품검색--7.TV만 검색");
			System.out.println( "--8.냉장고만 검색--9.전체재고상품금액--R.400L이상의 냉장고--T.50inch이상의 TV--Q.종료");
			char num =br.readLine().charAt(0);
			if(num=='1') {
				System.out.println("1. TV    2. 냉장고");
				int ch = Integer.parseInt(br.readLine());
				
				if(ch==1) {
					System.out.println("상품번호 상품이름 상품가격 수량 인치 디스플레이유형을 차례대로 입력해주세요");
					st=new StringTokenizer(br.readLine()," ");
					manager.add(new TV(Integer.parseInt(st.nextToken()),st.nextToken(),Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken()));
				}else if(ch==2) {
					System.out.println("상품번호 상품이름 상품가격 수량 리터를 차례대로 입력해주세요");
					st=new StringTokenizer(br.readLine()," ");
					manager.add(new Refrigerator(Integer.parseInt(st.nextToken()),st.nextToken(),
							Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
				}
				manager.list();
			}else if(num=='0') {
				System.out.println("상품번호  수정 할 상품가격 차례대로 입력해주세요");
				st=new StringTokenizer(br.readLine()," ");
				manager.updatePrice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}else if(num=='2'){
				manager.list();
			}else if(num=='3'){
				System.out.println("검색하고 싶은 상품 번호를 입력하세요");
				int sirial=Integer.parseInt(br.readLine());
				manager.search(sirial);
			}else if(num=='4'){
				System.out.println("검색하실 상품이름을 입력해주세요");
				st=new StringTokenizer(br.readLine()," ");
				manager.searchName(st.nextToken());
			}else if(num=='5'){
				System.out.println("삭제하고 싶은 상품 번호를 입력하세요");
				int sirialNum=Integer.parseInt(br.readLine());
				manager.delete(sirialNum);
			}else if(num=='6') {
				System.out.println("원하시는 가격이하 상품 리스트를 보기위해 가격을 입력하세요");
				int price=Integer.parseInt(br.readLine());
				manager.priceList(price);
			}else if(num=='7') {
				manager.searchTV();
			}else if(num=='8') {
				manager.searchRe();
			}else if(num=='9') {
				manager.totalPrice();
			}else if(num=='Q'){
				break;
			}else if(num=='R') {
				manager.searchRe400();
			}else if(num=='T') {
				manager.searchTv50();
			}
		}	
		
	}

}
