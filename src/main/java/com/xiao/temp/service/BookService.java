package com.xiao.temp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.xiao.temp.domain.Book;

public interface BookService {
	public Book findOne(Long id);
	public void save(Book book);
	public List<Book> findAll(Pageable pageable);
	public List<Book> findByAuthor(String author);
	public List<Book> findByName(String name);
}
