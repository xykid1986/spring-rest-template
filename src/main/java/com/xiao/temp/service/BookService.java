package com.xiao.temp.service;

import java.util.List;

import com.xiao.temp.domain.Book;

public interface BookService {
	public Book findOne(Long id);
	public void save(Book book);
	public List<Book> findAll();
}
