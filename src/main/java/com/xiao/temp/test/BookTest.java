package com.xiao.temp.test;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.xiao.temp.domain.Book;
import com.xiao.temp.service.BookService;

public class BookTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:/spring/application-config.xml");
		ctx.refresh();
		
	    BookService bs = ctx.getBean("bookService",BookService.class);
	    /*
	    Book book = new Book();
	    book.setName("Tow cities");
	    book.setAuthor("Yi Xiao");
	    bs.save(book);
	    */
	    
	   Page<Book> find = bs.findAll(new PageRequest(2,10));
	   Book b = bs.findOne(1l);
	   b.setName("YYYYYYYYY");
	   System.out.println(b);
	   bs.save(b);
	   System.out.println(bs.findOne(1l));
	}
}
