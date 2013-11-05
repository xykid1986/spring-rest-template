package com.xiao.temp.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.data.domain.Page;

import com.xiao.temp.domain.PageWrapper.Content;

@XmlRootElement(name="data")
@XmlSeeAlso({Content.class, Book.class})
public class PageWrapper<E> {
	
	private Content<E> content;
	private int totalPages;
	private int size;
	private int number;
	private String sort;
	private int numberOfElements;
	private long totalElements;
	private boolean firstPage;
	private boolean lastPage;
	private boolean isPage;
	
	public PageWrapper(){
		content = new Content<E>(new ArrayList<E>());
	}
	
	public PageWrapper(Page<E> page){
		isPage = true;
		content = new Content<E>(page.getContent());
		number = page.getNumber();
		size = page.getSize();
		sort = page.getSort().toString();
		totalPages = page.getTotalPages();
		numberOfElements = page.getNumberOfElements();
		totalElements = page.getTotalElements();
		firstPage = page.isFirstPage();
		lastPage = page.isLastPage();
	}
	
	public PageWrapper(List<E> list){
		content = new Content<E>(list);
	}
	
	public PageWrapper(E obj){
		content = new Content<E>(new ArrayList<E>(Arrays.asList(obj)));
	}
	
	@XmlAnyElement(lax=true)
	public Content<E> getContent() {
		return content;
	}

	public void setContent(Content<E> content) {
		this.content = content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
	
	@XmlRootElement(name="content")
	public static class Content<E>{
		
		private List<E> items;
		
		Content(){
			items = new ArrayList<E>();
		}
		
		Content(List<E> list){
			this.items = list;
		}
		
		@XmlAnyElement(lax=true)
		public List<E> getList() {
			return items;
		}
		
		public void setList(List<E> list) {
			this.items = list;
		}
	}
}
