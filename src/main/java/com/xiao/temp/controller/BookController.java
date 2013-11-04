package com.xiao.temp.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xiao.temp.domain.Book;
import com.xiao.temp.domain.Books;
import com.xiao.temp.service.BookService;

@Path("/book")
@Controller
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GET
	@Path("/test")
	public Response sayHi(){
		return Response.ok("Hi there!").build();
	}
	
	@POST
	@Path("/save")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response save(Book book){
		try{
			bookService.save(book);
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok("SUCCESS").build();
	}
	
	@GET
	@Path("/mybooks")
	public Response myBooks(){
		try{
			return Response.ok(new Books(bookService.findAll())).build();
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response find(@PathParam("id")Long id){
		try{
			return Response.ok(bookService.findOne(id)).build();
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

}

