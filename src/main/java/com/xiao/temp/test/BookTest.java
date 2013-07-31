package com.xiao.temp.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.xiao.temp.domain.Book;
import com.xiao.temp.service.BookService;

public class BookTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:/spring/application-config.xml");
		ctx.refresh();
	    BookService bs = ctx.getBean("bookService",BookService.class);
	    Book book = new Book();
	    book.setName("Tow cities");
	    book.setAuthor("Yi Xiao");
	    bs.save(book);
	    
	    Book find = bs.findOne(1l);
	    System.out.println(find);
	}
}
