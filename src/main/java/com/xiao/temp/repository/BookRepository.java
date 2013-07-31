package com.xiao.temp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xiao.temp.domain.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
