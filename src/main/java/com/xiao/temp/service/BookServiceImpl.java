package com.xiao.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.xiao.temp.domain.Book;
import com.xiao.temp.repository.BookRepository;

@Service("bookService")
@Transactional(readOnly=true)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book findOne(Long id) {
		return bookRepository.findOne(id);

	}

	public BookRepository getRepository() {
		return bookRepository;
	}

	public void setRepository(BookRepository repository) {
		this.bookRepository = repository;
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		return Lists.newArrayList(bookRepository.findAll());
		
	}

}

