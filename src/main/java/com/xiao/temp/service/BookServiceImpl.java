package com.xiao.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.temp.domain.Book;
import com.xiao.temp.repository.BookRepository;

@Service("bookService")
@Repository
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	@Transactional(readOnly=true)
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
	@Transactional(readOnly=true)
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Book> findByAuthor(String author, Pageable pageable) {
		return bookRepository.findByAuthor(author, pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Book> findByName(String name, Pageable pageable) {
		return bookRepository.findByName(name, pageable);
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);
	}

}

