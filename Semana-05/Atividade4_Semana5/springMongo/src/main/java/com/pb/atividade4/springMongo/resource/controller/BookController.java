package com.pb.atividade4.springMongo.resource.controller;

import com.pb.atividade4.springMongo.domain.Book;
import com.pb.atividade4.springMongo.dto.BookDTO;
import com.pb.atividade4.springMongo.repository.BookRepository;
import com.pb.atividade4.springMongo.resource.util.URL;
import com.pb.atividade4.springMongo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/findAuthor")
    public ResponseEntity<List<Book>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Book> obj = service.findByAuthor(text);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/findYear")
    public ResponseEntity<List<Book>> findByPubYear(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Book> obj = service.findByPubYear(text);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(){
        List<Book> list = service.findAll();
        List<BookDTO> listDto = list.stream().map(x -> new BookDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody BookDTO objDto){
        Book obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/insertMult")
    public ResponseEntity<Void> insertMult(@RequestBody List<BookDTO> objDtoList){
        List<Book> books = objDtoList
                .stream()
                .map(dto -> service.fromDTO(dto))
                .toList();
        books.forEach(book -> service.insert(book));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/up/{id}")
    public ResponseEntity<Void> update(@RequestBody BookDTO objDto, @PathVariable String id){
        Book obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.updateBook(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{title}")
    public ResponseEntity<Void> delete(@PathVariable String title){
        service.deleteByTitle(title);
        return ResponseEntity.noContent().build();
    }
}
