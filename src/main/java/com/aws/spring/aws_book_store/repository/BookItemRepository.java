package com.aws.spring.aws_book_store.repository;

import org.springframework.stereotype.Repository;

import com.aws.spring.aws_book_store.domain.BookItem;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

@Repository
@AllArgsConstructor
public class BookItemRepository {

	private DynamoDbTable<BookItem> bookItemTable;
	
	public BookItem create(BookItem bookItem) {
		bookItemTable.putItem(bookItem);
		return bookItem;
	}
	public BookItem get(BookItem bookItem) {
		return bookItemTable.getItem(bookItem);
	}
	public BookItem update(BookItem bookItem) {
		return bookItemTable.updateItem(bookItem);
	}
	public BookItem delete(String bookItemId) {
		Key deletekey = Key.builder().partitionValue(bookItemId).build();
		return bookItemTable.deleteItem(deletekey);
	}

}
