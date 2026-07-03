package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET - Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        System.out.println("📚 GET all books");
        return bookService.getAllBooks();
    }

    // GET - Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        System.out.println("📖 GET book by ID: " + id);
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    // POST - Create new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        System.out.println("📝 POST create book: " + book.getTitle());
        return bookService.saveBook(book);
    }

    // PUT - Update book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        System.out.println("🔄 PUT update book: " + id);
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    // DELETE - Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        System.out.println("🗑️ DELETE book: " + id);
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // GET - Search books by title
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        System.out.println("🔍 SEARCH books: " + title);
        return bookService.searchBooks(title);
    }
}
