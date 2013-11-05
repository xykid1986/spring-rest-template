package com.xiao.temp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Books {
	
	
	private List<Book> books;
	
	
	@XmlElement(name="book")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Books(){
		books = new ArrayList<Book>();
	}
	
	public Books(List<Book> list){
		books = list;
	}
	
}
