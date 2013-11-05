package com.xiao.temp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xiao.temp.domain.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	List<Book> findByAuthor(String author);
	List<Book> findByName(String name);
}
