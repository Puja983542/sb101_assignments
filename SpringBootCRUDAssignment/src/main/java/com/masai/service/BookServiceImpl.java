package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookNotFoundException;
import com.masai.exception.NoDataFoundException;
import com.masai.model.Book;
import com.masai.repository.BookDao;


@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDao bDao;
	
	@Override
	public Book createBook(Book book) {
		
		return bDao.save(book);
	}

	@Override
	public List<Book> getAllBooks() throws NoDataFoundException {
		
		List<Book> books = bDao.findAll();
		
		if(books.size()>0) {
			return books;
		}else {
			throw new NoDataFoundException("No Books Found..");
		}
	}

	
	@Override
	public Book deleteBookByBookId(Integer bookId) throws BookNotFoundException {
		
		Book existingBook = bDao.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book does not exist with BookId :"+bookId));
	
	    bDao.delete(existingBook);
	    
	    return existingBook;
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		
		Optional<Book> opt = bDao.findById(book.getBookId());
		
		if(opt.isPresent()) {
			Book existingBook = opt.get();
			return bDao.save(book);
		}else
		   throw new BookNotFoundException("Invalid Book details...");
	}

	@Override
	public Book getBookByBookId(Integer bookId) throws BookNotFoundException {

 
		Optional<Book> opt =  bDao.findById(bookId);
		
		if(opt.isPresent()) {
			
			Book book = opt.get();
			return book;
		}else
			throw new BookNotFoundException("Book does not exist with bookId :"+bookId);
	}

	
	
	
}
