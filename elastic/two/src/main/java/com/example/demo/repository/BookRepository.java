package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface BookRepository extends ElasticsearchRepository<Book,String> {
}
