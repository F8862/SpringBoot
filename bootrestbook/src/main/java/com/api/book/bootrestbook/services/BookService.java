package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /*
     * private static List<Book> list = new ArrayList<>();
     * static {
     * 
     * list.add(new Book(12, "Java", "XYZ"));
     * list.add(new Book(13, "Python", "ABC"));
     * list.add(new Book(14, "C", "LMN"));
     * list.add(new Book(15, "C++", "PQR"));
     * 
     * }
     */

    // get All books
    public List<Book> getAllBooks() {
        // return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding book
    public Book addBook(Book b) {
        /*
         * list.add(b);
         * return b;
         */
        Book result = this.bookRepository.save(b);
        return result;
    }

    // delete book
    public void deleteBook(int bookId) {
        /*
         * list = list.stream().filter(b -> {
         * if (b.getId() != bookId) {
         * return true;
         * }
         * return false;
         * }).collect(Collectors.toList());
         */
        // list = list.stream().filter(b -> b.getId() !=
        // bookId).collect(Collectors.toList());
        this.bookRepository.deleteById(bookId);
    }

    // update book
    public void updateBook(Book book, int bId) {
        /*
         * list = list.stream().map(b -> {
         * if (b.getId() == bId) {
         * b.setTitle(book.getTitle());
         * b.setAuthor(book.getAuthor());
         * }
         * return b;
         * }).collect(Collectors.toList());
         */

        book.setId(bId);
        this.bookRepository.save(book);
    }
}
