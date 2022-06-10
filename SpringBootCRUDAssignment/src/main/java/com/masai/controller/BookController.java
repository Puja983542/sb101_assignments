package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bService;

	
	@PostMapping("/books")
	public ResponseEntity<Book> saveBookHandler(@RequestBody Book book){
		
		Book savedBook = bService.createBook(book);
		
		return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooksHandler(){
		
		List<Book> books = bService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{bookId}")
	public Book deleteBookHandler(@PathVariable("bookId") Integer bookId) {
		
		return bService.deleteBookByBookId(bookId);
		
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book){
		
		Book updatedBook = bService.updateBook(book);
	
		return new ResponseEntity<Book>(updatedBook,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBookByBookIdHandler(@PathVariable("bookId") Integer bookId){
		
		return bService.getBookByBookId(bookId);
	}

}
