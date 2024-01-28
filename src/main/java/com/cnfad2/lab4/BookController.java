package com.cnfad2.lab4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/books")
public class BookController {
	private final List<Book> books = new ArrayList<Book>();
	
	@GetMapping
	public List<Book> getAllBooks() {
		return books;
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}
	
	@PutMapping("/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable int id) {
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getId() == id) {
				books.set(i, book);
				return "Book Updated";
			}
			
		}
		return "Unable to Find the book";
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable int id) {
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getId() == id) {
				books.remove(i);
				return "Book Deleted";
			}
		}
		return "Unable to Find the Book";
	}
}
