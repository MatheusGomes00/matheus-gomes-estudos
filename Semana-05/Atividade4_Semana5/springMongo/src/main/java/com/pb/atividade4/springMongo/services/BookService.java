package com.pb.atividade4.springMongo.services;

import com.pb.atividade4.springMongo.domain.Book;
import com.pb.atividade4.springMongo.dto.BookDTO;
import com.pb.atividade4.springMongo.repository.BookRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findByAuthor(String text){
        return repository.searchAuthor(text);
    }

    public List<Book> findByPubYear(String text){
        return repository.searchPubYear(text);
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book updateBook(Book obj){
        Book newObj = repository.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Book not found"));
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setAuthor(obj.getAuthor());
        newObj.setPubYear(obj.getPubYear());
        newObj.setType(obj.getType());
        newObj.setTitle(obj.getTitle());
    }

    public Book insert(Book obj){
        return repository.insert(obj);
    }

    public Book fromDTO(BookDTO objDto){
        return new Book(objDto.getId(), objDto.getTitle(), objDto.getAuthor(), objDto.getPubYear(), objDto.getType());
    }

    public void deleteByTitle(String title){
        repository.deleteByTitleContainingIgnoreCase(title);
    }

}
