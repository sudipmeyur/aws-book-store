package com.aws.spring.aws_book_store.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.spring.aws_book_store.domain.BookItem;
import com.aws.spring.aws_book_store.repository.BookItemRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookStoreController {
	
	public BookItemRepository repo;
	
	@GetMapping("/book/{id}")
	public BookItem getBook(@PathVariable String id) {
		BookItem book = new BookItem();
		book.setId(id);
		return repo.get(book);
	}
	
	@PostMapping("/book")
	public BookItem createBook(@RequestBody BookItem bookInfo) {
		return repo.create(bookInfo);
	}
	
	@PutMapping("/book/{id}")
	public void updateBook(@PathVariable String id,@RequestBody BookItem bookInfo) {
		if(bookInfo.getId().equals(id)) {
			repo.update(bookInfo);
		}
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable String id) {
		repo.delete(id);
	}

	

}
