package com.ssafy.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.dto.Book;
import com.ssafy.book.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<Book> selectAll() {

		return sqlsession.getMapper(BookRepo.class).selectAll();
	}
	
	public Book select(String isbn) {

		return sqlsession.getMapper(BookRepo.class).select(isbn);
	}

	@Override
	public int insertbook(Book book) {
		return sqlsession.getMapper(BookRepo.class).insertbook(book);
	}

	@Override
	public int updatebook(Book book) {
		return sqlsession.getMapper(BookRepo.class).updatebook(book);
	}

	@Override
	public int deletebook(String isbn) {
		return sqlsession.getMapper(BookRepo.class).deletebook(isbn);
	}

}
