package com.ssafy.book.repository;

import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookRepo {
	List<Book> selectAll();
	Book select(String isbn);
	int insertbook(Book book);
	int updatebook(Book book);
	int deletebook(String isbn);
}
