package com.ssafy.book.service;

import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookService {
	List<Book> selectAll();
	Book select(String isbn);
	int insertbook(Book book);
	int updatebook(Book book);
	int deletebook(String isbn);
}
