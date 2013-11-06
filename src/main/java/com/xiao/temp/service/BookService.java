package com.xiao.temp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiao.temp.domain.Book;

public interface BookService {
	public Book findOne(Long id);
	public void save(Book book);
	public Page<Book> findAll(Pageable pageable);
	public List<Book> findByAuthor(String author);
	public List<Book> findByName(String name);
	Page<Book> findByAuthor(String author, Pageable pageable);
	Page<Book> findByName(String name, Pageable pageable);
	void delete(Book book);
}
