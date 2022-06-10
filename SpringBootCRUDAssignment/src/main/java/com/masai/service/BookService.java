package com.masai.service;

import java.util.List;

import com.masai.exception.BookNotFoundException;
import com.masai.exception.NoDataFoundException;
import com.masai.model.Book;

public interface BookService {

	public Book createBook(Book book);
	
	public Book getBookByBookId(Integer bookId) throws BookNotFoundException;
	
	public List<Book> getAllBooks() throws NoDataFoundException;
	
	public Book deleteBookByBookId(Integer bookId) throws BookNotFoundException;
	
	public Book updateBook(Book book) throws BookNotFoundException;
}
