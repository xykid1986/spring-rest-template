package com.xiao.temp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Books {
	
	@XmlElement(name="book")
	List<Book> books;
	
	public Books(){
		books = new ArrayList<Book>();
	}
	
	public Books(List<Book> list){
		books = list;
	}
	
}
