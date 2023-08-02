package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

//@Controller
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // get all books handler
    @GetMapping("/books")
    // @ResponseBody //if we use @RestController then no need to use @ResponseBody
    // public String getBooks() {
    // public Book getBooks() {
    // public List<Book> getBooks() {
    public ResponseEntity<List<Book>> getBooks() {
        /*
         * Book book = new Book();
         * book.setId(121);
         * book.setTitle("Java complete reference");
         * book.setAuthor("XYZ");
         */
        /* return this.bookService.getAllBooks(); */
        List<Book> list = this.bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();// build method will create new object of
                                                                       // ResponseEntity
        }
        return ResponseEntity.of(Optional.of(list));

    }

    // get single book handler
    @GetMapping("/books/{id}")
    // public Book getBook(@PathVariable("id") int id) {
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        // return bookService.getBookById(id);
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // new book handler
    @PostMapping("/books")
    // public Book addBook(@RequestBody Book book) {
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            System.out.println(b);
            // return ResponseEntity.of(Optional.of(b));
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // delete book handler
    @DeleteMapping("/books/{bookId}")
    // public void deleteBook(@PathVariable("bookId") int bookId) {
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // update book handler
    @PutMapping("/books/{bookId}")
    // public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int
    // bookId) {
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        /*
         * this.bookService.updateBook(book, bookId);
         * return book;
         */
        try {
            this.bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

}
