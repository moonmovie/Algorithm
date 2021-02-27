package com.ssafy.news;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.stylesheets.LinkStyle;

public class NewsDAODOMImpl implements INewsDAO {
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
		URL adress = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		Document document;
		News n;
		try {
			adress = new URL(url);
			InputStream in = adress.openConnection().getInputStream();
			docBuilder = factory.newDocumentBuilder();
			document = docBuilder.parse(in);

			NodeList nodeList = document.getElementsByTagName("item");
			for(int i=0;i<nodeList.getLength();i++) {
				n = new News();
				for(Node nd =nodeList.item(i).getFirstChild(); nd!=null;nd=nd.getNextSibling()) {
					if(nd.getNodeName().equals("title")) {
						n.setTitle(nd.getTextContent());
					}
					if(nd.getNodeName().equals("link")) {
						n.setLink(nd.getTextContent());
					}
					if(nd.getNodeName().equals("description")) {
						n.setDesc(nd.getTextContent());
					}
				}
				list.add(n);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
