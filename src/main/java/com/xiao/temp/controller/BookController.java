package com.xiao.temp.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.xiao.temp.domain.Book;
import com.xiao.temp.domain.PageWrapper;
import com.xiao.temp.service.BookService;

@Path("/book")
@Controller
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class BookController {
	
	@Autowired
	private BookService bookService;
	private static int pageSize = 10;
	
	@GET
	@Path("/test")
	public Response sayHi(){
		return Response.ok("Hi there!").build();
	}
	
	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response create(Book book){
		try{
			bookService.save(book);
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok("SUCCESS").build();
	}
	
	@PUT
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
	
	@DELETE
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response delete(Book book){
		try{
			bookService.delete(book);
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok("SUCCESS").build();
	}
	
	
	@GET
	@Path("/mybooks")
	public Response myBooks(@QueryParam("page")int page){
		try{
			page = page>0?page:1;
			return Response.ok(new PageWrapper<Book>(bookService.findAll(new PageRequest(page-1, pageSize, Sort.Direction.ASC,"id")))).build();
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
	
	
	@GET
	@Path("/name/{name}")
	public Response findByNamePage(@PathParam("name")String name, @QueryParam("page")int page){
		try{
			page = page>0?page:1;
			return Response.ok(new PageWrapper<Book>(bookService.findByName(name, new PageRequest(page-1, pageSize, Sort.Direction.ASC,"id")))).build();
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/author/{author}")
	public Response findByAuthorPage(@PathParam("author")String author, @QueryParam("page")int page){
		try{
			page = page>0?page:1;
			return Response.ok(new PageWrapper<Book>(bookService.findByAuthor(author, new PageRequest(page-1, pageSize, Sort.Direction.ASC,"id")))).build();
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

}

