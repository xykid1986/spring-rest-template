package com.xiao.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
		
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}

	@Override
	public Page<Book> findByAuthor(String author, Pageable pageable) {
		return bookRepository.findByAuthor(author, pageable);
	}

	@Override
	public Page<Book> findByName(String name, Pageable pageable) {
		return bookRepository.findByName(name, pageable);
	}

}

