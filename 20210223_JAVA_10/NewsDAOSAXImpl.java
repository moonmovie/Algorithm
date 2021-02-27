package com.ssafy.news;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{
	List<News> list = new LinkedList<>();
	
	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return list;
	}
	
	@Override
	public News search(int index) {
		return null;
	}
	
	private void connectNews(String url) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		URL adress;
		try {
			parser = factory.newSAXParser();
			SAXHandler handler = new SAXHandler();
			adress = new URL(url);
			InputStream in =adress.openConnection().getInputStream();
			parser.parse(in, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	class SAXHandler extends DefaultHandler{
		StringBuilder sb;
		News n;
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(qName.equals("item")) {
			}
		}
	
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("title")) {
				n = new News();
				n.setTitle(sb.toString());
			}
			if(qName.equals("description")) {
				n.setDesc(sb.toString());
			}
			if(qName.equals("link")) {
				n.setLink(sb.toString());
			}
			if(qName.equals("item")) {
				list.add(n);
			}
			
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
				sb=new StringBuilder();
				sb.append(ch,start,length);
		}
		
	}
}
