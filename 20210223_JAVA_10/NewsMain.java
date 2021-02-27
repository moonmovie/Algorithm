package com.ssafy.news;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame f;
	JButton b;
	JList<News> li;
	JTextArea ta;
	INewsDAO dao;
	String url ="http://rss.etnews.com/Section902.xml";
	public NewsMain(){
//		dao= new NewsDAOSAXImpl();
		dao= new NewsDAODOMImpl();
		createGUI();
		addEvent();
		showList();
	}
	public void createGUI() {
		f=new JFrame("NewsList");
		JPanel p=new JPanel();
		b=new JButton("News List 호출");
		li = new JList();
		ta = new JTextArea();
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b,"North");
		p.add(li);
		f.setLayout(new GridLayout(2,1,5,5));
		f.add(p);
		f.add(ta);
		f.setSize(700,600);
		f.setVisible(true);
	}
	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		li.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				News n =(News)li.getSelectedValue();
				ta.setText(n.getDesc());
			}
		});
	}
	public void showList() {
		List<News> datas=dao.getNewsList(url);
		li.removeAll();
		News[] tempdata = new News[datas.size()];
		li.setListData(datas.toArray(tempdata));
	}
	public static void main(String[] args) {
		new NewsMain();
	}

}
