package com.ssafy.abc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProdeuctTest {

	public static void main(String[] args) throws IOException {
		
		TV[] tvAll = new TV[2];
		Refrigerator[] reAll = new Refrigerator[1];
		
		TV samsung = new TV(7777777,"OLED 55inch TV",3000000,5,55,"OLED");
		tvAll[0]=samsung;
		
		TV lg = new TV();
		lg.setName("UHD 55inch TV");
		lg.setProductNum(2222222);
		lg.setPrice(2000000);
		lg.setAmount(10);
		lg.setInch(55);
		lg.setDisplayType("UHD");
		
		tvAll[1]=lg;
		
		Refrigerator besforke = new Refrigerator(1234567,"BESFOKE 양문형 냉장고",2000000,6,187);
		reAll[0]=besforke;
		
		while(true) {
			System.out.println("--------------------선택하세요--------------------");
			System.out.println("\t" + "1.TV" + "\t" + "2.냉장고" + "\t" + " 3.상품목록전체");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String ch = br.readLine();
			int x = ch.charAt(0)-'0';
			if(x==1) {
				for(TV t:tvAll) {
					System.out.println(t.toString());
				}
				break;
			}else if(x==2) {
				for(Refrigerator r:reAll) {
					System.out.println(r.toString());
				}
				break;
			}else if(x==3) {
				for(TV t:tvAll) {
					System.out.println(t.toString());
				}
				System.out.println();
				for(Refrigerator r:reAll) {
					System.out.println(r.toString());
				}
				break;
			}
		}

		
	}

}
